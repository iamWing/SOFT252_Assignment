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
    data.DatastoreIT.class,
})
public class JUnitTests {
    
}
