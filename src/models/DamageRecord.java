/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 * @author Wing
 */
public class DamageRecord {
    
    private LocalDateTime createDate;
    private Calendar damageDate;
    private Staff damagedBy;
    private String description;

    /**
     *
     * @param _damageDate
     * @param _damagedBy
     * @param _desc
     */
    public DamageRecord(Calendar _damageDate, Staff _damagedBy, String _desc) {
        createDate = LocalDateTime.now();
        damageDate  = _damageDate;
        damagedBy = _damagedBy;
        description = _desc;
    }

    /**
     *
     * @return
     */
    public Calendar getDamageDate() {
        return damageDate;
    }

    /**
     *
     * @param damageDate
     */
    public void setDamageDate(Calendar damageDate) {
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
