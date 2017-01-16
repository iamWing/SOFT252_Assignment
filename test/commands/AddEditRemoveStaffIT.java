package commands;

import commands.staffMamagement.AddStaff;
import commands.staffMamagement.EditStaff;
import commands.staffMamagement.RemoveStaff;
import data.Datastore;
import models.Staff;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test of AddStaff EditStaff and RemoveStaff commands
 *
 * @author Wing
 */
public class AddEditRemoveStaffIT {

    private String id = "Staff001";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff = new Staff(id, fName, lName, addr, licenseNum, licenseType);

    @Before
    public void setUp() {
        System.out.print("Testing AddEditRemoveStaff.");
        Datastore.TestDatastore();
    }

    @Test
    /**
     * JUnit test for AddStaff and RemoveStaff commands.
     */
    public void testAddRemove() throws Exception {
        System.out.println("AddRemove");
        CommandTracker undoHistory = new CommandTracker();
            // AddStaff
            Command addCommand = new Command(new AddStaff(staff));
            assertEquals(true, undoHistory.executeCommand(addCommand));
            assertEquals(staff, Datastore.GetStaff(id));
            
            // RemoveStaff
            Command removeCommand = new Command(new RemoveStaff(staff));
            assertEquals(true, undoHistory.executeCommand(removeCommand));
            assertEquals(false, Datastore.GetStaff().contains(staff));
            
            // Undo RemoveStaff
            undoHistory.undoLastCommand();
            assertEquals(staff, Datastore.GetStaff(id));

            // Undo AddStaff
            undoHistory.undoLastCommand();
            assertEquals(false, Datastore.GetStaff().contains(staff));
            
            // Redo AddStaff
            undoHistory.redoLastCommand();
            assertEquals(staff, Datastore.GetStaff(id));

            // Redo RemoveStaff
            undoHistory.redoLastCommand();
            assertEquals(false, Datastore.GetStaff().contains(staff));
    }

    @Test
    /**
     * JUnit test for EditStaff command.
     */
    public void testEdit() throws Exception {
        System.out.println("Edit");
        CommandTracker undoHistory = new CommandTracker();
        Datastore.AddStaff(staff);
        Command editCommand = new Command(new EditStaff(id, "TEST", "TEST", "TEST", "TEST", "TEST"));
        undoHistory.executeCommand(editCommand);
        assertEquals("TEST", staff.getAddress());
        assertEquals("TEST", staff.getForeName());
        assertEquals("TEST", staff.getLastName());
        assertEquals("TEST", staff.getLicenseNumber());
        assertEquals("TEST", staff.getLicenseType());

        undoHistory.undoLastCommand();
        assertEquals(addr, staff.getAddress());
        assertEquals(fName, staff.getForeName());
        assertEquals(lName, staff.getLastName());
        assertEquals(licenseNum, staff.getLicenseNumber());
        assertEquals(licenseType, staff.getLicenseType());

        undoHistory.redoLastCommand();
        assertEquals("TEST", staff.getAddress());
        assertEquals("TEST", staff.getForeName());
        assertEquals("TEST", staff.getLastName());
        assertEquals("TEST", staff.getLicenseNumber());
        assertEquals("TEST", staff.getLicenseType());
    }
}
