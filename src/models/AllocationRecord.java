/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Calendar;

/**
 *
 * @author Wing
 */
public class AllocationRecord {

    private final Car car;
    private final Staff staff;
    
    private final boolean longTermAllocation;
    private final Calendar startDate, endDate;

    /**
     * 
     * @param _car
     * @param _staff
     * @param _startDate
     */
    public AllocationRecord(Car _car, Staff _staff, Calendar _startDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;
        endDate = null;

        longTermAllocation = true;
    }

    /**
     *
     * @param _car
     * @param _staff
     * @param _startDate
     * @param _endDate
     */
    public AllocationRecord(Car _car, Staff _staff, Calendar _startDate, 
            Calendar _endDate) {
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
    public Calendar getStarDate() {
        return startDate;
    }

    /**
     *
     * @return
     * @throws NullPointerException
     */
    public Calendar getEndDate() throws NullPointerException {
        return endDate;
    }
}
