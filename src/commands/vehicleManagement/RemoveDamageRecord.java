package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.Car;
import models.DamageRecord;

/**
 * Command to remove DamageRecord from Car.
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
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        car.removeDamageRecord(record);
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
        car.addDamageRecord(record);
        return true;
    }
}
