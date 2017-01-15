package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.AllocationRecord;
import models.Car;
import models.Staff;

/**
 * Command to remove an AllocationRecord from Car and Staff.
 *
 * @author FairyMental
 */
public class RemoveAllocationRecord implements ICommandBehavior{
    private Car car;
    private Staff staff;
    private Date from;
    private Date to;
    AllocationRecord record;
            
    /**
     * Create RemoveAllocationRecord command object.
     * @param _record AllocationRecord
     */
    public RemoveAllocationRecord(AllocationRecord targetRecord)
    {
        record = targetRecord;
        car = record.getCar();
        staff = record.getStaff();
        from = record.getStartDate();
        to = record.getStartDate();
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
        record = new AllocationRecord(car, staff, from, to);
        return true;
    }
}
