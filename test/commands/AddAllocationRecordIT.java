package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddAllocationRecord;
import java.util.Date;
import models.AllocationRecord;
import models.Car;
import models.CarParks;
import models.Staff;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddAllocationRecord command
 *
 * @author Wing
 */
public class AddAllocationRecordIT {

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

    private ICommandBehavior addAllocationRecordBehavior
            = new AddAllocationRecord(vehicle, staff, startDate);
    private Command addAllocationRecord
            = new Command(addAllocationRecordBehavior);

    @Before
    public void setUp() {
        System.out.println("Testing AddAllocationRecord command");
    }

    @Test
    public void executeAndUndo() {
        System.out.println("Execute");

        boolean result;

        try {
            // execute add allocation record
            result = addAllocationRecord.executeCommand();
            assertTrue(result);
            if (result) {
                AllocationRecord record = vehicle.getAllocationRecords().get(0);
                assertEquals(record, staff.getAllocationRecords().get(0));
                assertEquals(vehicle, record.getCar());
                assertEquals(staff, record.getStaff());
                assertEquals(startDate, record.getStartDate());
            }

            result = addAllocationRecord.undoCommand();
            assertTrue(result);
            if (result) { 
                boolean searched = false;
                for (AllocationRecord record : vehicle.getAllocationRecords()) {
                    if ((record.getCar() == vehicle) && (record.getStartDate() 
                            == startDate)) 
                        searched = true;
                }
                assertFalse(searched);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
