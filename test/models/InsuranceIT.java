package models;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for Insurance Class.
 *
 * @author NotMike
 */
public class InsuranceIT {
    
    private Date from = new Date(2017,1,1);
    private Date to = new Date(2018,1,1);
    private Insurance instance = new Insurance("Insurer", "00001", from, to);
    public InsuranceIT() {
    }
    
    @Before
    public void setUp() {
        System.out.print("Testing Service.");
    }

    /**
     * Test of getCompany and setCompany methods, of class Insurance.
     */
    @Test
    public void testCompany() {
        System.out.println("Company");
        instance.setCompany("TESTCOMPANY");
        assertEquals("TESTCOMPANY", instance.getCompany());
    }

    /**
     * Test of getInsuranceNumber and setInsuranceNumber methods, of class Insurance.
     */
    @Test
    public void testInsuranceNumber() {
        System.out.println("InsuranceNumber");
        instance.setInsuranceNumber("123");
        assertEquals("123", instance.getInsuranceNumber());
    }

    /**
     * Test of getStartDate and setStartDate method, of class Insurance.
     */
    @Test
    public void testStartDate() {
        System.out.println("StartDate");
        Date start = new Date();
        instance.setStartDate(start);
        assertEquals(start, instance.getStartDate());
    }

    /**
     * Test of getEndDate and setEndDate method, of class Insurance.
     */
    @Test
    public void testEndDate() {
        System.out.println("EndDate");
        Date end = new Date();
        instance.setEndDate(end);
        assertEquals(end, instance.getEndDate());
    }
    
}
