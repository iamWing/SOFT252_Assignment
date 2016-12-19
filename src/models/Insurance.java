package models;

import java.io.Serializable;
import java.util.Date;

/**
 * Class to hold insurance details.
 *
 * @author Wing
 */
public class Insurance implements Serializable {

    private String company;
    private String insuranceNumber;
    private Date startDate, endDate;

    private Car car;

    /**
     *
     * @param _company String Name of insurance company.
     * @param _insuranceNumber String ID Of Insurance policy.
     * @param _startDate Date Start date of policy.
     * @param _endDate Date End date of policy.
     * @param _car Car Vehicle the policy applies to.
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
     * Get Insurance company.
     *
     * @return String
     */
    public String getCompany() {
        return company;
    }

    /**
     * Set Insurance Company
     *
     * @param company String
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Get Insurance Policy Number.
     *
     * @return String
     */
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    /**
     * Set Insurance policy number.
     *
     * @param insuranceNumber String
     */
    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    /**
     * Get start date of policy.
     *
     * @return Date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set start date of policy.
     *
     * @param startDate Date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get end date of policy.
     *
     * @return Date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set end date of policy.
     *
     * @param endDate Date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Get Car that policy applies to.
     *
     * @return Car
     */
    public Car getCar() {
        return car;
    }
}
