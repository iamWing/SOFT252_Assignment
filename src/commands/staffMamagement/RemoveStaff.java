/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.staffMamagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Staff;

/**
 *
 * @author FairyMental
 */
public class RemoveStaff implements ICommandBehavior{
    private Staff staff;
    
    public RemoveStaff(String _staffId) throws Exception
    {
        for (Staff _staff : Datastore.GetStaff()) {
            if (_staff.getSTAFFID().equals(_staffId))
                staff = _staff;
        }
        
        throw new Exception ("Staff ID does not exist");
    }
    public RemoveStaff(Staff _staff)
    {
        if (_staff != null)
            staff = _staff;
    }
    
    @Override
    public boolean executeCommand()
    {
        return Datastore.RemoveStaff(staff);
    }
    @Override
    public boolean undoCommand() throws Exception
    {
        for( Staff curStaff : Datastore.GetStaff())
        {
            if(curStaff.getSTAFFID().equals(staff.getSTAFFID()))
                throw new Exception ("Staff ID exists");
        }
        return Datastore.AddStaff(staff);
    }
}
