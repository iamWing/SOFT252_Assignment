/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Wing
 */
public class DamageRecord {
    
    private Date damageDate;
    private Staff damagedBy;
    private String description;

    /**
     *
     * @param _damageDate
     * @param _damagedBy
     * @param _desc
     */
    public DamageRecord(Date _damageDate, Staff _damagedBy, String _desc) {
        damageDate  = _damageDate;
        damagedBy = _damagedBy;
        description = _desc;
    }

    /**
     *
     * @return
     */
    public Date getDamageDate() {
        return damageDate;
    }

    /**
     *
     * @param damageDate
     */
    public void setDamageDate(Date damageDate) {
        this.damageDate = damageDate;
    }

    /**
     *
     * @return
     */
    public Staff getDamagedBy() {
        return damagedBy;
    }

    /**
     *
     * @param damagedBy
     */
    public void setDamagedBy(Staff damagedBy) {
        this.damagedBy = damagedBy;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
