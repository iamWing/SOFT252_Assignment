/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.EditVehicle;
import data.Datastore;
import java.util.Calendar;
import java.util.Date;
import models.Car;
import models.CarParks;
import models.Insurance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Wing
 */
public class EditVehicleIT {

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

    private Insurance insurance;

    private ICommandBehavior editVehicleBehavior;
    private Command editVehicle;

    @Before
    public void setUp() {
        System.out.println("Testing EditVehicle command");

        Datastore.TestDatastore();
        Datastore.AddCar(vehicle);

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.YEAR, 1);
        endDate = cal.getTime();

        insurance = new Insurance(company, insuranceNum, startDate, endDate);

        editVehicleBehavior = new EditVehicle(vehicleId, brand, model, seats,
                desc + " (Edited)", loc, insurance, false);
        editVehicle = new Command(editVehicleBehavior);
    }

    /**
     * JUnit test for EditVehicle command.
     */
    @Test
    public void execute() {
        System.out.println("Execute");

        boolean result;

        try {
            // execute
            result = editVehicle.executeCommand();
            assertTrue(result);
            if (result) {
                for (Car v : Datastore.GetCars()) {
                    if (v.getCARID().equals(vehicleId)) {
                        assertEquals(desc + " (Edited)", v.getDescription());
                    }
                }
            }

            // undo
            result = editVehicle.undoCommand();
            assertTrue(result);
            if (result) {
                for (Car v : Datastore.GetCars()) {
                    if (v.getCARID().equals(vehicleId)) {
                        assertEquals(desc, v.getDescription());
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
