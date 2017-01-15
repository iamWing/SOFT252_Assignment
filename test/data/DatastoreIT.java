package data;

import java.util.ArrayList;
import models.Car;
import models.CarParks;
import models.Staff;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * JUnit test for Datastore class.
 *
 * @author NotMike
 */
public class DatastoreIT {
    private Staff testEmployee = new Staff("EMP", "John", "Smith", "Test Address", "123", "FULL");
    private Car testVehicle = new Car("TEST", "test", "test", 1, CarParks.CarPark01, "Test vehicle");
    
    @Before
    public void setUp() {
        System.out.print("Testing Datastore.");
    }
    /**
     * Test of TestDatastore method, of class Datastore.
     */
    @Test
    public void testTestDatastore() {
        System.out.println("TestDatastore");
        Datastore.TestDatastore();
    }

    /**
     * Test of AddCar and RemoveCar methods, of class Datastore.
     * Also tests GetCarAtIndex and GetCars()
     */
    @Test
    public void testAddRemoveCar() {
        System.out.println("AddRemoveCar");
        Datastore.TestDatastore();

        Datastore.AddCar(testVehicle);
        assertEquals(testVehicle, Datastore.GetCarAtIndex(0));

        Datastore.RemoveCar(testVehicle);
        assertEquals(0, Datastore.GetCars().size());
    }

    /**
     * Test of GetCars method with filter, of class Datastore.
     */
    @Test
    public void testGetCars_CarParks() {
        System.out.println("GetCars");
        Datastore.TestDatastore();
        Datastore.AddCar(testVehicle);
        
        assertEquals(1, Datastore.GetCars(CarParks.CarPark01).size());
        assertEquals(0, Datastore.GetCars(CarParks.CarPark02).size());
    }

    /**
     * Test of AddStaff, GetStaff and RemoveStaff methods, of class Datastore.
     */
    @Test
    public void testStaffAddRemove() {
        System.out.println("AddRemoveStaff");
        Datastore.TestDatastore();
        
        Datastore.AddStaff(testEmployee);
        ArrayList<Staff> result = Datastore.GetStaff();
        assertEquals(1, result.size());
        assertEquals(result.get(0), testEmployee);
        
        Datastore.RemoveStaff(testEmployee);
        result = Datastore.GetStaff();
        assertEquals(0, result.size());
    }

    /**
     * Test of GetStaff method, of class Datastore.
     */
    @Test
    public void testGetStaff_String() {
        System.out.println("GetStaff");
        Datastore.TestDatastore();
        Datastore.AddStaff(testEmployee);
        assertEquals(Datastore.GetStaff(testEmployee.getSTAFFID()), testEmployee);
    }

    /**
     * Test of GetDatastore method, of class Datastore.
     */
    @Test
    public void testGetDatastore() {
        System.out.println("GetDatastore");
        assertNotEquals(null, Datastore.GetDatastore());
    }
}
