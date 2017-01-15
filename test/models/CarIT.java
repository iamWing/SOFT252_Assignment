package models;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test for Car class.
 * Methods for managing Service, Allocation or Damage records are tested in the relevant unit test.
 *
 * @author NotMike
 */
public class CarIT {
    private Car car;
    public CarIT() {
    }
    
    @Before
    public void setUp() {
        System.out.print("Testing Car class.");
        car = new Car("TEST");
    }

    /**
     * Test of isAvailable method, of class Car.
     */
    @Test
    public void testIsAvailable() {
        System.out.println("isAvailable");
        Date when = new Date();
        assertEquals(true, car.isAvailable(when));
        
        Service service = new Service(when, when, "Test");
        car.addServiceRecord(service);
        assertEquals(false, car.isAvailable(when));
        car.removeServiceRecord(service);
        assertEquals(true, car.isAvailable(when));

        AllocationRecord record = new AllocationRecord(car, new Staff("TEST"), when);
        assertEquals(false, car.isAvailable(when));
        record.Delete();
        assertEquals(true, car.isAvailable(when));
        car.setDamaged(true);
        assertEquals(false, car.isAvailable(when));
    }

    /**
     * Test of isInService method, of class Car.
     */
    @Test
    public void testIsInService() {
        System.out.println("isInService");
        Date when = new Date();
        Service service = new Service(when, when, "Test");
        car.addServiceRecord(service);
        assertEquals(true, car.isInService(when));
        car.removeServiceRecord(service);
        assertEquals(false, car.isInService(when));
    }

    /**
     * Test of isAllocated method, of class Car.
     */
    @Test
    public void testIsAllocated() {
        System.out.println("isAllocated");
        Date when = new Date();
        AllocationRecord record = new AllocationRecord(car, new Staff("Test"), when);
        assertEquals(true, car.isAllocated(when));
        record.Delete();
        assertEquals(false, car.isAllocated(when));

        record = new AllocationRecord(car, new Staff("Test"), when, when);
        assertEquals(true, car.isAllocated(when));
        record.Delete();
        assertEquals(false, car.isAllocated(when));
    }

    /**
     * Test of isDamaged and setDamaged methods, of class Car.
     */
    @Test
    public void testDamaged() {
        System.out.println("isDamaged");
        car.setDamaged(false);
        assertEquals(false, car.isDamaged());
        car.setDamaged(true);
        assertEquals(true, car.isDamaged());
    }

    /**
     * Test of getCARID method, of class Car.
     */
    @Test
    public void testGetCARID() {
        System.out.println("GetCARID");
        assertEquals("TEST", car.getCARID());
    }

    /**
     * Test of getBrand and setBrand methods, of class Car.
     */
    @Test
    public void testBrand() {
        System.out.println("Brand");
        car.setBrand("TESTBRAND");
        assertEquals("TESTBRAND", car.getBrand());
    }

    /**
     * Test of getModel and setModel methods, of class Car.
     */
    @Test
    public void testModel() {
        System.out.println("Model");
        car.setModel("TESTMODEL");
        assertEquals("TESTMODEL", car.getModel());
    }

    /**
     * Test of getSeats and setSeats methods, of class Car.
     */
    @Test
    public void testSeats() {
        System.out.println("Seats");
        car.setSeats(1);
        assertEquals(1, car.getSeats());
        car.setSeats(3);
        assertEquals(3, car.getSeats());
    }

    /**
     * Test of getDescription and setDescription methods, of class Car.
     */
    @Test
    public void testDescription() {
        System.out.println("Description");
        car.setDescription("TEST Description");
        assertEquals("TEST Description", car.getDescription());
    }

    /**
     * Test of getLocation and setLocation methods, of class Car.
     */
    @Test
    public void testLocation() {
        System.out.println("Location");
        car.setLocation(CarParks.CarPark01);
        assertEquals(CarParks.CarPark01, car.getLocation());
        car.setLocation(CarParks.CarPark02);
        assertEquals(CarParks.CarPark02, car.getLocation());
        car.setLocation(CarParks.CarPark03);
        assertEquals(CarParks.CarPark03, car.getLocation());
    }

    /**
     * Test of getInsurance and setInsurance methods, of class Car.
     */
    @Test
    public void testInsurance() {
        System.out.println("Insurance");
        Insurance insurance = new Insurance("Test", "Test", new Date(), new Date());
        car.setInsurance(insurance);
        assertEquals(insurance, car.getInsurance());
    }

}
