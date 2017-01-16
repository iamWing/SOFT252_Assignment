package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import java.util.Date;
import models.Car;
import models.Insurance;

/**
 * Command to set vehicle Insurance .
 *
 * @author Wing
 */
public class AddInsurance implements ICommandBehavior {

    private Car vehicle;
    private Insurance insurance;
    private String company, insuranceNumber;
    private Date startDate, endDate;

    /**
     * Create AddInsurance command object.
     * 
     * @param _vehicle Car
     * @param _company String
     * @param _insuranceNumber String
     * @param _startDate Date
     * @param _endDate Date
     */
    public AddInsurance(Car _vehicle, String _company, String _insuranceNumber,
            Date _startDate, Date _endDate) {
        vehicle = _vehicle;
        company = _company;
        insuranceNumber = _insuranceNumber;
        startDate = _startDate;
        endDate = _endDate;
    }

    /**
     * Executes the command.
     * @return success
     * @throws Exception if insurance already set.
     */
    @Override
    public boolean executeCommand() throws Exception {
        for (Car _currVehicle : Datastore.GetCars()) {
            if (_currVehicle.getInsurance() != null && _currVehicle.getInsurance().getInsuranceNumber()
                    .equals(insuranceNumber)) {
                throw new Exception(
                        "Insurance number existed in other vehicle already");
            }
        }
        insurance = new Insurance(company, insuranceNumber,
                startDate, endDate);
        if (vehicle.getInsurance() == null) {
            vehicle.setInsurance(insurance);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Undo the command.
     * 
     * @return success
     */
    @Override
    public boolean undoCommand() {
        if (vehicle.getInsurance() == insurance) {
            vehicle.setInsurance(null);
            return true;
        } else {
            return false;
        }
    }

}
