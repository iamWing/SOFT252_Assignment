/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import models.Car;
import models.Service;

/**
 *
 * @author FairyMental
 */
public class RemoveService implements ICommandBehavior{
    private Car car;
    private Service service;
    
    public RemoveService(Car _car,Service _service)
    {
        car = _car;
        service = _service;
    }
    
    @Override
    public boolean executeCommand()
    {
        
        car.removeServiceRecord(service);
        return true;
    }
    public boolean undoCommand()
    {
        car.addServiceRecord(service);
        return true;
    }
}
