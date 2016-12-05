/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Wing
 */
public class Insurance {

    private String company;
    private String insuranceNumber;
    private Date startDate, endDate;

    private Car car;

    /**
     *
     * @param _company
     * @param _insuranceNumber
     * @param _startDate
     * @param _endDate
     * @param _car
     */

    public Insurance(String _company, String _insuranceNumber, Date _startDate, 
            Date _endDate, Car _car) {
        company = _company;
        insuranceNumber = _insuranceNumber;
        startDate = _startDate;
        endDate = _endDate;
        car = _car;
    }

    /**
     *
     * @return
     */
    public String getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     *
     * @return
     */
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    /**
     *
     * @param insuranceNumber
     */
    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    /**
     *
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public Car getCar() {
        return car;
    }
}
