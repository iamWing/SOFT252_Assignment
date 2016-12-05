package models;

import java.util.ArrayList;

/**
 *
 * @author Wing
 */
public class Staff {

    private final String STAFFID;
    private String foreName, lastName, address,licenseNumber, licenseType;

    private Car assignedCar;

    private ArrayList<AllocationRecord> allocationHistory;

    /**
     *
     * @param _STAFFID
     */
    public Staff(String _STAFFID) {
        STAFFID = _STAFFID;
    }

    /**
     *
     * @param _STAFFID
     * @param _fName
     * @param _lName
     * @param _address
     * @param _licenseNumber
     * @param _licenseType
     */
    public Staff(String _STAFFID, String _fName, String _lName, String _address,
            String _licenseNumber, String _licenseType) {
        STAFFID = _STAFFID;
        foreName = _fName;
        lastName = _lName;
        address = _address;
        licenseNumber = _licenseNumber;
        licenseType = _licenseType;
    }

    // --- Getters & Setters --- //

    /**
     *
     * @return
     */
    public String getSTAFFID() {
        return STAFFID;
    }

    /**
     *
     * @return
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     *
     * @param licenseNumber
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     *
     * @return
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     *
     * @param licenseType
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     *
     * @return
     */
    public String getForeName() {
        return foreName;
    }

    /**
     *
     * @param foreName
     */
    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public Car getAssignedCar() {
        return assignedCar;
    }

    /**
     *
     * @param assignedCar
     */
    public void setAssignedCar(Car assignedCar) {
        this.assignedCar = assignedCar;
    }

    // --- Allocation history management --- //

    /**
     *
     * @param _record
     */
    public void addAllocationRecord(AllocationRecord _record) {
        if (allocationHistory == null) {
            allocationHistory = new ArrayList<>();
        }
        allocationHistory.add(_record);
    }

    /**
     *
     * @throws NullPointerException
     */
    public void removeLastAllocationRecord() throws NullPointerException {
        allocationHistory.remove(allocationHistory.size() - 1);
    }

    /**
     *
     * @return
     * @throws NullPointerException
     */
    public ArrayList<AllocationRecord> getAllocationRecords() throws
            NullPointerException {
        return allocationHistory;
    }
}
