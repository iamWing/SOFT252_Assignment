import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * "Master" JUnit test. Executes other tests.
 *
 * @author NotMike
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    other.UtilsIT.class,
    commands.AddEditRemoveStaffIT.class,
    commands.AddRemoveAllocationRecordIT.class,
    commands.AddRemoveVehicleIT.class,
    data.DatastoreIT.class,
    models.AllocationRecordIT.class,
    models.CarIT.class,
    models.DamageRecordIT.class,
    models.InsuranceIT.class,
    models.ServiceIT.class,
    models.StaffIT.class,
})
public class JUnitTests {
    
}
