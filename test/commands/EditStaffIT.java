package commands;

import commands.interfaces.ICommandBehavior;
import commands.staffMamagement.EditStaff;
import data.Datastore;
import models.Staff;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test of EditStaff command
 *
 * @author Wing
 */
public class EditStaffIT {

    private String id = "Staff001", id2 = "Staff002";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff1, staff2, editedStaff;

    private ICommandBehavior editStaffBehavior1, editStaffBehavior2;
    private Command editStaffCmd1, editStaffCmd2;

    @Before
    public void setUp() {
        System.out.println("Testing EditStaff command");
        Datastore.TestDatastore();

        staff1= new Staff(id, fName, lName, addr, licenseNum, licenseType);
        staff2 = new Staff(id2, fName, lName, addr, licenseNum, licenseType);
        Datastore.AddStaff(staff1);
        Datastore.AddStaff(staff2);

        editedStaff = new Staff(id, "Chun Wing", lName, addr, licenseNum,
                licenseType);
        editStaffBehavior1 = new EditStaff(id2, "Chun Wing", lName, addr,
                licenseNum, licenseType);
        editStaffBehavior2 = new EditStaff(editedStaff);
        editStaffCmd1 = new Command(editStaffBehavior1);
        editStaffCmd2 = new Command(editStaffBehavior2);
    }

    @Test
    /**
     * JUnit test for execute editStaffCmd1
     */
    public void testExecute1() {
        System.out.println("Execute editStaffCmd1");

        boolean result;

        try {
            result = editStaffCmd1.executeCommand();
            assertTrue(result);
            if (result) 
                assertEquals("Chun Wing", staff1.getForeName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * JUnit test for execute editStaffCmd2
     */
    public void testExecute2() {
        System.out.println("Execute editStaffCmd2");

        boolean result;

        try {
            result = editStaffCmd2.executeCommand();
            assertTrue(result);
            if (result) 
                assertEquals("Chun Wing", staff2.getForeName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * JUnit test for undo editStaffCmd1
     */
    public void undo1() {
        System.out.println("Undo editStaffCmd1");

        boolean result;

        try {
            result = editStaffCmd1.undoCommand();
            assertTrue(result);
            if (result)
                assertEquals(fName, staff1.getForeName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * JUnit test for undo editStaffCmd2
     */
    public void undo2() {
        System.out.println("Undo editStaffCmd2");

        boolean result;

        try {
            result = editStaffCmd2.undoCommand();
            assertTrue(result);
            if (result)
                assertEquals(fName, staff2.getForeName());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
