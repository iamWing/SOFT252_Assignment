package commands;

import commands.interfaces.ICommandBehavior;
import commands.staffMamagement.RemoveStaff;
import data.Datastore;
import models.Staff;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for removeStaff command
 * @author Wing
 */
public class RemoveStaffIT {

    private String id = "Staff001", id2 = "Staff002";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff1, staff2;

    private ICommandBehavior removeStaffBehavior1, removeStaffBehavior2;
    private Command removeStaffCmd1, removeStaffCmd2;
    
    @Before
    public void setUp() {
        System.out.println("Testing RemoveStaff command");
        Datastore.TestDatastore();

        staff1= new Staff(id, fName, lName, addr, licenseNum, licenseType);
        staff2 = new Staff(id2, fName, lName, addr, licenseNum, licenseType);
        Datastore.AddStaff(staff1);
        Datastore.AddStaff(staff2);

        removeStaffBehavior1 = new RemoveStaff(staff1);
        removeStaffCmd1 = new Command(removeStaffBehavior1);
        try {
            removeStaffBehavior2 = new RemoveStaff(id2);
            removeStaffCmd2 = new Command(removeStaffBehavior2);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * Test of execute removeStaffCmd1
     */
    public void testExecute1() {
        System.out.println("Execute removeStaffCmd1");

        boolean result;

        try {
            result = removeStaffCmd1.executeCommand();
            assertTrue(result);
            if (result) 
                assertEquals(null, Datastore.GetStaff(id));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * Test of execute removeStaffCmd2
     */
    public void testExecute2() {
        System.out.println("Execute removeStaffCmd2");

        boolean result;

        try {
            result = removeStaffCmd2.executeCommand();
            assertTrue(result);
            if (result) 
                assertEquals(null, Datastore.GetStaff(id2));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * Test of undo removeStaffCmd1
     */
    public void undo1() {
        System.out.println("Undo removeStaffCmd1");

        boolean result;

        try {
            result = removeStaffCmd1.undoCommand();
            assertTrue(result);
            if (result)
                assertEquals(staff1, Datastore.GetStaff(id));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    /**
     * Test of undo removeStaffCmd2
     */
    public void undo2() {
        System.out.println("Undo removeStaffCmd2");

        boolean result;

        try {
            result = removeStaffCmd2.undoCommand();
            assertTrue(result);
            if (result)
                assertEquals(staff2, Datastore.GetStaff(id2));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
