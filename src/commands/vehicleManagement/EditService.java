package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.Service;

/**
 * Command for edit service record
 * @author Wing
 */
public class EditService implements ICommandBehavior {
    
    private Date _inDate, _outDate;
    private String _desc;
    
    private Date inDate, outDate;
    private String desc;
    
    private Service service;
    
    /**
     * Create edit command.
     * @param _service Service
     * @param _inDate Date
     * @param _outDate Date
     * @param _desc Date
     */
    public EditService (Service _service, Date _inDate, Date _outDate, 
            String _desc) {
        service = _service;
        inDate = _inDate;
        outDate = _outDate;
        desc = ((_desc != null) && (!_desc.isEmpty())) ? _desc : "";
    }

    /**
     * Executes the command.
     * @return success
     * @throws Exception on error.
     */
    @Override
    public boolean executeCommand() throws Exception {
        _inDate = service.getInDate();
        _outDate = service.getOutDate();
        _desc = service.getDescription();
        
        if (inDate != null)
            service.setInDate(inDate);
        if (outDate != null)
            service.setOutDate(outDate);
        if (!desc.isEmpty())
            service.setDescription(desc);
        
        return true;
    }

    /**
     * Undo the command.
     * 
     * @return success
     * @throws Exception on error.
     */
    @Override
    public boolean undoCommand() throws Exception {
        if (service.getInDate() != _inDate)
            service.setInDate(_inDate);
        if (service.getOutDate() != _outDate)
            service.setOutDate(_outDate);
        if (!service.getDescription().equals(_desc))
            service.setDescription(_desc);
        
        return true;
    }
    
}
