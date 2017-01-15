package other;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for Utils class.
 *
 * @author NotMike
 */
public class UtilsIT {
    
    /**
     * Test of CompareDates method, of class Utils.
     */
    @Test
    public void testCompareDates() {
        System.out.println("Utils.CompareDates");
        Date date1 = new Date(2017, 1, 1);
        Date date2 = new Date(2017, 1, 2);
        Date date3 = new Date(2017, 1, 3);
        Date date4 = new Date(2017, 1, 1);
        assertEquals(-1, Utils.CompareDates(date1, date2));
        assertEquals(-1, Utils.CompareDates(date2, date3));
        assertEquals(1, Utils.CompareDates(date3, date2));
        assertEquals(1, Utils.CompareDates(date2, date1));
        assertEquals(0, Utils.CompareDates(date1, date4));
    }
    
}
