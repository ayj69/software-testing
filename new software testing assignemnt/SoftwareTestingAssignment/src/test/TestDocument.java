import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)

public class TestDocument {
@Test
@Parameters(method="testDocumentValidCalChargeParam")
public void testDocumentCalChargeValid( double weightVal,double distanceVal,double expected) {
	Document D = new Document("", weightVal);
	assertEquals(expected, D.calCharge(weightVal, distanceVal),0);
}

private Object[] testDocumentValidCalChargeParam() {
	return new Object[] {
		new Object[] {299,10,3},
		new Object[] {300,9,4},
		new Object[] {300,10,5},
		new Object[] {300,31,6},
		
		new Object[] {1001,9,6},
		new Object[] {1001,10,8},
		new Object[] {1001,31,10},
		
		new Object[] {3001,9,12},
		new Object[] {3001,10,18},
		new Object[] {3001,31,25},
		
		new Object[] {5001,9,25},
		new Object[] {5001,10,30},
		new Object[] {5001,31,35},
	};
}

@Test(expected=IllegalArgumentException.class)
@Parameters(method="testDocumentInvalidCalChargeParam")
public void testDocumentCalChargeInvalid(double weightVal,double distanceVal) {
	Parcel P = new Parcel("", weightVal);
	P.calCharge(weightVal, distanceVal);
} 

private Object[] testDocumentInvalidCalChargeParam() {
	return new Object[] {
		new Object[] {null, null},
		new Object[] {-10, null},
		new Object[] {null, -10},
		new Object[] {-10, -10},
	};
}
}