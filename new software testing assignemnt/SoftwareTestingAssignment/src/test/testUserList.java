
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class testUserList {
	LinkedList<User> linkedListUser = new LinkedList<User>();
	@Test
	public void testCheckUSerExistValid() {
		UserList userList = new UserList();
		User userAli = new User("Ali", "011-15679800", "12345");
		
		linkedListUser.add(userAli);
		
		assertTrue(userList.checkUSerExist(linkedListUser, "Ali"));
		assertFalse(userList.checkUSerExist(linkedListUser, "Willy"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "testCheckUSerExistInvalidParam")
	public void testCheckUSerExistInvalid(LinkedList<User> list, String username) {
		UserList userList = new UserList();
		userList.checkUSerExist(list, username);
	}
	
	private Object[] testCheckUSerExistInvalidParam() {
		return new Object[] {
			new Object[] {null, "Ali"},	
			new Object[] {linkedListUser, null},
			new Object[] {null, null}
		};
	}
	
	@Test
	public void testValifyLoginValid() {
		UserList userList = new UserList();
		User userAli = new User("Ali", "011-15679800", "12345");
		linkedListUser.add(userAli);
		
		assertTrue(userList.valifyLogin(linkedListUser, "Ali", "12345"));
		assertFalse(userList.valifyLogin(linkedListUser, "Ali", "12341"));
		assertFalse(userList.valifyLogin(linkedListUser, "Abu", "12345"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "testValifyLoginInvalidParam")
	public void testValifyLoginInvalid(LinkedList<User> list, String username, String password) {
		UserList userList = new UserList();
		userList.valifyLogin(list, username, password);
		
	}
	
	private Object[] testValifyLoginInvalidParam() {
		return new Object[] {
			new Object[] {null, null, null},
			new Object[] {linkedListUser, null, null},
			new Object[] {null, "Ali", null},
			new Object[] {null, null, "12345"},
			new Object[] {linkedListUser, "Ali", null},
			new Object[] {null, "Ali", "12345"},
			new Object[] {linkedListUser, null, "12345"}
		};
	}
	
	LinkedList<Client> linkedListClient = new LinkedList<Client>();
	@Test
	public void testGetClientValid() {
		Client client = new Client("Chong", "12345", "019-9871423", 43.45);
		linkedListClient.add(client);
		
		UserList userList = new UserList();
		Client resultClient = userList.getClient(linkedListClient, "Chong");
		assertEquals(client, resultClient);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "testGetClientInvalidParam")
	public void testGetClientInvalid(LinkedList<Client> linkedListClient, String username) {
		UserList userList = new UserList();
		userList.getClient(linkedListClient, username);
	}
	
	private Object[] testGetClientInvalidParam() {
		return new Object[] {
			new Object[] {linkedListClient, null},
			new Object[] {null, "Chong"},
			new Object[] {null, null},
		};
	}
	
	public void testGetRandomStaff() {
		UserList userList = mock(UserList.class);
		DeliveryStaff deliveryStaff = new DeliveryStaff("Norman", "13579", "011-76554321");
		
		when(userList.getRandomStaff()).thenReturn(deliveryStaff);
		
		
	}
}
