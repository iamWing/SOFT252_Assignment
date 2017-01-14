package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Car;
import models.CarParks;

/**
 * Command to add Car to datastore.
 *
 * @author Wing
 */
public class AddVehicle implements ICommandBehavior {
    private Car vehicle;

    /**
     * Create AddVehicle command object.
     * 
     * @param _carId String
     */
    public AddVehicle(String _carId) {
        vehicle = new Car(_carId);
    }
    /**
     * Create AddVehicle command object.
     * 
     * @param _carId String
     * @param _brand String
     * @param _model String
     * @param _seats int
     * @param _loc CarParks
     * @param _desc String
     */
    public AddVehicle(String _carId, String _brand, String _model, 
            int _seats, CarParks _loc, String _desc) {
        vehicle = new Car(_carId, _brand, _model, _seats, _loc, _desc);
    } 
    /**
     * Create AddVehicle command object.
     * 
     * @param _car Car
     */
    public AddVehicle(Car _car)
    {
        vehicle = _car;
    }

    /**
     * Executes the command.
     * @return success
     * @throws Exception on error.
     */
    @Override
    public boolean executeCommand() throws Exception {
        for (CarParks CarPark : CarParks.values()) {
            for (Car obj : Datastore.GetCars(CarPark)) {
                if (obj.getCARID().equals(vehicle.getCARID()))
                    throw new Exception("CARID existed");
            }
        }
        return Datastore.AddCar(vehicle);
    }

    /**
     * Undo the command.
     * 
     * @return success
     */
    @Override
    public boolean undoCommand() {
        return Datastore.RemoveCar(vehicle);
    }
}
