package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.Car;
import models.Service;
import other.Utils;

/**
 * Command to add Service record to Car.
 *
 * @author FairyMental
 */
public class AddService implements ICommandBehavior {
    private Car car;
    private Service service;
    
    private Date inDate, outDate;
    private String description;
    
    public AddService(Car _car, Date _inDate, Date _outDate, String _description)
    {
        car = _car;

        inDate = _inDate;
        outDate = _outDate;
        description = _description;
    }
    /**
     * Executes the command.
     * @return success
     */
    @Override 
    public boolean executeCommand()
    {
        service = new Service(inDate,outDate,description);
        car.addServiceRecord(service);
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
        car.removeServiceRecord(service);
        return true;
    }
}
