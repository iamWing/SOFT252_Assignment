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

    public Insurance(String _company, char _insuranceNumber, Date _startDate, 
            Date _endDate) {
        company = _company;
        insuranceNumber = _insuranceNumber;
        startDate = _startDate;
        endDate = _endDate;
    }
}
