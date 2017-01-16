package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Car;
import models.CarParks;

/**
 * Command to remove Car from datastore.
 *
 * @author FairyMental
 */
public class RemoveVehicle implements ICommandBehavior{
    private Car car;
    
    /**
     * Create RemoveVehicle Command
     * 
     * @param _carId String
     * @throws Exception if not found
     */
    public RemoveVehicle(String _carId) throws Exception {
        for (Car _car : Datastore.GetCars()) {
            if (_car.getCARID().equals(_carId)) {
                car = _car;
            }

        }
        if (car == null) 
            throw new Exception("CARID does not exist");
    }

    /**
     * Create RemoveVehicle COmmand
     * @param _car Car
     */
    public RemoveVehicle(Car _car)
    {
        car = _car;
    }
    
    /**
     * Executes the command.
     * @return success
     */
    @Override
    public boolean executeCommand()
    {
        return Datastore.RemoveCar(car);
    }
    /**
     * Undo the command.
     * 
     * @return success
     * @throws Exception if vehicle already exists.
     */
    @Override
    public boolean undoCommand() throws Exception
    {
        for (Car obj : Datastore.GetCars())
            if (obj.getCARID().equals(car.getCARID()))
                throw new Exception("CARID existed");
        return Datastore.AddCar(car);
    }
}
