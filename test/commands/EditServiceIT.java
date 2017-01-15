/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.EditService;
import java.util.Calendar;
import java.util.Date;
import models.Service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for EditService command
 *
 * @author Wing
 */
public class EditServiceIT {

    private Date inDate, outDate;
    private String desc = "Testing EditService command";

    private Service service;

    private ICommandBehavior editServiceBehavior;
    private Command editService;

    @Before
    public void setUp() {
        System.out.println("Testing EditService command");

        inDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        cal.add(Calendar.DATE, 1);
        outDate = cal.getTime();

        service = new Service(inDate, outDate, desc);

        editServiceBehavior = new EditService(service, inDate, outDate,
                desc + " (Edited");
        editService = new Command(editServiceBehavior);
    }

    @Test
    public void executeAndUndo() {

        boolean result;

        try {
            // execute
            result = editService.executeCommand();
            assertTrue(result);
            if (result) {
                assertEquals(desc + " (Edited)", service.getDescription());
            }

            // undo
            result = editService.undoCommand();
            assertTrue(result);
            if (result) {
                assertEquals(desc, service.getDescription());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
