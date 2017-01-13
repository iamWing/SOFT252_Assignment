/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.Car;
import models.DamageRecord;

/**
 *
 * @author FairyMental
 */
public class RemoveDamageRecord implements ICommandBehavior {
    private Car car;
    private DamageRecord record;
    
    
    public RemoveDamageRecord (Car _car,DamageRecord _record)
    {
        car = _car;
        record = _record;
    }
    @Override
    public boolean executeCommand()
    {
        car.removeDamageRecord(record);
        return true;
    }
    @Override
    public boolean undoCommand()
    {
        car.addDamageRecord(record);
        return true;
    }
}
