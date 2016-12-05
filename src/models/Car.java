package models;

import java.util.ArrayList;

/**
 *
 * @author Wing
 */
public class Car {

    private final String CARID;
    private String brand;
    private String model;
    private int seats;
    private String description;

    private CarParks location;
    private Insurance insurance;

    private ArrayList<AllocationRecord> allocationHistory;
    private ArrayList<DamageRecord> damageHistory;

    private boolean allocated = false;
    private boolean damaged = false;
    private boolean enabled = true;

    /**
     *
     * @param _CARID
     */
    public Car(String _CARID) {
        CARID = _CARID;
    }

    /**
     *
     * @param _CARID
     * @param _brand
     * @param _model
     * @param _seats
     * @param _loc
     */
    public Car(String _CARID, String _brand, String _model, int _seats, 
            CarParks _loc, String _description) {

        CARID = _CARID;
        brand = _brand;
        model = _model;
        seats = _seats;
        location = _loc;
        description = _description;
    }

    // --- Getters & Setters --- //

    /**
     *
     * @return
     */
    public String getCARID() {    
        return CARID;
    }

    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return
     */
    public int getSeats() {
        return seats;
    }

    /**
     *
     * @param seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public CarParks getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(CarParks location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     *
     * @param insurance
     */
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    /**
     *
     * @return
     */
    public boolean isAllocated() {
        return allocated;
    }

    /**
     *
     * @param allocated
     */
    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    /**
     *
     * @return
     */
    public boolean isDamaged() {
        return damaged;
    }

    /**
     *
     * @param damaged
     */
    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    // --- Damage history management --- //

    /**
     *
     * @param _record
     */
    public void addDamageRecord(DamageRecord _record) {
        if (damageHistory == null) {
            damageHistory = new ArrayList<>();
        }
        damageHistory.add(_record);
    }

    /**
     *
     * @throws NullPointerException
     */
    public void removeLastDamageRecord() throws NullPointerException {
        damageHistory.remove(damageHistory.size() - 1);
    }

    /**
     *
     * @return
     * @throws NullPointerException
     */
    public ArrayList<DamageRecord> getDamageRecords() throws
            NullPointerException {
        return damageHistory;
    }
}
