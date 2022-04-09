import java.util.*;

public class UserList {

	private LinkedList<Client> clientList = new LinkedList<Client>();
	private LinkedList<DeliveryStaff> deliveryStaffList = new LinkedList<DeliveryStaff>();

	// create a text file with exiting user
	// i want to die
	// your time management skill is shit bruh

	public boolean valifyLogin(String username, String password) {
		return valifyLogin(clientList, username, password);
	}

	public boolean checkUSerExist(String username) {
		return checkUSerExist(clientList, username);

	}

	public boolean checkUSerExist(LinkedList<? extends User> list, String username) {
		boolean flag = false;

		for (User u : list) {
			if (username.equals(u.getUsername())) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}

		if (flag == false)
			System.out.println("user not found");

		return flag;

	}

	public boolean valifyLogin(LinkedList<? extends User> list, String username, String password) {

		boolean flag = false;
		boolean found = false;

		for (User u : list) {
			if (username.equals(u.getUsername())) {
				if (password.equals(u.getPassword())) {
					flag = true;
					break;
				} else {
					System.out.println("incorret pass");
					flag = false;
					break;
				}
			}
		}

		for (User u : list) {
			if (username.equals(u.getUsername())) {
				found = true;
			}
		}

		if (!found) {
			System.out.println("account not found");
		}

		if (flag == true)
			System.out.println("login successful");

		return flag;
	}

	public DeliveryStaff getRandomStaff() {

		int randomNumber = (int) Math.floor(Math.random() * this.deliveryStaffList.size());

		return this.deliveryStaffList.get(randomNumber);

	}

	public LinkedList<DeliveryStaff> getDeliveryStaffList() {
		return deliveryStaffList;
	}

	public Client getClient(LinkedList<Client> list, String username) {
		boolean found = false;
		Client cil = null;
		Optional<Client> checkNull = Optional.ofNullable(cil);
		for (Client u : list) {
			if (username.equals(u.getUsername())) {
				cil = u;
				found = true;
				break;
			}

			if (checkNull.isPresent()) {
				System.out.println("account found");
			} else {
				return cil;
			}

		}

		return cil;

	}

	public Client getClient(String username) {
		return getClient(this.clientList, username);
	}

	public LinkedList<Client> getClientList() {
		return clientList;
	}

}
