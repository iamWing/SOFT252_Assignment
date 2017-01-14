package models;

import java.io.Serializable;
import java.util.Date;

/**
 * Class to hold records of vehicle damage.
 *
 * @author Wing
 */
public class DamageRecord implements Serializable {
    
    private Date createDate;
    private Date damageDate;
    private Staff damagedBy;
    private String description;
    
    /**
     * Empty Constructor, Exists for compatibility purposes.
     * Should not be used.
     */
    public DamageRecord()
    {
        createDate = new Date();
        damageDate = new Date();
        damagedBy = null;
        description = " ";
    }

    /**
     * Constructor, creates DamageRecord and attaches it to the Car.
     *
     * @param _car Car Vehicle that was damaged.
     * @param _damageDate Calendar Date of damage.
     * @param _damagedBy Staff Person who did the damage.
     * @param _desc String Description of damage.
     */
    public DamageRecord(Car _car, Date _damageDate, Staff _damagedBy, String _desc) {
        createDate = new Date();
        damageDate  = _damageDate;
        damagedBy = _damagedBy;
        description = _desc;
        _car.addDamageRecord(this);
    }
    /**
     * Format record as a String.
     * String format is Date - Name
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return damageDate.toString() + "-" + damagedBy.getForeName() + " " +damagedBy.getLastName();
    }
    
    /**
     * Get the create date.
     *
     * @return Date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Set the create date.
     *
     * @param createDate Date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    /**
     * Get the date of the damage.
     *
     * @return Date
     */
    public Date getDamageDate() {
        return damageDate;
    }

    /**
     * Set the damage date.
     *
     * @param damageDate Date
     */
    public void setDamageDate(Date damageDate) {
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
