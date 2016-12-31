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
    
    public Service()
    {
        inDate = null;
        outDate = null;
        
        description = "";
    }
    
    public Service (Date _inDate, Date _outDate, String _description)
    {
        inDate = _inDate;
        outDate = _outDate;
        
        description = _description;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString()
    {
        return inDate + "-" + outDate + ": " + description;
    }
}
