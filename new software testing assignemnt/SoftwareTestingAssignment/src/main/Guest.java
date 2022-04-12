import java.util.*;

public class Guest extends Client {

	private double distance;
	private DeliveryItemList dil;

	// constructor
	Guest(String username, String phoneNum, double distance) {
		super(username, phoneNum, "-", distance);
		this.setDistance(distance);
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
