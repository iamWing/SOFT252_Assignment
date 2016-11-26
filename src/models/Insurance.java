/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Wing
 */
public class Insurance {

    private String company;
    private char insuranceNumber;
    private Date startDate, endDate;

    private Car car;

    public Insurance(String _company, char _insuranceNumber, Date _startDate, 
            Date _endDate, Car _car) {
        company = _company;
        insuranceNumber = _insuranceNumber;
        startDate = _startDate;
        endDate = _endDate;
        car = _car;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public char getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(char insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Car getCar() {
        return car;
    }
}
