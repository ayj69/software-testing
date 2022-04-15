import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.plaf.TreeUI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.PublicClassValidator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TestDeliveryItemList {

	@Test
	@Parameters(method = "TestGetynValidParam")
	public void TestGetynValid(String choice, boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean choiceResult=dil.getyn(choice);
		assertEquals(expectedResult, choiceResult);
	}

	private Object[] TestGetynValidParam() {
		return new Object[] { 
				new Object[] { "Y", true}, 
				new Object[] { "y", true }, 
				new Object[] { "N", false }, 
				new Object[] { "n", false },
				};
	}
	

	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "TestGetynInvalidParam")
	public void TestGetynInvalid(String choice, boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean choiceResult=dil.getyn(choice);
		assertEquals(expectedResult, choiceResult);
	}

	private Object[] TestGetynInvalidParam() {
		return new Object[] { 
				new Object[] { "", false}, 
				new Object[] { "1", false }, 
				new Object[] { "q", false }, 
				new Object[] { "Q", false },
				};
	}

	@Test
	@Parameters(method = "TestIsNumericValidParam")
	public void TestIsNumericValid(String string, boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean choiceResult=dil.isNumeric(string);
		assertEquals(expectedResult, choiceResult);
	}

	private Object[] TestIsNumericValidParam() {
		return new Object[] { 
				new Object[] { "1", true}, 
				new Object[] { "12", true }, 
				new Object[] { "123", true }, 
				new Object[] { "1234", true }, 
				};
	}

	@Test
	@Parameters(method = "TestIsNumericInvalidParam")
	public void TestIsNumericInvalid(String string, boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean choiceResult=dil.isNumeric(string);
		assertEquals(expectedResult, choiceResult);
	}

	private Object[] TestIsNumericInvalidParam() {
		return new Object[] { 
				new Object[] { "a", false}, 
				new Object[] { "aA", false }, 
				new Object[] { "A", false }, 
				new Object[] { "AA", false }, 
				};
	}

	@Test
	@Parameters(method="TestValidateMonthDayValidParam")
	public void TestValidateMonthDayValid(int year,int month,int days,boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean YearMonthDay=dil.validateMonthDay(year, month, days);
		assertEquals(expectedResult, YearMonthDay);
	}
	
	private Object[]TestValidateMonthDayValidParam(){
		return new Object[] {
				new Object[] {2022,5,12,true},
				new Object[] {2022,7,12,true},
				new Object[] {2022,4,20,true},
				new Object[] {2022,6,12,true},
				new Object[] {2022,2,28,false},
				new Object[] {2024,2,29,false},
		};
	}
	
	@Test(expected = DateTimeException.class)
	@Parameters(method="TestValidateMonthDayInvalidParam")
	public void TestValidateMonthDayInvalid(int year,int month,int days,boolean expectedResult) {
		DeliveryItemList dil = new DeliveryItemList();
		boolean YearMonthDay=dil.validateMonthDay(year, month, days);
		assertEquals(expectedResult, YearMonthDay);
	}
	
	private Object[]TestValidateMonthDayInvalidParam(){
		return new Object[] {
				new Object[] {2022,5,32,false},
				new Object[] {2022,7,-1,false},
				new Object[] {2022,4,31,false},
				new Object[] {2022,6,-1,false},
				new Object[] {2022,2,29,false},
				new Object[] {2024,2,30,false},
		};
	}
	
}