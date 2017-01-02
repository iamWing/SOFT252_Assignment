package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import other.Utils;

/**
 * A class to represent a Car.
 *
 * @author Wing
 */
public class Car implements Serializable {

    private final String CARID;
    private String brand;
    private String model;
    private int seats;
    private String description;

    private CarParks location;
    private Insurance insurance;

    private ArrayList<AllocationRecord> allocationHistory;
    private ArrayList<Service> serviceHistory;
    private ArrayList<DamageRecord> damageHistory;

    private boolean damaged = false;


   
    
    /**
     * Constructor, creates new Car object.
     *
     * @param _CARID String
     */
    public Car(String _CARID) {
        CARID = _CARID;
    }

    /**
     * Constructor, creates new Car object.
     *
     * @param _CARID String
     * @param _brand String Vehicle brand.
     * @param _model String Vehicle model.
     * @param _seats int Number of seats.
     * @param _loc CarParks Location of vehicle.
     * @param _description String Description of vehicle.
     */
    public Car(String _CARID, String _brand, String _model, int _seats, 
            CarParks _loc, String _description) {

        CARID = _CARID;
        brand = _brand;
        model = _model;
        seats = _seats;
        location = _loc;
        description = _description;
        
        allocationHistory = new ArrayList<AllocationRecord>();
        serviceHistory = new ArrayList<Service>();
        damageHistory = new ArrayList<DamageRecord>();
        
    }

    // --- Getters & Setters --- //

    
    public boolean isAvailable(Date when) {
        return !this.isInService(when) && !this.isAllocated(when) && !this.isDamaged();
    }

    public boolean isInService(Date when) {
        if (serviceHistory != null)
        {
            for(Service serv : serviceHistory)
            {
                if(Utils.CompareDates(serv.getInDate(), when) <= 0 && Utils.CompareDates(serv.getOutDate(), when) >= 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Check if vehicle is allocated to someone.
     *
     * @return boolean
     */
    public boolean isAllocated(Date when) {
        if(allocationHistory != null)
        {
            for(AllocationRecord rec : allocationHistory)
            {
                if(rec.getLongTermAllocation() && rec.getEndDate() != null)
                {
                    if(Utils.CompareDates(rec.getStarDate(), when) <= 0 && Utils.CompareDates(rec.getEndDate(), when) >= 0)
                    {
                        return true;
                    }
                }
                else if(Utils.CompareDates(rec.getStarDate(), when) == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the vehicle damage status.
     *
     * @return boolean
     */
    public boolean isDamaged() {
        return damaged;
    }

    /**
     * Set vehicle damage status.
     *
     * @param damaged boolean
     */
    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    /**
     * Get car ID.
     *
     * @return String CarID
     */
    public String getCARID() {    
        return CARID;
    }

    /**
     * Get car brand.
     *
     * @return String Brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set car brand.
     *
     * @param brand String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get car model.
     *
     * @return String Model
     */
    public String getModel() {
        return model;
    }

    /**
     * Format car as a String.
     * String format is CarID Brand Model.
     *
     * @return String
     */
    public String toString() {
        return this.getCARID() + " - " + this.getBrand() + " " + this.getModel() + "- dmged " +isDamaged() + "- serv " + isInService(new Date()) + " " + "- alloc " + isAllocated(new Date()) + "- avail "+ isAvailable(new Date());
    }
 
    /**
     * Set the Manufacturer Model.
     *
     * @param model String
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Get number of seats.
     *
     * @return int Seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Set number of seats.
     *
     * @param seats int
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * Get car description.
     *
     * @return String Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set car description.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get car location.
     *
     * @return CarParks CarPark
     */
    public CarParks getLocation() {
        return location;
    }

    /**
     * Set car location.
     *
     * @param location CarParks
     */
    public void setLocation(CarParks location) {
        this.location = location;
    }

    /**
     * Get car Insurance.
     *
     * @return Insurance
     */
    public Insurance getInsurance() {
        return insurance;
    }

    /**
     * Set vehicle insurance.
     *
     * @param insurance Insurance
     */
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    /**
     * Check if vehicle is enabled.
     *
     * @return boolean
     */

    // --- Allocation history management --- //

    /**
     * For use by AllocationRecord Object.
     *
     * @param _record AllocationRecord
     */
    public void addAllocationRecord(AllocationRecord _record) {
        if (allocationHistory == null) {
            allocationHistory = new ArrayList<>();
        }
        allocationHistory.add(_record);
    }

    /**
     * For use by AllocationRecord Object.
     *
     * @throws NullPointerException No allocation history to delete.
     */
    public void removeLastAllocationRecord() throws NullPointerException {
        allocationHistory.remove(allocationHistory.size() - 1);
    }
    
    public void removeAllocationRecord(AllocationRecord rec)
    {
        allocationHistory.remove(rec);
    }
    /**
     * Returns list of allocation records for this vehicle.
     *
     * @return ArrayList&lt;AllocationRecord&gt;
     * @throws NullPointerException No allocation records exist.
     */
    public ArrayList<AllocationRecord> getAllocationRecords() throws
            NullPointerException {
        if (allocationHistory == null)
            throw new NullPointerException();
        return allocationHistory;
    }

    // --- Damage history management --- //

    /**
     * Add a Damage Record to the vehicle.
     *
     * @param _record DamageRecord
     */
    public void addDamageRecord(DamageRecord _record) {
        if (damageHistory == null) {
            damageHistory = new ArrayList<>();
        }
        damageHistory.add(_record);
    }

    /**
     * Remove last Damage Record.
     *
     * @throws NullPointerException No damage records exist.
     */
    public void removeLastDamageRecord() throws NullPointerException {
        damageHistory.remove(damageHistory.size() - 1);
    }
    public void removeDamageRecord(DamageRecord record)
    {
        damageHistory.remove(record);
    }

    /**
     * Remove a Damage Record from the vehicle.
     *
     * @return ArrayList&lt;DamageRecord&gt;
     * @throws NullPointerException No damage records exist.
     */
    public ArrayList<DamageRecord> getDamageRecords() throws
            NullPointerException {
        if (damageHistory == null)
            throw new NullPointerException();
        return damageHistory;
    }
    public void addServiceRecord(Service _service)
    {
        if(serviceHistory == null)
            serviceHistory = new ArrayList<>();
        serviceHistory.add(_service);
    }
    public void removeServiceRecord(Service _service)
    {
        serviceHistory.remove(_service);
    }
    public ArrayList<Service> getServiceRecords()
    {
        return serviceHistory;
    }
}
