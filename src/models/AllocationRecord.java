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

    public AllocationRecord(Car _car, Staff _staff, Date _startDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;

        longTermAllocation = true;
    }

    public AllocationRecord(Car _car, Staff _staff, Date _startDate, 
            Date _endDate) {
        car = _car;
        staff = _staff;
        startDate = _startDate;
        endDate = _endDate;

        longTermAllocation = false;
    }

    public Car getCar() {
        return car;
    }

    public Staff getStaff() {
        return staff;
    }

    public Date getStarDate() {
        return startDate;
    }

    public Date getEndDate() throws NullPointerException {
        return endDate;
    }
}
