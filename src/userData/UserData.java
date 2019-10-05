package userData;

import java.io.Serializable;

import util.UsernameUtil;

public class UserData implements Serializable{

	private static final long serialVersionUID = -4850660125697691278L;
	private String userName;
	private String password;
	private boolean isAdmin;
	private String firstName;
	private String lastName;
	private boolean isDisabled;
	public UserData(String firstName, String lastName, String password, int listIndex ) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.generateUserName(listIndex);
		this.autoSetAdmin(listIndex);
		this.isDisabled = false;
	}

	private void autoSetAdmin(int listIndex) {
		if (listIndex == 0) {
			this.isAdmin = true;
		}
		else {
			this.isAdmin = false;
		}
	}

	private void generateUserName(int listIndex) {
		this.userName = UsernameUtil.emitUsername(this.firstName, this.lastName) + listIndex;
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void closeAccount() {
		if(this.getUserName() == "admin0") {
			
		}else {
		this.isDisabled = true;
		}
	}
	public boolean isDisabled() {
		return this.isDisabled;
	}
	
	

}
