package other;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility class for general purpose functions.
 * 
 * @author NotMike
 */
public class Utils {
    /**
     * Compares 2 Date objects, only accounting for date and not the full Timestamp.
     * Allows an easy way to check if 2 Date objects reference the same date.
     * 
     * If date1 is before date2 return value is &lt;0.
     * If date1 is equal to date2 return value is 0.
     * If date1 is after date2 return value is &gt;0.
     * 
     * @param date1 First Date
     * @param date2 Second Date
     * @return int Status
     */
    public static int CompareDates(Date date1, Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);

        return cal1.compareTo(cal2);
    }
}
