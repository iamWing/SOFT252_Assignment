package models;

import data.Datastore;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test for AllocationRecord class.
 *
 * @author NotMike
 */
public class AllocationRecordIT {
    private Car vehicle;
    private Staff employee;
    public AllocationRecordIT() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Testing AllocationRecord class.");
        vehicle = new Car("TEST");
        employee = new Staff("TEST");
    }

    /**
     * Test of auto-attach, and Delete method, of class AllocationRecord.
     */
    @Test
    public void testAddDelete() {
        System.out.println("AddDelete");
        AllocationRecord instance = new AllocationRecord(vehicle, employee, new Date());
        assertEquals(true, vehicle.getAllocationRecords().contains(instance));
        assertEquals(true, employee.getAllocationRecords().contains(instance));
        instance.Delete();
        assertEquals(false, vehicle.getAllocationRecords().contains(instance));
        assertEquals(false, employee.getAllocationRecords().contains(instance));
    }

    /**
     * Test of getCar method, of class AllocationRecord.
     */
    @Test
    public void testGetCar() {
        System.out.println("getCar");
        AllocationRecord instance = new AllocationRecord(vehicle, employee, new Date());
        Car expResult = vehicle;
        Car result = instance.getCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaff method, of class AllocationRecord.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        AllocationRecord instance = new AllocationRecord(vehicle, employee, new Date());
        Staff expResult = employee;
        Staff result = instance.getStaff();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongTermAllocation method, of class AllocationRecord.
     */
    @Test
    public void testGetLongTermAllocation() {
        System.out.println("getLongTermAllocation");
        AllocationRecord instanceShort = new AllocationRecord(vehicle, employee, new Date());
        AllocationRecord instanceLong = new AllocationRecord(vehicle, employee, new Date(), new Date());
        assertEquals(false, instanceShort.getLongTermAllocation());
        assertEquals(true, instanceLong.getLongTermAllocation());
    }

    /**
     * Test of getStartDate method, of class AllocationRecord.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Date when = new Date();
        AllocationRecord instance = new AllocationRecord(vehicle, employee, when);
        assertEquals(when, instance.getStartDate());
    }

    /**
     * Test of getEndDate method, of class AllocationRecord.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Date when = new Date();
        AllocationRecord instance = new AllocationRecord(vehicle, employee, new Date(), when);
        assertEquals(when, instance.getEndDate());
    }

}
