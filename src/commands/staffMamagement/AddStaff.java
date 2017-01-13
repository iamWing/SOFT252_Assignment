package commands.staffMamagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Staff;

/**
 * Command to add a Staff object to the datastore.
 *
 * @author FairyMental
 */
public class AddStaff implements ICommandBehavior {
    private Staff staff;
    /**
     * Creates AddStaff Command object.
     * 
     * @param _staffId String
     * @param _fName String
     * @param _lName String
     * @param _address String
     * @param _licenseNumber String
     * @param _licenseType String
     */
    public AddStaff(String _staffId, String _fName, String _lName, String _address, String _licenseNumber, String _licenseType)
    {
        staff = new Staff(_staffId, _fName, _lName, _address, _licenseNumber, _licenseType);        
    }
    /**
     * Creates AddStaff Command object.
     * 
     * @param _staff Staff to add.
     */
    public AddStaff( Staff _staff)
    {
        staff = _staff;
    }
    /**
     * Executes the command.
     * @return success
     * @throws Exception on error.
     */
    @Override
    public boolean executeCommand() throws Exception
    {
        for(Staff curStaff : Datastore.GetStaff())
        {
            if(curStaff.getSTAFFID().equals(staff.getSTAFFID()))
                throw new Exception("Staff ID exists");
        }
        return Datastore.AddStaff(staff);
    }
    /**
     * Undo the command.
     * 
     * @return success
     */
    @Override
    public boolean undoCommand()
    {
        return Datastore.RemoveStaff(staff);
    }
}
