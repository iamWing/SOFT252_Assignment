/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddService;
import commands.vehicleManagement.RemoveService;
import java.util.Calendar;
import java.util.Date;
import models.Car;
import models.CarParks;
import models.Service;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Wing
 */
public class RemoveServiceIT {
    
    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private Date inDate, outDate;
    private String serviceDesc = "Testing add service command";

    private Service service;

    private ICommandBehavior addServiceBehavior, removeServiceBehavior;
    private Command addService, removeService;

    @Before
    public void setUp() {
       System.out.println("Testing RemoveService command");

        inDate = new Date();
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        cal.add(Calendar.DATE, 1);
        outDate = cal.getTime();

        addServiceBehavior = new AddService(vehicle, inDate, outDate, serviceDesc);
        addService = new Command(addServiceBehavior);

        try {
            addService.executeCommand();
            service  = vehicle.getServiceRecords().get(0);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail();
        }

        removeServiceBehavior = new RemoveService(vehicle, service);
        removeService = new Command(removeServiceBehavior);

    } 

    @Test
    public void executeAndUndo() {
        boolean result;

        try {
            // execute
            result = removeService.executeCommand();
            assertTrue(result);
            if (result) {
                assertFalse(vehicle.getServiceRecords().contains(service));
            }

            // undo
            result = removeService.undoCommand();
            assertTrue(result);
            if (result) {
                assertTrue(vehicle.getServiceRecords().contains(service));
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
