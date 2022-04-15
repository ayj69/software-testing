import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestItem {
@Test
public void testToString() {
	Item P = new Parcel("A",20.9);
	Item D = new Document("B",30.7);
	assertEquals("Name :  A                Weight :  20.90        Status :  AVALIBLE  ", P.toString());
	assertEquals("Name :  B                Weight :  30.70        Status :  AVALIBLE  ", D.toString());
	}

@Test(expected=IllegalArgumentException.class)
public void testToStringInvalid() {
	Item P = new Parcel("A",-20);
	Item D = new Document("B",-30);
	assertEquals("Name :  A                Weight :  20.90        Status :  AVALIBLE  ", P.toString());
	assertEquals("Name :  B                Weight :  30.70        Status :  AVALIBLE  ", D.toString());
	}
}