import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.*;

public class Driver {

	public static void main(String[] args) {

		boolean loop = false;

		Scanner scan = new Scanner(System.in);
		
		
		ItemList itemlist = new ItemList();
		UserList userlist = new UserList();

		// load the data file
		ArrayList<Item> tempItemList = readItemFile();
		ArrayList<Client> tempClientList = readClientFile();
		ArrayList<DeliveryStaff> tempStaffList = readStaffFile();

		for (Item i : tempItemList)
			itemlist.getItemList().add(i);

		for (Client c : tempClientList)
			userlist.getClientList().add(c);

		for (DeliveryStaff d : tempStaffList)
			userlist.getDeliveryStaffList().add(d);

		int userflag;// 1 = guest 2 = user
		Client tempClient = new Client("", "", "", 00); // for storing guest data

		// programm start
		System.out.println("\n\nWelcome To Delivery Expert");
		System.out.println("Enter as guess or login ?");
		// if user or worker login else skip this part;
		System.out.println("\t1. Enter as guess");
		System.out.println("\t2. Let me login ");

		// verify the user input for the menu choice
		while (true) {
			try {
				// Some Code
				// break out of loop, or return, on success
				userflag = 0;
				System.out.print("Please enter your choice :  ");
				userflag = scan.nextInt();

				if (userflag == 1 || userflag == 2)
					break;
				else
					System.out.println("ERROR, pls enter the number in range");

			} catch (Exception e) {
				// handle exception
				System.out.println("ERROR, pls enter a number");
			}
			scan.nextLine();
		}

		// if user choose to login
		if (userflag == 2) {
			String username = "";
			String password = "";
			System.out.println("              LOGIN");
			try {
				do {
					System.out.print("Pls enter your username to login  :  ");
					try {
						loop = false;
						username = scan.next();
					}catch(Exception e) {
						System.out.println(e.getLocalizedMessage());
						scan.nextLine();
						loop = true;
					}
				}while(loop);
				
				
				do {
					System.out.print("Pls enter your password to login  :  ");
					try {
						loop = false;
						password = scan.next();
					}catch(Exception e) {
						System.out.println(e.getLocalizedMessage());
						scan.nextLine();
						loop = true;
					}
				}while(loop);
				userlist.valifyLogin(username, password);
				tempClient = userlist.getClient(username);
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				System.out.println("[PROGRAME ENDED]");
				System.exit(0);

			}
			
			
			

			
		}

		// show the list of item to the user
		// the user can choose an item
		DeliveryItemList dil = new DeliveryItemList();
		System.out.println("pls select the item you want to deliver");

		// add the delivery item into the delivery list
		dil.getDevItemList().addAll(dil.getItem(itemlist.getItemList()));

		// if the user did not choose any item end the program
		if (dil.getDevItemList().isEmpty()) {
			System.out.println("The user did not choss any item procedd to exit the program");
			System.out.println("[PROGRAME ENDED]");

			System.exit(0);
		}

		// if guest
		// enter guest detail
		if (userflag == 1) {
			System.out.println("You are a guess please enter your detail so that we can deliver to you");

			
			do {
				System.out.print("Please enter your username :  ");
				try {
					loop = false;
					String username = scan.next();
					tempClient.setUserName(username);
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
					loop = true;
				}
			}while(loop);
			
			
			do {
				System.out.print("Please enter your phone number :  ");
				try {
					loop = false;
					String phoneNum = scan.next();
					tempClient.setPhoneNumber(phoneNum);
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
					loop = true;
				}
			}while(loop);
			


			
			do {
				System.out.print("Please enter your distance :  ");
				try {
					loop = false;
					String distance = scan.next();
					tempClient.setDistance(distance);
				}catch(Exception e) {
					System.out.println(e.getLocalizedMessage());
					scan.nextLine();
					loop = true;
				}
			}while(loop);
			
			
			

			dil.setCli(tempClient);

		} else if (userflag == 2) {
			dil.setCli(tempClient);
		}

		
		// ask for insurance
		boolean result = false;
		do {
			System.out.print("Insurance for delivery? (Y/N) : ");
			try {
				loop = false;
				String choice = scan.next();
				result  = dil.getyn(choice);
			}catch(Exception e) {
				System.out.println(e.getLocalizedMessage());
				scan.nextLine();
				loop = true;
			}
		}while(loop);
		
		
		if (result == true)
			dil.setInsurance(true);

		// ask for date
		System.out.println("Please enter the date that you want the item to be deliver to you :  ");
		dil.getDate();
		//dil.checkSameDate(dil.date);

		// assign the delivery man
		dil.setDevStaff(userlist.getRandomStaff());

		// print the detail
		dil.printDeliveryString();

		System.out.print("[PROGRAME ENDED]");

		scan.close();

	}

	// load item file
	public static ArrayList<Item> readItemFile() {

		System.out.println("Load Item Data...");
		String linedata;
		List data;
		List<String> dataline = new ArrayList<String>();
		ArrayList<Item> itemList = new ArrayList<Item>();

		try {
			File file = new File("Data/Item.txt");
			Scanner scanf = new Scanner(file);
			Document doc;
			Parcel par;
			scanf.useDelimiter(",");

			while (scanf.hasNextLine()) {
				String str = scanf.nextLine();
				List<String> stratt = Arrays.asList(str.split(","));

				if (stratt.get(2).equals("D")) {
					doc = new Document(stratt.get(0), Double.parseDouble(stratt.get(1)));
					itemList.add(doc);
				} else if (stratt.get(2).equals("P")) {
					par = new Parcel(stratt.get(0), Double.parseDouble(stratt.get(1)));
					itemList.add(par);
				}

			}

			scanf.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemList;
	}

	// load staff file
	public static ArrayList<DeliveryStaff> readStaffFile() {

		System.out.println("Load Staff Data...");
		String linedata;
		List data;
		List<String> dataline = new ArrayList<String>();
		ArrayList<DeliveryStaff> devList = new ArrayList<DeliveryStaff>();

		try {
			File file = new File("Data/Staff.txt");
			Scanner scanf = new Scanner(file);
			scanf.useDelimiter(",");

			while (scanf.hasNextLine()) {
				String str = scanf.nextLine();

				List<String> stratt = Arrays.asList(str.split(","));

				DeliveryStaff dev = new DeliveryStaff(stratt.get(0), stratt.get(1), stratt.get(2));
				devList.add(dev);

			}

			scanf.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return devList;

	}

	// load client file
	public static ArrayList<Client> readClientFile() {
		System.out.println("Load Client Data...");
		String linedata;
		ArrayList<Client> cliList = new ArrayList<Client>();
		List data;
		List<String> dataline = new ArrayList<String>();

		try {
			File file = new File("Data/Client.txt");
			Scanner scanf = new Scanner(file);
			scanf.useDelimiter(",");

			while (scanf.hasNextLine()) {
				String str = scanf.nextLine();
				List<String> stratt = Arrays.asList(str.split(","));

				Client cli = new Client(stratt.get(0), stratt.get(1), stratt.get(2), Double.parseDouble(stratt.get(3)));
				cliList.add(cli);

			}

			scanf.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cliList;

	}

}
