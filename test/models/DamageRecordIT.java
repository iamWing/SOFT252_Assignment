package models;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test for DamageRecord class.
 *
 * @author NotMike
 */
public class DamageRecordIT {
    
    private Date damageDate = new Date();
    private Staff damagedBy = new Staff("EMP");
    private Car damageVehicle = new Car("");
    private DamageRecord record = new DamageRecord(damageVehicle, damageDate, damagedBy, "TEST");
    public DamageRecordIT() {
    }
    
    @Before
    public void setUp() {
        System.out.print("Testing DamageRecord.");
    }

    /**
     * Test of toString method, of class DamageRecord.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = damageDate.toString() + "-" + damagedBy.getForeName() + " " +damagedBy.getLastName();
        assertEquals(expResult, record.toString());
    }

    /**
     * Test of getCreateDate and setCreateDate methods, of class DamageRecord.
     */
    @Test
    public void testCreateDate() {
        System.out.println("CreateDate");
        Date when = new Date();
        record.setCreateDate(when);
        assertEquals(when, record.getCreateDate());
    }

    /**
     * Test of getDamageDate and setDamageDate methods, of class DamageRecord.
     */
    @Test
    public void testDamageDate() {
        System.out.println("DamageDate");
        Date when = new Date();
        record.setDamageDate(when);
        assertEquals(when, record.getDamageDate());
    }

    /**
     * Test of getDamagedBy method, of class DamageRecord.
     */
    @Test
    public void testDamagedBy() {
        System.out.println("DamagedBy");
        Staff whom = new Staff("TESTDAMAGEBY");
        record.setDamagedBy(whom);
        assertEquals(whom, record.getDamagedBy());
    }

    /**
     * Test of getDescription and setDescription methods, of class DamageRecord.
     */
    @Test
    public void testDescription() {
        System.out.println("Description");
        record.setDescription("TESTDESC");
        assertEquals("TESTDESC", record.getDescription());
    }
    
}