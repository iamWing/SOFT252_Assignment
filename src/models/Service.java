/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author FairyMental
 */
public class Service implements Serializable {
    
    private Date inDate;
    private Date outDate;
    
    private String description;
    
    /**
     * Empty Constructor, Exists for compatibility purposes.
     * Should not be used.
     */
    public Service()
    {
        inDate = null;
        outDate = null;
        
        description = "";
    }
    
    /**
     * Constructor, creates Service record.
     *
     * @param _inDate Date When the vehicle goes in for service.
     * @param _outDate Date When the vehicle is returned.
     * @param _description String Description of damage.
     */
    public Service (Date _inDate, Date _outDate, String _description)
    {
        inDate = _inDate;
        outDate = _outDate;
        
        description = _description;
    }

    /**
     * Get date of service.
     *
     * @return Date
     */
    public Date getInDate() {
        return inDate;
    }

    /**
     * Set date of service.
     *
     * @param inDate Date of service.
     */
    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    /**
     * Get date of return.
     *
     * @return Date
     */
    public Date getOutDate() {
        return outDate;
    }

    /**
     * Set date of return.
     *
     * @param outDate Date of return from service.
     */
    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    /**
     * Get description of damage.
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of damage.
     *
     * @param description String Description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Format record as a String.
     * String format is StartDate-EndDate: Description
     *
     * @return String
     */
    @Override
    public String toString()
    {
        return inDate + "-" + outDate + ": " + description;
    }
}
