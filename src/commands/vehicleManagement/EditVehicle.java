package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Car;
import models.CarParks;
import models.Insurance;


/**
 *
 * @author Wing
 */
public class EditVehicle implements ICommandBehavior {
    
    private String _brand, _model, _desc;
    private int _seats;
    private CarParks _loc;
    private Insurance _insurance;
    private boolean _damaged;
    
    private String vechicleID, brand, model, desc;
    private int seats;
    private CarParks loc;
    private Insurance insurance;
    private boolean damaged;
    
    private Car vechicle;
    
    public EditVehicle(String _vechicleID, String _brand, String _model, int _seats, 
            String _desc, CarParks _loc, Insurance _insurance, boolean _damaged) {
        vechicleID = _vechicleID;
        brand = ((_brand != null) &&(!_brand.isEmpty())) ? _brand : "";
        model  = ((_model != null) && (!_model.isEmpty())) ? _model : "";
        seats = ((_seats != 0)) ? _seats : 0;
        desc = ((_desc != null) && (!_desc.isEmpty())) ? _desc : "";
        loc = _loc;
        insurance = _insurance;
        damaged = _damaged;
    }

    @Override
    public boolean executeCommand() throws Exception {
        for (Car _vechicle : Datastore.GetCars()) {
            if (_vechicle.getCARID().equals(vechicleID)) {
                vechicle = _vechicle;
            }
        }
        if (vechicle != null) {
            _brand = vechicle.getBrand();
            _model = vechicle.getModel();
            _seats = vechicle.getSeats();
            _desc = vechicle.getDescription();
            _loc = vechicle.getLocation();
            _insurance = vechicle.getInsurance();
            _damaged = vechicle.isDamaged();
            
            if (!brand.isEmpty()) {
                vechicle.setBrand(brand);
            }
            if (!model.isEmpty()) {
                vechicle.setModel(model);
            }
            if (seats != 0) {
                vechicle.setSeats(seats);
            }
            if (!desc.isEmpty()) {
                vechicle.setDescription(desc);
            }
            if (loc != null) {
                vechicle.setLocation(loc);
            }
            if (insurance != null) {
                vechicle.setInsurance(insurance);
            }
            vechicle.setDamaged(damaged);
            
            return true;
        } else {
            throw new Exception("Vechicle ID does not exist");
        }
    }

    @Override
    public boolean undoCommand() throws Exception {
        for (Car _vechicle : Datastore.GetCars()) {
            if (_vechicle == vechicle) {
                if (!vechicle.getBrand().equals(_brand))
                    vechicle.setBrand(_brand);
                if (!vechicle.getModel().equals(_model))
                    vechicle.setModel(_model);
                if (vechicle.getSeats() != _seats)
                    vechicle.setSeats(_seats);
                if (!vechicle.getDescription().equals(_desc))
                    vechicle.setDescription(_desc);
                if (vechicle.getLocation() != _loc)
                    vechicle.setLocation(_loc);
                if (vechicle.getInsurance() != insurance)
                    vechicle.setInsurance(_insurance);
                if (vechicle.isDamaged() != _damaged)
                    vechicle.setDamaged(_damaged);
                
                return true;
            }
        }
        throw new Exception("Vechicle does not exist");
    }
    
}
