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
public class AllocationRecord {

    private Car car;
    private Staff staff;
    
    private boolean longTermAllocation;
    private Date startDate, endDate;

    /**
     * 
     * @param _car
     * @param _staff
     * @param _startDate
     */
    public AllocationRecord(Car _car, Staff _staff, Date _startDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;

        longTermAllocation = true;
    }

    /**
     *
     * @param _car
     * @param _staff
     * @param _startDate
     * @param _endDate
     */
    public AllocationRecord(Car _car, Staff _staff, Date _startDate, 
            Date _endDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;
        endDate = _endDate;

        longTermAllocation = false;
    }

    /**
     *
     * @return
     */
    public Car getCar() {
        return car;
    }

    /**
     *
     * @return
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     *
     * @return
     */
    public boolean getLongTermAllocation() {
        return longTermAllocation;
    }

    /**
     *
     * @return
     */
    public Date getStarDate() {
        return startDate;
    }

    /**
     *
     * @return
     * @throws NullPointerException
     */
    public Date getEndDate() throws NullPointerException {
        return endDate;
    }
}
