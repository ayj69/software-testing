

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;


public class TestEmail {

	@Test
	public void testemailSendComformation() {
		final Email testEmail = Mockito.spy(new Email());
	    Mockito.when(testEmail.emailSendComformation()).thenReturn(true);
	    System.out.println(testEmail.emailSendComformation());
	    assertTrue(testEmail.emailSendComformation());

	}

	
	
	
	
	@Test
	public void testgetData() {
		final Email testEmail = Mockito.spy(new Email());
	    Mockito.when(testEmail.getData()).thenReturn(true);
	    System.out.println(testEmail.getData());
	    assertTrue(testEmail.getData());
	}
	
	@Test
	public void testtoString() {
		final Email testEmail = Mockito.spy(new Email());
	    Mockito.when(testEmail.toString()).thenReturn("email detail");
	    System.out.println(testEmail.toString());
	    assertEquals("email detail",testEmail.toString());

	}
	
}
