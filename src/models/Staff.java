package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class to represent an employee.
 *
 * @author Wing
 */
public class Staff implements Serializable {

    private final String STAFFID;
    private String foreName, lastName, address,licenseNumber, licenseType;

    private Car assignedCar;

    private ArrayList<AllocationRecord> allocationHistory;
    
    private boolean hasCarAllocated = false;

    /**
     * Constructor, Create new employee.
     *
     * @param _STAFFID String
     */
    public Staff(String _STAFFID) {
        STAFFID = _STAFFID;
        allocationHistory = new ArrayList<AllocationRecord>();
    }

    /**
     * Constructor, Create new employee.
     *
     * @param _STAFFID String
     * @param _fName String First name.
     * @param _lName String Last name.
     * @param _address String Address.
     * @param _licenseNumber String Driving license number.
     * @param _licenseType String Driving license type.
     */
    public Staff(String _STAFFID, String _fName, String _lName, String _address,
            String _licenseNumber, String _licenseType) {
        STAFFID = _STAFFID;
        foreName = _fName;
        lastName = _lName;
        address = _address;
        licenseNumber = _licenseNumber;
        licenseType = _licenseType;
        
        allocationHistory = new ArrayList<AllocationRecord>();
    }

        // --- Getters & Setters --- //
    
    public boolean hasCarAllocated() {
        return hasCarAllocated;
    }
    public void setHasCarAllocated(boolean hasCarAllocated) {    
        this.hasCarAllocated = hasCarAllocated;
    }

    /**
     * Get Employee ID.
     *
     * @return String
     */
    public String getSTAFFID() {
        return STAFFID;
    }

    /**
     * Get driving license number.
     *
     * @return String
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * set driving license number.
     *
     * @param licenseNumber String
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * Set driving license type.
     *
     * @return String
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * Get driving license type.
     *
     * @param licenseType String
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * Get first name.
     *
     * @return String
     */
    public String getForeName() {
        return foreName;
    }

    /**
     * Set first name.
     *
     * @param foreName String
     */
    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    /**
     * Get last name.
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set last name.
     *
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get address.
     *
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.
     *
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get current car.
     *
     * @return Car
     */
    public Car getAssignedCar() {
        return assignedCar;
    }

    /**
     * Set current car.
     *
     * @param assignedCar Car
     */
    public void setAssignedCar(Car assignedCar) {
        this.assignedCar = assignedCar;
    }

    // --- Allocation history management --- //

    /**
     * For use by AllocationRecord object. Do not use.
     *
     * @param _record AllocationRecord
     */
    public void addAllocationRecord(AllocationRecord _record) {
        if (allocationHistory == null) {
            allocationHistory = new ArrayList<>();
        }
        allocationHistory.add(_record);
    }

    /**
     * For use by AllocationRecord object. Do not use.
     *
     * @throws NullPointerException No allocation records exist.
     */
    public void removeLastAllocationRecord() throws NullPointerException {
        allocationHistory.remove(allocationHistory.size() - 1);
    }

    /**
     * Convert to String.
     * String format is StaffID: Forename Surname
     *
     * @return String
     */
    public String toString() {
        return this.getSTAFFID() + ": " + this.getForeName() + " " + this.getLastName();
    }
 
    /**
     * Get allocation history.
     *
     * @return ArrayList&lt;AllocationRecord&gt;
     * @throws NullPointerException No allocation records exist.
     */
    public ArrayList<AllocationRecord> getAllocationRecords() throws
            NullPointerException {
        if (allocationHistory == null)
            throw new NullPointerException();
        return allocationHistory;
    }
}
