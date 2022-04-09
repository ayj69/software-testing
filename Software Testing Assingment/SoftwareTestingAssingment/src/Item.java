import java.util.*;

enum ItemStatus {
	AVALIBLE, DELIVER, CANCEL

};

public abstract class Item {

	private String name;
	private ItemStatus status = ItemStatus.AVALIBLE;
	private double weight;
	private String itemType;

	Item(String name, double weight, String type) {
		this.name = name;
		this.weight = weight;
		this.itemType = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public String toString() {
		return "Name :  " + String.format("%-15s", name) + "  " + "Weight :  " + String.format("%-10.2f", weight) + " "
				+ "  Status :  " + String.format("%-10s", status);
	}

	public abstract double calCharge(double weightVal, double distanceVal);

	public abstract double calCharge(TreeMap<Double, Weight> weight, TreeMap<Double, Distance> distance,
			double weightVal, double distanceVal);

}
