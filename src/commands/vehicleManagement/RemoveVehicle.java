/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Car;
import models.CarParks;

/**
 *
 * @author FairyMental
 */
public class RemoveVehicle implements ICommandBehavior{
    private Car car;
    
    public RemoveVehicle(String _carId) throws Exception {
        for (Car _car : Datastore.GetCars()) {
            if (_car.getCARID().equals(_carId)) {
                car = _car;
            }

            throw new Exception("CARID does not exist");
        }
    }

    public RemoveVehicle(Car _car)
    {
        car = _car;
    }
    
    @Override
    public boolean executeCommand()
    {
        return Datastore.RemoveCar(car);
    }
    @Override
    public boolean undoCommand() throws Exception
    {
        for (CarParks CarPark : CarParks.values()) {
            for (Car obj : Datastore.GetCars(CarPark)) {
                if (obj.getCARID().equals(car.getCARID()))
                    throw new Exception("CARID existed");
            }
        }
        return Datastore.AddCar(car);
    }
}
