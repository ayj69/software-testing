import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.mockito.InOrder;
import org.mockito.internal.util.io.IOUtil;


import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyList;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.inOrder;

@RunWith(JUnitParamsRunner.class)
public class IntergrationTest {
	
	ItemList il;
	DeliveryItemList dil;
	
	@Before
	public void setupForAllTests() {
		il = new ItemList();
		dil = new DeliveryItemList();
	}	
	
	Document doc1 = new Document("doc1",11);
	Document doc2 = new Document("doc2",12);
	Parcel par3 = new Parcel("par3",13);

	private Object[] getParamsForTestDisplayItem() {
		return new Object[] {
				
				new Object[] {"Name :  " + String.format("%-15s", "doc1") + "  " + "Weight :  " + String.format("%-10.2f", 11.0) + " "
						+ "  Status :  " + String.format("%-10s", "AVALIBLE"),doc1}, 
				new Object[] {"Name :  " + String.format("%-15s", "doc2") + "  " + "Weight :  " + String.format("%-10.2f", 12.0) + " "
						+ "  Status :  " + String.format("%-10s", "AVALIBLE"),doc2}, 
				new Object[] {"Name :  " + String.format("%-15s", "par3") + "  " + "Weight :  " + String.format("%-10.2f", 13.0) + " "
						+ "  Status :  " + String.format("%-10s", "AVALIBLE"),par3}
		};
	}
	
	@Test
	@Parameters(method = "getParamsForTestDisplayItem")
	public void testItemToString(String expectedResult, Item  item) {
		
		assertEquals(expectedResult,item.toString());
		
		// set both the student records and selected records to inputList
		// so that if the sort operation does not return a proper result
		// selected records still has a default value (inputList) to be
		// compared to
	}	
	

	

	
	
	
	
	
	

}
