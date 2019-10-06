package model;

import java.io.Serializable;

import util.UsernameUtil;
/**
 * UserData is an object for each Parking Attendant employee and Admin
 * Automatically creates a default admin account if the UserDataManager passes in a zero
 * @author Chris Demonte, Matt Guidi
 *
 */
public class UserData implements Serializable{

	private static final long serialVersionUID = -4850660125697691278L;
	private String userName;
	private String password;
	private boolean isAdmin;
	private String firstName;
	private String lastName;
	private boolean isDisabled;
	/**
	 * UserData constructor
	 * @param firstName The first name of the employee
	 * @param lastName The last name of the employee
	 * @param password The password the user would like to use
	 * @param listIndex The index in the array they will be inserted (used for username creation)
	 */
	public UserData(String firstName, String lastName, String password, int listIndex ) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.generateUserName(listIndex);
		this.autoSetAdmin(listIndex);
		this.isDisabled = false;
	}
	/**
	 * If zero (first user) it is automatically set admin to allow for new users
	 * @param listIndex where this is inserted into the user array
	 * @see UserDataManager#UserDataManager()
	 */
	private void autoSetAdmin(int listIndex) {
		if (listIndex == 0) {
			this.isAdmin = true;
		}
		else {
			this.isAdmin = false;
		}
	}
	/**
	 * Generates a username based on emitUsername(String fN, String lN)
	 * Adds the index at the end 
	 * @param listIndex takes in the index it is stored in the area which is apart of the new username
	 * @see UsernameUtil#emitUsername(String, String)
	 */
	private void generateUserName(int listIndex) {
		this.userName = UsernameUtil.emitUsername(this.firstName, this.lastName) + listIndex;
		
	}
	/**
	 * @return Returns the user name 
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 * @return Returns the password of this user
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password Changes the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return If true then the user is an admin and views more options
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * Changes if this user is an admin
	 * @param isAdmin desired effect on the current user
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * 
	 * @return Returns the full first name of this person
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 
	 * @param firstName desired firstName to be set for this user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return Returns the full last name of this person
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName desired last name to be set for this user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * 
	 */
	public boolean closeAccount() {
		if(this.getUserName().compareTo("admin0") >= 0) {
			return false;
		}else {
		this.isDisabled = true;
		return true;
		}
	}
	public boolean isDisabled() {
		return this.isDisabled;
	}
	
	

}
