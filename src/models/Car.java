package models;

import java.util.ArrayList;

public class Car {

    private final char CARID;
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

    public Car(char _CARID) {
        CARID = _CARID;
    }

    public Car(char _CARID, String _brand, String _model, int _seats, 
            CarParks _loc) {
        CARID = _CARID;
        brand = _brand;
        model = _model;
        seats = _seats;
        location = _loc;
    }

    // --- Getters & Setters --- //
    public char getCARID() {    
        return CARID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarParks getLocation() {
        return location;
    }

    public void setLocation(CarParks location) {
        this.location = location;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isAllocated() {
        return allocated;
    }

    public void setAllocated(boolean allocated) {
        this.allocated = allocated;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    // --- Damage history management --- //
    public void addDamageRecord(DamageRecord _record) {
        if (damageHistory == null) {
            damageHistory = new ArrayList<>();
        }
        damageHistory.add(_record);
    }

    public void removeLastDamageRecord() throws NullPointerException {
        damageHistory.remove(damageHistory.size() - 1);
    }

    public ArrayList<DamageRecord> getDamageRecords() throws
            NullPointerException {
        return damageHistory;
    }
}
