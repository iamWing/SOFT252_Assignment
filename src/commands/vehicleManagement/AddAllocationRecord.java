package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.AllocationRecord;
import models.Car;
import models.Staff;

/**
 * Command to add an AllocationRecord to Car and Staff.
 *
 * @author FairyMental
 */
public class AddAllocationRecord implements ICommandBehavior{
    private Car car;
    private Staff staff;
    
    private AllocationRecord record;
    
    private boolean longTermAllocation;
    private Date startDate;
    private Date endDate;
    
    /**
     * Create AddAllocationRecord command object.
     * 
     * @param _car
     * @param _staff
     * @param _startDate
     * @param _endDate 
     */
    public AddAllocationRecord(Car _car, Staff _staff, Date _startDate, Date _endDate)
    {
        longTermAllocation = true;
        
        car = _car;
        staff = _staff;
        
        startDate = _startDate;
        endDate = _endDate;
    }
    /**
     * Create AddAllocationRecord command object.
     * 
     * @param _car Car
     * @param _staff Staff
     * @param _startDate  Date
     */
    public AddAllocationRecord(Car _car, Staff _staff, Date _startDate)
    {
        longTermAllocation = false;
        
        car = _car;
        staff = _staff;
        startDate = _startDate;
    }
    
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        if(longTermAllocation)
            record = new AllocationRecord(car,staff, startDate, endDate);
        else
            record = new AllocationRecord(car,staff,startDate);
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
        record.Delete();
        return true;
    }
}