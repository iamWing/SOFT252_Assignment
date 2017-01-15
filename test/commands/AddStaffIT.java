/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.staffMamagement.AddStaff;
import static org.junit.Assert.*;
import data.Datastore;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddStaff command
 *
 * @author Wing
 */
public class AddStaffIT {

    private String id = "Staff001";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private ICommandBehavior addStaffBehavior = new AddStaff(id, fName, lName,
            addr, licenseNum, licenseType);
    private Command addStaffCmd = new Command(addStaffBehavior);

    @Before
    public void setUp() {
        System.out.println("Testing AddStaff command");
        Datastore.TestDatastore();
    }

    /**
     * Test of execute command
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        
        boolean result;

        try {
            result = addStaffCmd.executeCommand();
            assertTrue(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    /**
     * Test of undo command
     */
    @Test
    public void testUndo() {
        System.out.println("Undo");

        boolean result; 
        
        try {
            result = addStaffCmd.undoCommand();
            assertTrue(result);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
