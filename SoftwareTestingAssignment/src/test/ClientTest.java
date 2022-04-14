
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
			new Object[] {"Ali.-_123", client.userNameRegex, true},
			new Object[] {"al", client.userNameRegex, false},
			new Object[] {"&^%$@!", client.userNameRegex, false},
			//phone
			new Object[] {"0111234567", client.phoneNumRegex, true},
			new Object[] {"01112345678", client.phoneNumRegex, true},
			new Object[] {"011123456789", client.phoneNumRegex, false},
			new Object[] {"12345667982", client.phoneNumRegex, false},
			new Object[] {"012-12345567", client.phoneNumRegex, false},
			new Object[] {"aA*&^%-&123", client.phoneNumRegex, false},
			//distance
			new Object[] {"0.00", client.distanceRegex, true},
			new Object[] {"1000", client.distanceRegex, true},
			new Object[] {"-1", client.distanceRegex, false},
			new Object[] {"-1.0", client.distanceRegex, false},
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
			new Object[] {"0111234561", null},
			new Object[] {"0.5", null},
			new Object[] {null, client.userNameRegex},
			new Object[] {null, client.phoneNumRegex},
			new Object[] {null, client.distanceRegex},
			new Object[] {null, null},
		};
	}
}
