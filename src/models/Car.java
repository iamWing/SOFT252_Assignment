/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Wing
 */
public class Car {

    private int carId;
    private String brand;
    private String model;
    private int seats;
    private String description;

    private ArrayList<AllocationRecord> allocationHistory;
    private ArrayList<DamageRecord> damageHistory;

    private boolean allocated = false;
    private boolean damaged = false;
    private boolean enabled = true;

    public Car(int _carId, String _brand, String _model, int _seats, 
            String _desc) {
        carId = _carId;
        brand = _brand;
        model = _model;
        seats = _seats;
        description = _desc;
    }

    // --- Getters & Setters --- //
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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

    public boolean getAllocated() {
        return allocated;
    }

    public void setAllocated(boolean _status) {
        allocated = _status;
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
    
    public void addAllocationRecord(AllocationRecord _record) throws 
            NullPointerException {
        allocationHistory.add(_record);
    }

    public void removeLastAllocationRecord() throws NullPointerException {
        allocationHistory.remove(allocationHistory.size() - 1);
    }

    // --- Damage history management --- //

    public void addDamageRecord(DamageRecord _record) throws 
            NullPointerException {
        damageHistory.add(_record);
    }

    public void removeLastDamageRecord() throws NullPointerException {
        damageHistory.remove(damageHistory.size() - 1);
    }
}
