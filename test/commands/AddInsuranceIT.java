package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddInsurance;
import data.Datastore;
import java.util.Calendar;
import java.util.Date;
import models.Car;
import models.CarParks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddInsurance command
 * @author Wing
 */
public class AddInsuranceIT {

    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private String company = "Company A";
    private String insuranceNum = "INSURANCE001";
    private Date startDate = new Date();
    private Date endDate;

    private ICommandBehavior addInsuranceBehavior;
    private Command addInsurance;

    @Before
    public void setUp() {
        Datastore.TestDatastore();
        Datastore.AddCar(vehicle);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.YEAR, 1);
        endDate = cal.getTime();

        addInsuranceBehavior = new AddInsurance(vehicle, company, 
                insuranceNum, startDate, endDate);
        addInsurance = new Command(addInsuranceBehavior);
    }

    @Test
    public void excute() {
        boolean result;

        try {
            // execute
            result = addInsurance.executeCommand();
            assertTrue(result);
            if (result) 
                assertEquals(insuranceNum, 
                        vehicle.getInsurance().getInsuranceNumber());

            // undo
            result = addInsurance.undoCommand();
            assertTrue(result);
            if (result) 
                assertEquals(null, vehicle.getInsurance());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}