import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { ClientTest.class, 
						TestDeliveryItemList.class, 
						TestDocument.class, 
						TestEmail.class,
						TestItem.class,
						TestParcel.class, 
						testUserList.class })


public class TestSuite {
}
