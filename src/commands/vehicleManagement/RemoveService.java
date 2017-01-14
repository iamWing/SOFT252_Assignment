package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.Car;
import models.Service;

/**
 * Command to remove Service record from Car.
 *
 * @author FairyMental
 */
public class RemoveService implements ICommandBehavior{
    private Car car;
    private Service service;
    
    /**
     * Create RemoveServoce command object.
     * 
     * @param _car Car
     * @param _service Service 
     */
    public RemoveService(Car _car,Service _service)
    {
        car = _car;
        service = _service;
    }
    
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        car.removeServiceRecord(service);
        return true;
    }
    /**
     * Undo the command.
     * 
     * @return success
     */
    public boolean undoCommand()
    {
        car.addServiceRecord(service);
        return true;
    }
}
