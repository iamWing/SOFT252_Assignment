/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.Car;
import models.DamageRecord;
import models.Staff;

/**
 *
 * @author FairyMental
 */
public class AddDamageRecord implements ICommandBehavior {
    private Car car;
    private DamageRecord record;
    
    private Date damageDate;
    private Staff damagedBy;
    private String description;
    
    public AddDamageRecord(Car _car, Date _damageDate, Staff _damagedBy, String _description)
    {
        car = _car;
        
        damageDate = _damageDate;
        damagedBy = _damagedBy;
        description = _description;
    }
    
    @Override
    public boolean executeCommand()
    {
        record = new DamageRecord(car,damageDate,damagedBy, description);
        return true;
    }
    @Override
    public boolean undoCommand()
    {
        car.removeDamageRecord(record);
        return true;
    }
}
