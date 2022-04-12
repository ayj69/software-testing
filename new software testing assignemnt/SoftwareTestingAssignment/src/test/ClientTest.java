
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ClientTest {
	Client client = new Client("Adam", "1234", "016-789065", 69.42);
	@Test
	@Parameters(method = "testCheckStringRegexParamValid")
	public void testCheckStringRegex(String data, String regex, boolean expectedResult) {
		boolean result = client.checkStringRegex(data, regex);
		
		assertEquals(expectedResult, result);
	}
	
	private Object[] testCheckStringRegexParamValid() {
		return new Object[] {
			//userName
			new Object[] {"Ali", client.userNameRegex, true},	
			new Object[] {"ali123", client.userNameRegex, true},	
			new Object[] {"Ali*()%^&", client.userNameRegex, false},
			new Object[] {"123%^&", client.userNameRegex, false},
			new Object[] {"&^%$@!", client.userNameRegex, false},
			new Object[] {"Ali123!@#~", client.userNameRegex, false},
			//phone
			new Object[] {"01112345617", client.phoneNumRegex, true},
			new Object[] {"011-12345678", client.phoneNumRegex, false},
			new Object[] {"*&^%12345", client.phoneNumRegex, false},
			new Object[] {"*&^%---&^", client.phoneNumRegex, false},
			new Object[] {"aasadasd", client.phoneNumRegex, false},
			new Object[] {"01abdhsj", client.phoneNumRegex, false},
			new Object[] {"asdad012", client.phoneNumRegex, false},
			new Object[] {"aas956$%^", client.phoneNumRegex, false},
			//distance
			new Object[] {"12.56", client.distanceRegex, true},
			new Object[] {"1000", client.distanceRegex, true},
			new Object[] {"-1", client.distanceRegex, false},
			new Object[] {"12.5a", client.distanceRegex, false},
			new Object[] {"12.56*a", client.distanceRegex, false},
			new Object[] {"asasd", client.distanceRegex, false},
			new Object[] {"abc^&*123", client.distanceRegex, false},
		};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "testCheckStringRegexInvalidParam")
	public void testCheckStringRegexInvalid(String data, String regex) {
		 client.checkStringRegex(data, regex);
	}
	
	private Object[] testCheckStringRegexInvalidParam() {
		return new Object[] {
			new Object[] {"Ali", null},
			new Object[] {null, client.userNameRegex},
			new Object[] {null, client.phoneNumRegex},
			new Object[] {null, client.distanceRegex},
			new Object[] {null, null},
		};
	}
	
	@Test
	public void testCheckDistance() {
		assertTrue(client.checkDistance(50.0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "testCheckDistanceParam")
	public void testCheckDistanceInvalid(double distance) {
		client.checkDistance(distance);
	}
	
	private Object[] testCheckDistanceParam() {
		return new Object[] {
			new Object[] {-1.0},
			new Object[] {101.0},
			new Object[] {null}	
		};
	}

}
