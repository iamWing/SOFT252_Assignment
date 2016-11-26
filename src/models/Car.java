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

    private ArrayList<AllocationRecord> allocationHistory;

    private boolean allocated = false;

    public Car(int _carId, String _brand, String _model, int _seats) {
        carId = _carId;
        brand = _brand;
        model = _model;
        seats = _seats;
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

    public boolean getAllocated() {
        return allocated;
    }

    public void setAllocated(boolean _status) {
        allocated = _status;
    }

    // --- Allocation history management --- //
    public void addAllocationRecord(AllocationRecord _record) {
        allocationHistory.add(_record);
    }

    public void removeLastAllocationRecord() {
        allocationHistory.remove(allocationHistory.size() - 1);
    }
}
