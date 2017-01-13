/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands.staffMamagement;

import commands.interfaces.ICommandBehavior;
import data.Datastore;
import models.Staff;

/**
 *
 * @author Wing
 */
public class EditStaff implements ICommandBehavior {

    private String _fName, _lName, _addr, _licenseNumber, _licenseType;
    private String staffId, fName, lName, addr, licenseNumber, licenseType;
    private Staff staff;

    public EditStaff(String _staffId, String _fName, String _lName, String _addr, String _lincenseNumber, String _linceseType) {
        staffId = _staffId;
        fName = ((_fName != null) && (!_fName.isEmpty())) ? _fName : "";
        lName = ((_lName != null) && (!_lName.isEmpty())) ? _lName : "";
        addr = ((_addr != null) && (!_addr.isEmpty())) ? _addr : "";
        licenseNumber = ((_lincenseNumber != null)
                && (!_lincenseNumber.isEmpty())) ? _lincenseNumber : "";
        licenseType = ((_linceseType != null)
                && (!_linceseType.isEmpty())) ? _linceseType : "";
    }

    @Override
    public boolean executeCommand() throws Exception {
        for (Staff _staff : Datastore.GetStaff()) {
            if (_staff.getSTAFFID().equals(staffId)) {
                staff = _staff;
            }
        }
        if (staff != null) {
            _fName = staff.getForeName();
            _lName = staff.getLastName();
            _addr = staff.getAddress();
            _licenseNumber = staff.getLicenseNumber();
            _licenseType = staff.getLicenseType();

            if (!fName.isEmpty()) {
                staff.setForeName(fName);
            }
            if (!lName.isEmpty()) {
                staff.setLastName(lName);
            }
            if (!addr.isEmpty()) {
                staff.setAddress(addr);
            }
            if (!licenseNumber.isEmpty()) {
                staff.setLicenseNumber(licenseNumber);
            }
            if (!licenseType.isEmpty()) {
                staff.setLicenseType(licenseType);
            }

            return true;
        } else {
            throw new Exception("Staff ID does not exist");
        }
    }

    @Override
    public boolean undoCommand() throws Exception {
        for (Staff _staff : Datastore.GetStaff()) {
            if (_staff == staff) {
                if (!staff.getForeName().equals(_fName)) {
                    staff.setForeName(_fName);
                }
                if (!staff.getLastName().equals(_lName)) {
                    staff.setLastName(_lName);
                }
                if (!staff.getAddress().equals(_addr)) {
                    staff.setAddress(_addr);
                }
                if (!staff.getLicenseNumber().equals(_licenseNumber)) {
                    staff.setLicenseNumber(_licenseNumber);
                }
                if (!staff.getLicenseType().equals(_licenseType)) {
                    staff.setLicenseType(_licenseType);
                }
                return true;
            }
        }
        throw new Exception("Staff does not exist");
    }
}
