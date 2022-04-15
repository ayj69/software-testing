import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;



import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
@RunWith(JUnitParamsRunner.class)

public class TestParcel {

static Scanner inputStream;
static ArrayList<String[]> linesRead;

@Before
public void setupData() {
	linesRead = new ArrayList<String[]>();
	String fileName = "Data/ParTestData.txt";
	try {
		inputStream = new Scanner(new File(fileName));
	} catch (FileNotFoundException e) {
		System.out.println("Error opening the file " + fileName);
		System.exit(0);
	}
	while (inputStream.hasNextLine()) {
		String singleLine = inputStream.nextLine();
		String[] tokens = singleLine.split(",");
		linesRead.add(tokens);
	}
}
@After
public void closeFile() {
	inputStream.close();
}

@Test
public void testParcelCalChargeValid() {
	for(int i=0;i<linesRead.size();i++) {
	String[] inputStr = linesRead.get(i);
	double weightVal=Double.valueOf(inputStr[0]);
	double distanceVal=Double.valueOf(inputStr[1]);
	double expected=Double.valueOf(inputStr[2]);
	Parcel P = new Parcel("", weightVal);
	assertEquals(expected, P.calCharge(weightVal, distanceVal),0);
}
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