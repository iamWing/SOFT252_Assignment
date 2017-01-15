package commands;

import commands.vehicleManagement.AddService;
import commands.vehicleManagement.EditService;
import commands.vehicleManagement.RemoveService;
import data.Datastore;
import java.util.Date;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Car;
import models.Service;
import models.Staff;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddService, EditService and RemoveService commands
 *
 * @author NotMike
 */
public class AddEditRemoveServiceIT {

    @Before
    public void setUp() {
        System.out.print("Tesing Service");
        Datastore.TestDatastore();
    }

    /**
     * JUnit test for AddService and RemoveService commands.
     * @throws Exception 
     */
    @Test
    public void testAddRemove() throws Exception {
        System.out.println("AddRemove");
        Car vehicle = new Car("CAR");
        Date startDate = new Date();
        Date endDate = new Date();
        CommandTracker undoHistory = new CommandTracker();
        assertEquals(false, vehicle.isInService(startDate));

        // AddRecord
        Command addCommand = new Command(new AddService(vehicle, startDate, endDate, "TEST"));
        assertEquals(true, undoHistory.executeCommand(addCommand));
        assertEquals(1, vehicle.getServiceRecords().size());
        Service record = vehicle.getServiceRecords().get(0);
        assertEquals(startDate, record.getInDate());
        assertEquals(endDate, record.getOutDate());
        assertEquals(true, vehicle.getServiceRecords().contains(record));

        // Undo AddRecord
        undoHistory.undoLastCommand();
        assertEquals(false, vehicle.getServiceRecords().contains(record));

        // Redo AddRecord
        undoHistory.redoLastCommand();
        record = vehicle.getServiceRecords().get(0);
        assertEquals(true, vehicle.isInService(startDate));

        // RemoveRecord
        Command removeCommand = new Command(new RemoveService(vehicle, record));
        assertEquals(true, undoHistory.executeCommand(removeCommand));
        assertEquals(false, vehicle.getServiceRecords().contains(record));

        // Undo RemoveRecord
        undoHistory.undoLastCommand();
        assertEquals(true, vehicle.isInService(startDate));
        assertEquals(1, vehicle.getServiceRecords().size());

        // Redo RemoveRecord
        undoHistory.redoLastCommand();
        assertEquals(false, vehicle.isInService(startDate));
        assertEquals(0, vehicle.getServiceRecords().size());
    }
    
    /**
     * JUnit test for EditService command.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        CommandTracker undoHistory = new CommandTracker();
        Date oldInDate = new Date();
        Date oldOutDate = new Date();
        Date newInDate = new Date();
        Date newOutDate = new Date();
        Service record = new Service(oldInDate, oldOutDate, "TEST");
        Command editCommand = new Command(new EditService(record, newInDate, newOutDate, "Test"));
        undoHistory.executeCommand(editCommand);
        assertEquals(newInDate, record.getInDate());
        assertEquals(newOutDate, record.getOutDate());
        assertEquals("Test", record.getDescription());

        undoHistory.undoLastCommand();
        assertEquals(oldInDate, record.getInDate());
        assertEquals(oldOutDate, record.getOutDate());
        assertEquals("TEST", record.getDescription());

        undoHistory.redoLastCommand();
        assertEquals(newInDate, record.getInDate());
        assertEquals(newOutDate, record.getOutDate());
        assertEquals("Test", record.getDescription());
    }
}