/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import java.util.Date;
import models.Car;
import models.Service;
import other.Utils;

/**
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
    @Override 
    public boolean executeCommand()
    {
        service = new Service(inDate,outDate,description);
        car.addServiceRecord(service);
        return true;
    }
    
    @Override
    public boolean undoCommand()
    {
        car.removeServiceRecord(service);
        return true;
    }
}
