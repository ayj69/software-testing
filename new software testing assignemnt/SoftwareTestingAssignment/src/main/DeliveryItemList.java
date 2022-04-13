import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DeliveryItemList {

	ArrayList<Item> devItemList = new ArrayList<Item>();
	DeliveryStaff devStaff;
	LocalDate date;
	LocalDate todayDate = LocalDate.now();
	Client cli;

	boolean sameDate = false;
	boolean insurance = false;
	double price;
	int year;
	int month;
	int days;

	// empty constructor for easy access // i am sure this practice is wrong but whatever
	DeliveryItemList() {
	}

	public ArrayList<Item> getDevItemList() {
		return devItemList;
	}

	public void setDevItemList(ArrayList<Item> devItemList) {
		this.devItemList = devItemList;
	}

	public Client getCli() {
		return cli;
	}

	public void setCli(Client cli) {
		this.cli = cli;
	}

	public DeliveryStaff getDevStaff() {
		return devStaff;
	}

	public void setDevStaff(DeliveryStaff devStaff) {
		this.devStaff = devStaff;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}

	// get the y/n answer
	public boolean getyn(String choice) {
		boolean flag = false;
		Scanner scan = new Scanner(System.in);




			if ((choice.equals("Y") || choice.equals("y"))) {
				flag = true;
			} else if ((choice.equals("N") || choice.equals("n"))) {
				flag = false;
			} else if (!(choice.equals("Y") || choice.equals("y") || choice.equals("n") || choice.equals("N"))) {
				throw new IllegalArgumentException("Error,this choice is not valid");
			}

			return flag;

	}

	// print a list of item
	// and let the user choose the item based on the index number
	public LinkedList<Item> getItem(LinkedList<Item> itemList) {
		LinkedList<Item> tempArr = new LinkedList<Item>();
		String choice = "-";
		ItemList itemlist = new ItemList();
		Scanner scan = new Scanner(System.in);

		while (!(choice.equals("x") || choice.equals("X"))) {

			itemlist.printArrayString(itemList);
			System.out.print("Please enter your choice or press X to exit  :  ");
			choice = scan.next();

			if (!(choice.equals("x") || choice.equals("X")) && isNumeric(choice)) {

				int number = Integer.parseInt(choice);

				if (number <= 0 || number > itemList.size() + 1) {

					System.out.println("out of range");

				} else if (itemList.get(number - 1).getStatus() == ItemStatus.DELIVER) {

					System.out.println("sry but this item is unavalible");

				} else {

					itemList.get(number - 1).setStatus(ItemStatus.DELIVER);
					tempArr.add(itemList.get(number - 1));

				}
			}
		}

		if (tempArr.isEmpty())
			System.out.println("the user did not chose any item");
		else
			System.out.println("this is your selected item : ");

		itemlist.printArrayString(tempArr);

		return tempArr;
	}

	// i copy from web
	// check if a string is able to parse or not
	public boolean isNumeric(String string) {
		int intValue;

		System.out.println(String.format("Verify Choice: \"%s\"", string));

		if (string == null || string.equals("")) {
			System.out.println("Invalid Choice, it is null or empty.");
			return false;
		}

		try {
			intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input String cannot be parsed to Integer.");
		}
		return false;
	}

	// validate the date and check if the date is before for 3 month in the future
	public boolean validateMonthDay(int year, int month, int days) {

		boolean flag;
		LocalDate dateNow = LocalDate.now();
		LocalDate date = LocalDate.of(year, month, days);

		switch (month) {
		case 1, 3, 5, 7, 9, 11:

			if (days <= 31 && days > 0)
				flag = true;
			else
				flag = false;

			break;
		case 4, 6, 8, 10, 12:

			if (days <= 30 && days > 0)
				flag = true;
			else
				flag = false;

			break;
		case 2:

			if ((year % 4 == 0) && !(year % 100 == 0)) {
				if (days <= 29 && days > 0)
					flag = true;
				else
					flag = false;
			} else {
				if (days <= 28 && days > 0)
					flag = true;
				else
					flag = false;
			}
			break;

		default:
			flag = false;
			break;
		}

		if (date.isBefore(dateNow)) {
			System.out.println("ERROR, Please enter today or future date.");
			flag = false;
		}
		if (date.isAfter(dateNow.plusMonths(3))) {
			System.out.println("Please enter the date within 3 month.");
			flag = false;
		}

		return flag;
	}

	// get valid date
	public void getDate() {

		//LocalDate date = null;
		int year = LocalDate.now().getYear();
		int month;
		int days;
		Scanner scan = new Scanner(System.in);
		boolean get = false;

		do {

			try {

				System.out.print("Days :  ");
				days = scan.nextInt();

				System.out.print("Month :  ");
				month = scan.nextInt();

				if (validateMonthDay(year, month, days) == true)
					date = LocalDate.of(year, month, days);

				get = true;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("ERROR, invalid input");
				scan.nextLine();
			}

		} while (!get || date == null);

		scan.close();
		this.date = date;
	}

	// check if its is same date
	public void checkSameDate(LocalDate date) {

		LocalDate dateNow = LocalDate.now();

		if (date.isEqual(dateNow)) {
			System.out.println("same date plus rm15");
			this.sameDate = true;
		}else {
			throw new DateTimeException("The date format is invalid!");
		}

	}

	// printing report
	public void printDeliveryString() {

		double basicPrice = 0;
		double insurancePrice = this.insurance ? 10.0 : 0.0;
		double totalPrice;
		double samedatePrice = this.sameDate ? 15.0 : 0.0;
		System.out.print(
				"\nDelivery Detail\n---------------------------------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < this.devItemList.size(); i++) {
			double price = this.getDevItemList().get(i).calCharge(this.getDevItemList().get(i).getWeight(),
					this.getCli().getDistance());
			basicPrice += price;
			System.out.println(String.format("%3d", i + 1) + " :  " + this.devItemList.get(i).toString()
					+ "   Distance :  " + String.format("%-10.2f",this.getCli().getDistance()) + "   Price :  " + String.format("%-10.2f", price));
		}
		System.out.print(
				"---------------------------------------------------------------------------------------------------------------------------\n");

		totalPrice = basicPrice + insurancePrice + samedatePrice;
		System.out.println("Basic price = " + basicPrice);

		if (this.insurance)
			System.out.println("insurance = " + insurancePrice);
		if (this.sameDate)
			System.out.println("Samedate delivery fee = " + samedatePrice);

		System.out.println("TotalPrice = " + totalPrice);
		System.out.println("the parcel will be deliver at " + this.date);
		System.out.print("your item will be deliver by :   ");
		System.out.println(this.getDevStaff().getUsername() + "  Staff Phone-Num :  " + this.devStaff.getPhoneNum());
	}



	
	
	
	
}
