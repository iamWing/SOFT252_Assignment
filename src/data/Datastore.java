package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import commands.Command;
import commands.CommandTracker;
import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddInsurance;
import exceptions.DatastoreNotLoadedException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import models.Car;
import models.CarParks;
import models.Insurance;
import models.Staff;

/**
 *
 * @author Fairymental
 */
public class Datastore implements Serializable {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private ArrayList<Staff> staff = new ArrayList<Staff>();
    private transient static Datastore store;
    private transient static String datastoreLocation;
    
    private static CommandTracker cmdTracker = new CommandTracker();
    
    /**
     * Dummy constructor. Do not use.
     * Use GetDatastore() to obtain the Datastore object.
     */
    public Datastore()
    {
    }
    /**
     * Add Car to Datastore.
     * 
     * @param car Car to add.
     * @return success
     * @throws DatastoreNotLoadedException if datastore not loaded.
     */
    public static boolean AddCar(Car car) throws DatastoreNotLoadedException
    {
        if (Datastore.store == null)
            throw new DatastoreNotLoadedException();
        return Datastore.store.cars.add(car);
    }
    /**
     * Get cars in specified location.
     * @param location CarParks
     * @return ArrayList of Cars.
     */
    public static ArrayList<Car> GetCars(CarParks location)
    {
        /* Eat NullPointerException so NetBeans Designer can load. */
        if (Datastore.store == null)
            return new ArrayList<Car>();

        ArrayList<Car> foundCars = new ArrayList<Car>();
        for (Car car : Datastore.store.cars)
        {
            if (car.getLocation() == location)
                foundCars.add(car);
        }
        return foundCars;
    }
    /**
     * Get all cars.
     * @return ArrayList of Cars.
     */
    public static ArrayList<Car> GetCars()
    {
        /* Eat NullPointerException so NetBeans Designer can load. */
        if (Datastore.store == null)
            return new ArrayList<Car>();

        ArrayList<Car> foundCars = new ArrayList<Car>();
        for (Car car : Datastore.store.cars)
        {

                foundCars.add(car);
        }
        return foundCars;
    }
    /**
     * Get specific Car.
     * 
     * @param index Position of Car to select.
     * @return Car
     * @throws DatastoreNotLoadedException if datastore not loaded.
     */
    public static Car GetCarAtIndex(int index) throws DatastoreNotLoadedException
    {
        if (Datastore.store == null)
            throw new DatastoreNotLoadedException();
        return Datastore.store.cars.get(index);
    }
    /**
     * Remove Car from Datastore
     * @param car Car to remove.
     * @return success
     * @throws DatastoreNotLoadedException if datastore not loaded.
     */
    public static boolean RemoveCar(Car car) throws DatastoreNotLoadedException
    {
        if (Datastore.store == null)
            throw new DatastoreNotLoadedException();
        return Datastore.store.cars.remove(car);
    }
    /**
     * Add Staff to datastore.
     * 
     * @param staff Staff to add.
     * @return success
     * @throws DatastoreNotLoadedException if datastore not loaded.
     */
    public static boolean AddStaff(Staff staff) throws DatastoreNotLoadedException
    {
        if (Datastore.store == null)
            throw new DatastoreNotLoadedException();
        return Datastore.store.staff.add(staff);
    }
    /**
     * Get specified Staff object.
     * @param staffID String ID of Staff object to fetch.
     * @return Staff or null
     */
    public static Staff GetStaff(String staffID)
    {
        for(Staff currStaff : Datastore.store.staff)
        {
            if(currStaff.getSTAFFID().equalsIgnoreCase(staffID))
            {
                return currStaff;
            }
        }
        return null;
    }
    /**
     * Get list of Staff.
     * 
     * @return ArrayList of Staff.
     */
    public static ArrayList<Staff> GetStaff()
    {
        /* Eat NullPointerException so NetBeans Designer can load. */
        if (Datastore.store == null)
            return new ArrayList<Staff>();

        ArrayList<Staff> foundStaff = new ArrayList<Staff>();
        for (Staff staff : Datastore.store.staff)
        {
            foundStaff.add(staff);
        }
        return foundStaff;
    }
    /**
     * Remove Staff from Datastore.
     * 
     * @param staff Staff
     * @return success
     * @throws DatastoreNotLoadedException if datastore not loaded.
     */
    public static boolean RemoveStaff(Staff staff) throws DatastoreNotLoadedException
    {
        if (Datastore.store == null)
            throw new DatastoreNotLoadedException();
        return Datastore.store.staff.remove(staff);
    }
    /**
     * Gets the datastore. Loads the default datastore if not loaded.
     * 
     * @return Datastore
     */
    public static Datastore GetDatastore()
    {
        if (Datastore.store != null)
            return Datastore.store;
        else
            return LoadDatastore("./default.dat");
    }
    /**
     * Loads a specified datastore.
     * 
     * @param location Path to datastore. Default value is "./default.dat".
     * @return Datastore
     */
    public static Datastore LoadDatastore(String location)
    {
        try
        {
            InputStream in = Files.newInputStream(Paths.get(location));
            ObjectInputStream objectReader = new ObjectInputStream(in);
            Datastore.store = (Datastore) objectReader.readObject();
            Datastore.datastoreLocation = location;
        }
        catch (Exception Ex)
        {
            Datastore.store = new Datastore();
            Datastore.datastoreLocation = location;
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            int result = JOptionPane.showConfirmDialog(null, "No data found. Load sample data?", "Datastore", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.CANCEL_OPTION)
            {
                System.exit(0);
            }
            if (result == JOptionPane.YES_OPTION)
            {
                int x;
                for (x=0; x<10; x++)
                {
                    Car car = new Car("CAR0" + x, "Sample Car", "Model " + x, 4, CarParks.CarPark01, "Sample Car");
                    AddInsuranceToCar(car,"Company0"+x,"Number0"+x,new Date(), new Date());
                    Datastore.store.AddCar(car);
                }
                for (x=0; x<10; x++)
                {
                    Car car = new Car("CAR1" + x, "Sample Car", "Model " + x, 4, CarParks.CarPark02, "Sample Car");
                    AddInsuranceToCar(car,"Company1"+x,"Number1"+x,new Date(), new Date());
                    Datastore.store.AddCar(car);
                }
                for (x=0; x<10; x++)
                {
                    Car car = new Car("CAR2" + x, "Sample Car", "Model " + x, 4, CarParks.CarPark03, "Sample Car");
                    AddInsuranceToCar(car,"Company2"+x,"Number2"+x,new Date(), new Date());
                    Datastore.store.AddCar(car);
                }
                for (x=0; x<10; x++)
                {
                    Car car = new Car("CAR3" + x, "Sample Car", "Model " + x, 4, CarParks.CarPark03, "Sample Car");
                    AddInsuranceToCar(car,"Company3"+x,"Number3"+x,new Date(), new Date());
                    Datastore.store.AddCar(car);
                }

                for (x=0; x<10; x++)
                {
                    Staff staff = new Staff("EMP" + x, "Employee", "Number " + x, "Sample Data", "XXXXXXXXXX", "Sample");
                    Datastore.store.AddStaff(staff);
                }
            }
        }
        return Datastore.store;
    }
    /**
     * Add Insurance to Car object.
     * @param car Car.
     * @param insuranceCompany String
     * @param insuranceNumber String
     * @param startDate Date
     * @param endDate Date
     */
    private static void AddInsuranceToCar(Car car, String insuranceCompany, String insuranceNumber, Date startDate, Date endDate)
    {
        ICommandBehavior cmdBehavior = new AddInsurance(car,insuranceCompany,insuranceNumber,startDate,endDate);
        Command cmd = new Command(cmdBehavior);
        
        try
        {
            cmdTracker.executeCommand(cmd);
        }catch(Exception ex)
        {
            System.err.print(ex.getMessage());
        }
    }
    /**
     * Save the datastore.
     */
    public static void Save()
    {
        try
        {
            OutputStream out = Files.newOutputStream(Paths.get(Datastore.datastoreLocation));
            ObjectOutputStream objectWriter = new ObjectOutputStream(out);
            objectWriter.writeObject(Datastore.store);
        }
        catch (Exception x)
        {
            JOptionPane.showMessageDialog(null, "Error saving database.");
            x.printStackTrace();
        }
    }
}
