package models;

import java.util.ArrayList;

public class Staff {

    private final int STAFFID;
    private char licenseNumber, licenseType;
    private String foreName, lastName, address;

    private Car assignedCar;

    private ArrayList<AllocationRecord> allocationHistory;

    public Staff(char _STAFFID) {
        STAFFID = _STAFFID;
    }

    public Staff(int _STAFFID, String _fName, String _lName, String _address,
            char _licenseNumber, char _licenseType) {
        STAFFID = _STAFFID;
        foreName = _fName;
        lastName = _lName;
        address = _address;
        licenseNumber = _licenseNumber;
        licenseType = _licenseType;
    }

    // --- Getters & Setters --- //
    public int getSTAFFID() {
        return STAFFID;
    }

    public char getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(char licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public char getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(char licenseType) {
        this.licenseType = licenseType;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Car getAssignedCar() {
        return assignedCar;
    }

    public void setAssignedCar(Car assignedCar) {
        this.assignedCar = assignedCar;
    }

    // --- Allocation history management --- //
    public void addAllocationRecord(AllocationRecord _record) {
        if (allocationHistory == null) {
            allocationHistory = new ArrayList<>();
        }
        allocationHistory.add(_record);
    }

    public void removeLastAllocationRecord() throws NullPointerException {
        allocationHistory.remove(allocationHistory.size() - 1);
    }

    public ArrayList<AllocationRecord> getAllocationRecords() throws
            NullPointerException {
        return allocationHistory;
    }
}
