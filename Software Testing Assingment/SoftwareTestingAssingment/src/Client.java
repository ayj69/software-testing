
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client extends User {

	private double distance;
	private DeliveryItemList dil;
	String userNameRegex = "^[a-zA-Z0-9._-]{3,}$";
	String phoneNumRegex = "^(01)[0-9]*[0-9]{7,8}$";
	String distanceRegex = "^[0-9]+\\.?[0-9]*$";
	
	Client(String username, String password, String phoneNum, double distance) {
		super(username, phoneNum, password);
		this.distance = distance;
	}
	
	
	public boolean checkStringRegex(String data,String regex) {
		Pattern pat = Pattern.compile(regex);
		Matcher mat;
		
		mat = pat.matcher(data);

		if (mat.find()) {
			return true;

		} else {
			return false;
		}
		
		
	}
	

	public void setUserName(String userName) {


		if(this.checkStringRegex(userName,this.userNameRegex)) {
			super.setUsername(userName);
		}else {
			throw new IllegalArgumentException("set Error,this username is not valid");
		}


		


	}

	
	public boolean checkDistance(Double distance) {
		
		if(distance == null)
			throw new IllegalArgumentException("Error,thie value of the distance is null");

		if(distance <= 0 || distance >= 100) {
			throw new IllegalArgumentException("Error, Please enter your distance, the limit is 0 - 100");
		}else {
			return true;
		}
		
	}
	
	
	
	public void setDistance(String distance) {

		if(this.checkStringRegex(distance,this.distanceRegex)) {
			this.distance = Double.parseDouble(distance);
		}else {
			throw new IllegalArgumentException("set Error,this distance is not valid");
		}
		

	}
	
	

	public void setPhoneNumber(String phoneNum) {


		if(this.checkStringRegex(phoneNum,this.phoneNumRegex)) {
			super.setPhoneNum(phoneNum);
		}else {
			throw new IllegalArgumentException("set Error,this phone-num is not valid");
		}


	}

	public double getDistance() {
		return distance;
	}

}
