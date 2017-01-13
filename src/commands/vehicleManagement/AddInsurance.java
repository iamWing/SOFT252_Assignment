/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.vehicleManagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import java.util.Date;
import models.Car;
import models.Insurance;

/**
 *
 * @author Wing
 */
public class AddInsurance implements ICommandBehavior {

    private Car vehicle;
    private Insurance insurance;
    private String company, insuranceNumber;
    private Date startDate, endDate;

    public AddInsurance(Car _vehicle, String _company, String _insuranceNumber,
            Date _startDate, Date _endDate) {
        vehicle = _vehicle;
        company = _company;
        insuranceNumber = _insuranceNumber;
        startDate = _startDate;
        endDate = _endDate;
    }

    @Override
    public boolean executeCommand() throws Exception {
        for (Car _currVehicle : Datastore.GetCars()) {
            if (_currVehicle.getInsurance().getInsuranceNumber()
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

    @Override
    public boolean undoCommand() throws Exception {
        if (vehicle.getInsurance() == insurance) {
            vehicle.setInsurance(null);
            return true;
        } else {
            return false;
        }
    }

}
