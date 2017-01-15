/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddAllocationRecord;
import commands.vehicleManagement.RemoveAllocationRecord;
import java.util.Date;
import models.AllocationRecord;
import models.Car;
import models.CarParks;
import models.Staff;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for RemoveAllocationRecord command
 *
 * @author Wing
 */
public class RemoveAllocationRecordIT {

    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private String staffId = "Staff001";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff = new Staff(staffId, fName, lName, addr, licenseNum,
            licenseType);

    private Date startDate = new Date();

    private AllocationRecord record;

    private ICommandBehavior addAllocationRecordBehavior
            = new AddAllocationRecord(vehicle, staff, startDate);
    private Command addAllocationRecord
            = new Command(addAllocationRecordBehavior);

    private ICommandBehavior removeAllocationRecordBehavior;
    private Command removeAllocationRecord;

    @Before
    public void setUp() {
        System.out.println("Tesing RemoveAllocationRecord command");

        try {
            addAllocationRecord.executeCommand();
            record = vehicle.getAllocationRecords().get(0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail();
        }

        removeAllocationRecordBehavior = new RemoveAllocationRecord(record);
        removeAllocationRecord = new Command(removeAllocationRecordBehavior);
    }

    @Test
    public void executeAndUndo() {

        boolean result;

        try {
            // execute
            result = removeAllocationRecord.executeCommand();
            assertTrue(result);
            if (result) {
                System.out.println(vehicle.getAllocationRecords().contains(record));
                assertFalse(vehicle.getAllocationRecords().contains(record));
            }

            // undo
            result = removeAllocationRecord.undoCommand();
            assertTrue(result);
            if (result) {
                assertEquals(record.getCar(), 
                        vehicle.getAllocationRecords().get(0).getCar());
                assertEquals(record.getStaff(), 
                        vehicle.getAllocationRecords().get(0).getStaff());
                assertEquals(record.getStartDate(), 
                        vehicle.getAllocationRecords().get(0).getStartDate());
                assertEquals(record.getLongTermAllocation(),
                        vehicle.getAllocationRecords().get(0).getLongTermAllocation());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
