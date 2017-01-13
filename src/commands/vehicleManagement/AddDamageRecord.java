package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.Car;
import models.DamageRecord;
import models.Staff;

/**
 * Command to add a DamageRecord to a Car.
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
    
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        record = new DamageRecord(car,damageDate,damagedBy, description);
        return true;
    }
    /**
     * Undo the command.
     * 
     * @return success
     */
    @Override
    public boolean undoCommand()
    {
        car.removeDamageRecord(record);
        return true;
    }
}
