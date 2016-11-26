package models;

import java.util.Date;
import models.Staff;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fairymental
 */


public class CarAllocationHistory {
    private Staff rentingStaff;
    private Date rentedDay;
    

    public void CarAllocationhistory(Date rentedDay, Staff rentingStaff)
    {
        this.rentedDay = rentedDay;
        this.rentingStaff=rentingStaff;
    
    }
    
    public Staff getRentingStaff() {
        return rentingStaff;
    }

    public void setRentingStaff(Staff rentingStaff) {
        this.rentingStaff = rentingStaff;
    }
    
}
