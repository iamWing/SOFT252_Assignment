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
