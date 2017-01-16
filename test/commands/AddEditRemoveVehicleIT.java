package commands;

import commands.vehicleManagement.AddVehicle;
import commands.vehicleManagement.EditVehicle;
import commands.vehicleManagement.RemoveVehicle;
import data.Datastore;
import models.Car;
import models.CarParks;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test of AddVehicle EditVehicle and RemoveVehiclecommands
 *
 * @author Wing
 */
public class AddEditRemoveVehicleIT {

    private String id = "CAR";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

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
            // AddVehicle
            Command addCommand = new Command(new AddVehicle(id, brand, model, seats, loc, desc));
            assertEquals(true, undoHistory.executeCommand(addCommand));
            Car car = Datastore.GetCars().get(0);
            
            // RemoveVehicle
            Command removeCommand = new Command(new RemoveVehicle(Datastore.GetCars().get(0)));
            assertEquals(true, undoHistory.executeCommand(removeCommand));
            assertEquals(false, Datastore.GetCars().contains(car));
            
            // Undo RemoveVehicle
            undoHistory.undoLastCommand();
            assertEquals(car, Datastore.GetCars().get(0));

            // Undo AddVehicle
            undoHistory.undoLastCommand();
            assertEquals(false, Datastore.GetCars().contains(car));
            
            // Redo AddVehicle
            undoHistory.redoLastCommand();
            assertEquals(car, Datastore.GetCars().get(0));

            // Redo RemoveVehicle
            undoHistory.redoLastCommand();
            assertEquals(false, Datastore.GetCars().contains(car));
    }

    @Test
    /**
     * JUnit test for EditStaff command.
     */
    public void testEdit() throws Exception {
        System.out.println("Edit");
        CommandTracker undoHistory = new CommandTracker();
        Car car = new Car(id, brand, model, seats, loc, desc);
        Datastore.AddCar(car);
        Command editCommand = new Command(new EditVehicle(id, brand + "-Test", model + "-Test", seats + 42, desc + "-Test", loc, null, false));
        undoHistory.executeCommand(editCommand);
        assertEquals(brand + "-Test", car.getBrand());
        assertEquals(model + "-Test", car.getModel());
        assertEquals(desc + "-Test", car.getDescription());
        assertEquals(seats + 42, car.getSeats());

        undoHistory.undoLastCommand();
        assertEquals(brand, car.getBrand());
        assertEquals(model, car.getModel());
        assertEquals(desc, car.getDescription());
        assertEquals(seats, car.getSeats());

        undoHistory.redoLastCommand();
        assertEquals(brand + "-Test", car.getBrand());
        assertEquals(model + "-Test", car.getModel());
        assertEquals(desc + "-Test", car.getDescription());
        assertEquals(seats + 42, car.getSeats());
    }
}
