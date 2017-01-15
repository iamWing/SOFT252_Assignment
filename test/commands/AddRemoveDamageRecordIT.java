package commands;

import commands.interfaces.ICommandBehavior;
import commands.vehicleManagement.AddDamageRecord;
import commands.vehicleManagement.RemoveDamageRecord;
import java.util.Date;
import models.Car;
import models.CarParks;
import models.DamageRecord;
import models.Staff;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for AddDamageRecord and RemoveDamageRecord commands
 * @author Wing
 */
public class AddRemoveDamageRecordIT {
    
    private String vehicleId = "CAR001";
    private String brand = "Honda";
    private String model = "GT86";
    private int seats = 4;
    private CarParks loc = CarParks.CarPark01;
    private String desc = "Test for vehicle related commands";

    private Car vehicle = new Car(vehicleId, brand, model, seats, loc, desc);

    private String staffId = "Staff001";
    private String fName = "Wing";
    private String lName = "Chau";
    private String addr = "Somewhere in Plymouth";
    private String licenseNum = "LN001";
    private String licenseType = "Manual";

    private Staff staff = new Staff(staffId, fName, lName, addr, licenseNum,
            licenseType);

    private Date damageDate = new Date();
    private String recordDesc = "Testing add damage record command";

    private ICommandBehavior addDamageRecordBehavior = 
            new AddDamageRecord(vehicle, damageDate, staff, recordDesc);
    private Command addDamageRecord = new Command(addDamageRecordBehavior);

    @Before
    public void setUp() {
        System.out.println("Testing AddDamageRecord command");
    }

    /**
     * JUnit test for AddDamageRecord and RemoveDamageRecord commands.
     * 
     * @throws Exception 
     */
    @Test
    public void executeAndUndo() throws Exception {
        boolean result;

        // execute
        result = addDamageRecord.executeCommand();
        assertTrue(result);
        if (result) {
            DamageRecord record = vehicle.getDamageRecords().get(0);
            assertEquals(damageDate, record.getDamageDate());
            assertEquals(staff, record.getDamagedBy());
            assertEquals(recordDesc, record.getDescription());
        }

        // undo
        result = addDamageRecord.undoCommand();
        assertTrue(result);
        if (result) {
            boolean searched = false;
            for (DamageRecord rec : vehicle.getDamageRecords()) {
                if ((rec.getDamageDate() == damageDate) && 
                        (rec.getDamagedBy() == staff) && 
                        (rec.getDescription().equals(recordDesc)))
                    searched = true;
            }
            assertFalse(searched);
        }
        
        // re-add ready for removal.
        result = addDamageRecord.executeCommand();
        assertTrue(result);
        
        Command removeCommand = new Command(new RemoveDamageRecord(vehicle, vehicle.getDamageRecords().get(0)));
        assertEquals(1, vehicle.getDamageRecords().size());
        removeCommand.executeCommand();
        assertEquals(0, vehicle.getDamageRecords().size());
        removeCommand.undoCommand();
        assertEquals(1, vehicle.getDamageRecords().size());
    }
}
