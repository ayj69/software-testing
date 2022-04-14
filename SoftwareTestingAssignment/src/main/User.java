import java.util.*;

enum UserStatus {
	MEMBER, DELIVERSTAFF, GUEST, DEF
};

public class User {
	private String username;
	private String phoneNum;
	private String password;

	User(String username, String phoneNum, String password) {
		this.username = username;
		this.phoneNum = phoneNum;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}
