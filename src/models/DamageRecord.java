package models;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Class to hold records of vehicle damage.
 *
 * @author Wing
 */
public class DamageRecord {
    
    private LocalDateTime createDate;
    private Calendar damageDate;
    private Staff damagedBy;
    private String description;

    /**
     * Constructor, creates DamageRecord and attaches it to the Car.
     *
     * @param _car Car Vehicle that was damaged.
     * @param _damageDate Calendar Date of damage.
     * @param _damagedBy Staff Person who did the damage.
     * @param _desc String Description of damage.
     */
    public DamageRecord(Car _car, Calendar _damageDate, Staff _damagedBy, String _desc) {
        createDate = LocalDateTime.now();
        damageDate  = _damageDate;
        damagedBy = _damagedBy;
        description = _desc;
        _car.addDamageRecord(this);
    }

    /**
     * Get the date of the damage.
     *
     * @return Calendar
     */
    public Calendar getDamageDate() {
        return damageDate;
    }

    /**
     * Set the damage date.
     *
     * @param damageDate Calendar
     */
    public void setDamageDate(Calendar damageDate) {
        this.damageDate = damageDate;
    }

    /**
     * Find the employee who damaged the vehicle.
     *
     * @return Staff
     */
    public Staff getDamagedBy() {
        return damagedBy;
    }

    /**
     * Set the employee who damaged the vehicle.
     *
     * @param damagedBy Staff
     */
    public void setDamagedBy(Staff damagedBy) {
        this.damagedBy = damagedBy;
    }

    /**
     * Get the description of the damage.
     *
     * @return String Description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the damage.
     *
     * @param description String Description of damage.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
