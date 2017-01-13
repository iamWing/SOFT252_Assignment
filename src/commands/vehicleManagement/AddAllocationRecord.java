/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.AllocationRecord;
import models.Car;
import models.Staff;

/**
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
    
    public AddAllocationRecord(Car _car, Staff _staff, Date _startDate, Date _endDate)
    {
        longTermAllocation = true;
        
        car = _car;
        staff = _staff;
        
        startDate = _startDate;
        endDate = _endDate;
    }
    public AddAllocationRecord(Car _car, Staff _staff, Date _startDate)
    {
        longTermAllocation = false;
        
        car = _car;
        staff = _staff;
        startDate = _startDate;
    }
    
    @Override
    public boolean executeCommand()
    {
        if(longTermAllocation)
            record = new AllocationRecord(car,staff, startDate, endDate);
        else
            record = new AllocationRecord(car,staff,startDate);
        return true;
    }
    @Override
    public boolean undoCommand()
    {
        record.Delete();
        return true;
    }
}
