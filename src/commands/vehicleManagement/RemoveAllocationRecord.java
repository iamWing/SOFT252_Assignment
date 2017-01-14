package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.AllocationRecord;
import models.Car;
import models.Insurance;

/**
 * Command to remove an AllocationRecord from Car and Staff.
 *
 * @author FairyMental
 */
public class RemoveAllocationRecord implements ICommandBehavior{
    private Car car;
    private AllocationRecord record;
    
    /**
     * Create RemoveAllocationRecord command object.
     * @param _record AllocationRecord
     */
    public RemoveAllocationRecord(AllocationRecord _record)
    {
        record = _record;
        
    }
    
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        record.Delete();
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
        car.addAllocationRecord(record);
        record.getStaff().addAllocationRecord(record);
        
        return true;
    }
}
