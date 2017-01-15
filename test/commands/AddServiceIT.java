/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddService;
import java.util.Calendar;
import java.util.Date;
import models.Car;
import models.CarParks;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Wing
 */
public class AddServiceIT {
    
    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private Date inDate, outDate;
    private String serviceDesc = "Testing add service command";

    private ICommandBehavior addServiceBehavior;
    private Command addService;

    @Before
    public void setUp() {
        System.out.println("Testing AddService command");

        inDate = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        cal.add(Calendar.DATE, 1);
        outDate = cal.getTime();

        addServiceBehavior = new AddService(vehicle, inDate, outDate, serviceDesc);
        addService = new Command(addServiceBehavior);
    }

    @Test
    public void execute() {
        System.out.println("Execute");

        boolean result;

        try {
            result = addService.executeCommand();
            assertTrue(result);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    public void undo() {
        System.out.println("Undo");

        boolean result;

        try {
            result = addService.undoCommand();
            assertTrue(result);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
