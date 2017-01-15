package commands;

import commands.interfaces.ICommandBehavior;
import commands.staffMamagement.AddStaff;
import commands.staffMamagement.RemoveStaff;
import commands.vehicleManagement.AddAllocationRecord;
import commands.vehicleManagement.RemoveAllocationRecord;
import data.Datastore;
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
 * JUnit test for AddAllocationRecord and RemoveAllocationRecord commands
 *
 * @author NotMike
 */
public class AddRemoveAllocationRecordIT {

    @Before
    public void setUp() {
        System.out.print("Tesing RemoveAllocationRecord");
    }

    @Test
    public void testAddRemove() throws Exception {
        System.out.println("AddRemove");
        Car vehicle = new Car("CAR");
        Staff staff = new Staff("STAFF");
        Date startDate = new Date();
        Date endDate = new Date();
        CommandTracker undoHistory = new CommandTracker();
        assertEquals(false, vehicle.isAllocated(startDate));

        // AddRecord
        Command addCommand = new Command(new AddAllocationRecord(vehicle, staff, startDate, endDate));
        assertEquals(true, undoHistory.executeCommand(addCommand));
        assertEquals(1, vehicle.getAllocationRecords().size());
        AllocationRecord record = vehicle.getAllocationRecords().get(0);
        assertEquals(vehicle, record.getCar());
        assertEquals(staff, record.getStaff());
        assertEquals(startDate, record.getStartDate());
        assertEquals(true, vehicle.getAllocationRecords().contains(record));
        assertEquals(true, staff.getAllocationRecords().contains(record));

        // Undo AddRecord
        undoHistory.undoLastCommand();
        assertEquals(false, vehicle.getAllocationRecords().contains(record));
        assertEquals(false, staff.getAllocationRecords().contains(record));

        // Redo AddRecord
        undoHistory.redoLastCommand();
        record = vehicle.getAllocationRecords().get(0);
        assertEquals(true, vehicle.getAllocationRecords().contains(record));
        assertEquals(true, staff.getAllocationRecords().contains(record));

        // RemoveRecord
        Command removeCommand = new Command(new RemoveAllocationRecord(vehicle.getAllocationRecords().get(0)));
        assertEquals(true, undoHistory.executeCommand(removeCommand));
        assertEquals(false, vehicle.getAllocationRecords().contains(record));
        assertEquals(false, staff.getAllocationRecords().contains(record));

        // Undo RemoveRecord
        undoHistory.undoLastCommand();
        assertEquals(1, vehicle.getAllocationRecords().size());
        assertEquals(1, staff.getAllocationRecords().size());

        // Redo RemoveRecord
        undoHistory.redoLastCommand();
        assertEquals(false, vehicle.isAllocated(startDate));
        assertEquals(0, vehicle.getAllocationRecords().size());
        assertEquals(0, staff.getAllocationRecords().size());
    }
}