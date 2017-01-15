package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddVehicle;
import data.Datastore;
import models.Car;
import models.CarParks;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * JUnit test for AddVehicle command
 * @author Wing
 */
public class AddVehicleIT {
    
    private String id = "CAR001", id2 = "CAR002", id3 = "CAR003";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private ICommandBehavior addVehicleBehavior1 = new AddVehicle(id);
    private ICommandBehavior addVehicleBehavior2 = new AddVehicle(id2, brand, 
            model, seats, loc, desc);
    private ICommandBehavior addVehicleBehavior3 = new AddVehicle(new Car(id3));

    private Command addVehicle1 = new Command(addVehicleBehavior1);
    private Command addVehicle2 = new Command(addVehicleBehavior2);
    private Command addVehicle3 = new Command(addVehicleBehavior3);

    @Before
    public void setUp() {
        System.out.println("Testing AddVehicle command");

        Datastore.TestDatastore();
    }

    @Test
    public void execute1() {
        System.out.println("Execute addVehicle1");

        boolean result;

        try {
            result = addVehicle1.executeCommand();
            assertTrue(result);
            if (result) {
                boolean searched = false;
                for (Car vehicle : Datastore.GetCars()) {
                    if (vehicle.getCARID().equals(id))
                        searched = true;
                }
                assertTrue(searched);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    public void execute2() {
        System.out.println("Execute addVehicle2");

        boolean result;

        try {
            result = addVehicle2.executeCommand();
            assertTrue(result);
            if (result) {
                boolean searched = false;
                for (Car vehicle : Datastore.GetCars()) {
                    if (vehicle.getCARID().equals(id2))
                        searched = true;
                }
                assertTrue(searched);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    public void execute3() {
        System.out.println("Execute addVehicle3");

        boolean result;

        try {
            result = addVehicle3.executeCommand();
            assertTrue(result);
            if (result) {
                boolean searched = false;
                for (Car vehicle : Datastore.GetCars()) {
                    if (vehicle.getCARID().equals(id3))
                        searched = true;
                }
                assertTrue(searched);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }

    @Test
    public void undo1() {
        System.out.println("Undo addVehicle1");

        boolean result;

        try {
            result = addVehicle1.undoCommand();
            assertTrue(result);
            if (result) {
                boolean searched = false;
                for (Car vehicle : Datastore.GetCars()) {
                    if (vehicle.getCARID().equals(id))
                        searched = true;
                }
                assertFalse(searched);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            fail("Exception caught");
        }
    }
}
