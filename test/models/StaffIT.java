package models;

import data.Datastore;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * JUnit tests for Staff object.
 *
 * @author NotMike
 */
public class StaffIT {
    
    private Staff employee = new Staff("EMP");
    private Car testCar = new Car("TEST");
    private Date when = new Date();
    public StaffIT() {
    }

    @Before
    public void setUp() throws Exception {
        System.out.print("Testing Staff.");
        Datastore.TestDatastore();
        Datastore.AddStaff(employee);
        Datastore.AddCar(testCar);
    }

    /**
     * Test of hasCarAllocated method, of class Staff.
     */
    @Test
    public void testHasCarAllocated() {
        System.out.println("hasCarAllocated");

        assertEquals(false, employee.hasCarAllocated(when));
        
        AllocationRecord allocation = new AllocationRecord(testCar, employee, when);
        assertEquals(true, employee.hasCarAllocated(when));
    }

    /**
     * Test of getSTAFFID method, of class Staff.
     */
    @Test
    public void testGetSTAFFID() {
        System.out.println("getSTAFFID");
        assertEquals(employee.getSTAFFID(), "EMP");
    }

    /**
     * Test of getLicenseNumber and setLicenseNumber methods, of class Staff.
     */
    @Test
    public void testLicenseNumber() {
        System.out.println("LicenseNumber");
        employee.setLicenseNumber("1234567890");
        assertEquals("1234567890", employee.getLicenseNumber());
    }

    /**
     * Test of getLicenseType and setLicenseType methods, of class Staff.
     */
    @Test
    public void testLicenseType() {
        System.out.println("LicenseType");
        employee.setLicenseType("TEST");
        assertEquals("TEST", employee.getLicenseType());
    }

    /**
     * Test of getForeName and setForeName methods, of class Staff.
     */
    @Test
    public void testForeName() {
        System.out.println("ForeName");
        employee.setForeName("TESTFORENAME");
        assertEquals("TESTFORENAME", employee.getForeName());
    }

    /**
     * Test of getLastName and setLastName methods, of class Staff.
     */
    @Test
    public void testSetLastName() {
        System.out.println("LastName");
        employee.setLastName("TESTLASTNAME");
        assertEquals("TESTLASTNAME", employee.getLastName());
    }

    /**
     * Test of getAddress and setAddress methods, of class Staff.
     */
    @Test
    public void testAddress() {
        System.out.println("Address");
        employee.setAddress("TESTADDRESS");
        assertEquals("TESTADDRESS", employee.getAddress());
    }

    /**
     * Test of getAssignedCar and setAssignedCar methods, of class Staff.
     */
    @Test
    public void testAssignedCar() {
        System.out.println("AssignedCar");
        employee.setAssignedCar(testCar);
        assertEquals(testCar, employee.getAssignedCar());
    }

    /**
     * Test of toString method, of class Staff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = employee.getSTAFFID() + ": " + employee.getForeName() + " " + employee.getLastName();
        assertEquals(expResult, employee.toString());
    }

    /**
     * Test of getAllocationRecords method, of class Staff.
     */
    @Test
    public void testGetAllocationRecords() {
        System.out.println("getAllocationRecords");
        Date when = new Date(2017, 1, 1);
        AllocationRecord allocation = new AllocationRecord(testCar, employee, when);

        ArrayList<AllocationRecord> result = employee.getAllocationRecords();
        assertEquals(true, result.contains(allocation));
    }
    
}
