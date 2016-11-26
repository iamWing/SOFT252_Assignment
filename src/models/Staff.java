/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Fairymental
 */
public class Staff {

    private String forName;
    private String lastName;
    private int staffID;
    private String address;
    private int licenseNumber;
    private char licenseType;

    private Car assignedCar;

    public Car getAssignedCar() {
        return assignedCar;
    }

    public void setAssignedCar(Car assignedCar) {
        this.assignedCar = assignedCar;
    }

    public void Staff() {
        this.forName = "";
        this.lastName = "";
        this.staffID = 0;
        this.address = "";
        this.licenseNumber = 0;
        this.licenseType = ' ';
    }

    public void Staff(String forName, String lastName, int staffID, String address, int licenseNumber, char licenseType) {
        this.forName = forName;
        this.lastName = lastName;
        this.staffID = staffID;
        this.address = address;
        this.licenseNumber = licenseNumber;
        this.licenseType = licenseType;
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forNmae) {
        this.forName = forNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public char getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(char licenseType) {
        this.licenseType = licenseType;
    }

}
