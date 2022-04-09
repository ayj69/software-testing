import java.util.*;

public class ItemList {

	LinkedList<Item> itemList = new LinkedList<Item>();
	LinkedList<Item> tempList = new LinkedList<Item>();

	// print item list based on status //currently unused
	public void printArrayString2(List<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStatus() == ItemStatus.AVALIBLE) {
				tempList.add(list.get(i));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + 1 + " :  " + list.get(i).toString());
		}
	}

	// print item list
	public void printArrayString(List<?> list) {
		System.out.print(
				"\nITEM LIST\n----------------------------------------------------------------------------------\n");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(String.format("%3d", i + 1) + " :  " + list.get(i).toString());
		}
		System.out.println("----------------------------------------------------------------------------------");

	}

}
