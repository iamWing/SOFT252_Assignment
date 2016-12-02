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

    public DamageRecord(Date _damageDate, Staff _damagedBy, String _desc) {
        damageDate  = _damageDate;
        damagedBy = _damagedBy;
        description = _desc;
    }

    public Date getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(Date damageDate) {
        this.damageDate = damageDate;
    }

    public Staff getDamagedBy() {
        return damagedBy;
    }

    public void setDamagedBy(Staff damagedBy) {
        this.damagedBy = damagedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
