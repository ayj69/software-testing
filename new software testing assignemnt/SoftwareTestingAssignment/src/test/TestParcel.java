import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)

public class TestParcel {
@Test
@Parameters(method="testParcelValidCalChargeParam")
public void testParcelCalChargeValid( double weightVal,double distanceVal,double expected) {
	Parcel P = new Parcel("", weightVal);
	assertEquals(expected, P.calCharge(weightVal, distanceVal),0);
}

private Object[] testParcelValidCalChargeParam() {
	return new Object[] {
		new Object[] {999,9,5},
		new Object[] {999,10,8},
		new Object[] {999,31,10},
		
		new Object[] {1001,9,15},
		new Object[] {1001,10,18},
		new Object[] {1001,31,25},
		
		new Object[] {2001,9,23},
		new Object[] {2001,10,28},
		new Object[] {2001,31,35},
		
		new Object[] {3001,9,35},
		new Object[] {3001,10,40},
		new Object[] {3001,31,50},
		
		new Object[] {5001,9,45},
		new Object[] {5001,10,50},
		new Object[] {5001,31,60},
	};
}

@Test(expected=IllegalArgumentException.class)
@Parameters(method="testParcelInvalidCalChargeParam")
public void testParcelCalChargeInvalid(double weightVal,double distanceVal) {
	Parcel P = new Parcel("", weightVal);
	P.calCharge(weightVal, distanceVal);
} 

private Object[] testParcelInvalidCalChargeParam() {
	return new Object[] {
		new Object[] {null, null},
		new Object[] {-10, null},
		new Object[] {null, -10},
		new Object[] {-10, -10},
	};
}
}