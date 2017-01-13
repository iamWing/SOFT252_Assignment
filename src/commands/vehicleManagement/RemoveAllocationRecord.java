/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.AllocationRecord;
import models.Car;
import models.Insurance;

/**
 *
 * @author FairyMental
 */
public class RemoveAllocationRecord implements ICommandBehavior{
    private Car car;
    private AllocationRecord record;
    
    
    public RemoveAllocationRecord(AllocationRecord _record)
    {
        record = _record;
        
    }
    
    @Override
    public boolean executeCommand()
    {
        record.Delete();
        return true;
    }
    @Override
    public boolean undoCommand()
    {
        car.addAllocationRecord(record);
        record.getStaff().addAllocationRecord(record);
        
        return true;
    }
}
