package models;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for Service class.
 *
 * @author NotMike
 */
public class ServiceIT {
    public ServiceIT() {
    }
    
    @Before
    public void setUp() {
        System.out.print("Testing Service.");
    }

    /**
     * Test of getInDate and setInDate methods, of class Service.
     */
    @Test
    public void testInDate() {
        System.out.println("InDate");
        Service instance = new Service();
        Date when = new Date();
        instance.setInDate(when);
        assertEquals(when, instance.getInDate());
    }

    /**
     * Test of getOutDate and setOutDate methods, of class Service.
     */
    @Test
    public void testOutDate() {
        System.out.println("OutDate");
        Service instance = new Service();
        Date when = new Date();
        instance.setOutDate(when);
        assertEquals(when, instance.getOutDate());
    }

    /**
     * Test of getDescription and setDescription methods, of class Service.
     */
    @Test
    public void testDescription() {
        System.out.println("Description");
        Service instance = new Service();
        instance.setDescription("TESTSERVICE");
        assertEquals("TESTSERVICE", instance.getDescription());
    }

    /**
     * Test of toString method, of class Service.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Date when = new Date();
        Service instance = new Service(when, when, "Test");
        assertEquals(when + "-" + when + ": " + "Test", instance.toString());
    }
    
}
