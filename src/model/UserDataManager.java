package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import util.DataLoader;
import util.DataSaver;
/**
 * User Data manager is a container for the employee data, including first and last name, usernames, passwords
 * User data is stored in an array list with index 0 being an admin by default
 * @author Chris DeMonte, Matt Guidi
 *
 */
public class UserDataManager implements Serializable{

	private static final long serialVersionUID = 3880700975400631301L;
	/**
	 * userList is an arrayList of Userdata
	 */
	private ArrayList<UserData> userList;
	
	/**
	 * This no parameter constructor creates a new user list
	 */
	public UserDataManager(){
		this.createNewUserList();
	}

	/**
	 * 	this constructor is to be used on startup if there is no DataManager saved in files
	 */
	private void createNewUserList() {
		this.userList = new ArrayList<UserData>();
		userList.add(new UserData("a", "dmin", "admin", 0));	
	}

	/**
	 * Adds a user with a given firstname, lastname and password
	 * @param firstName is the first name of the employee
	 * @param lastName is the last name
	 * @param password password is a password with 8-16 characters, at least one number, at least one lowercase letter, at least one uppercase
	 */
	public void addUser(String firstName, String lastName, String password) {
		int index = this.userList.size();
		userList.add(new UserData(firstName, lastName, password, index));
	}
	/**
	 * Gets the user using an index
	 * @param index is the user's index in the array
	 * @return a userData object
	 */
	public UserData getUser (int index) {
		return this.userList.get(index);
	}
	/**
	 * Gets the user using a String for username
	 * @param userName is a String using the first letter of the first name, last name, and index number
	 * @return returns the userData object
	 */
	public UserData getUser (String userName) {
		int index = this.getIndexFromUserName(userName);
		
		return this.userList.get(index);
	}
	
	/* Removing is not ok because then we'd modify everyone's username for the ID check to work
	 * Employer's like to keep users in the system to see what's going on. 
	//removes a user using username
	public void removeUser (String userName) {
		int index = this.getIndexFromUserName(userName);
		if (index > 0) {
			this.userList.remove(index);
		}
		
	}
	*/ 
	/**
	 * Checks if a password is valid (8-16 characters, at least one uppercase letter, at least one lowercase, at least one number)
	 * @param password is the string representing a possible password
	 * @return true if the password is good, and false if it fails to comply to the requirements
	 */
	public boolean validPassword (String password) {
		if (password.length() < 8 || password.length() > 16) {
			return false;
		}
		boolean valid = false;
		for (int i = 0; i < password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i))){
            	valid = true;
            }
		}
		if (valid == false) {
			return false;
		}
		valid = false;
		for (int i = 0; i < password.length(); i++) {
            if(Character.isLowerCase(password.charAt(i))){
            	valid = true;
            }
		}
		if (valid = false) {
			return false;
		}
		valid = false;
		for (int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))){
            	valid = true;
            }
		}
		if (valid = false) {
			return false;
		}
		return true;
	}
	/**
	 * Checks a username-password pair, by comparing the two inputs to the data saved in the usermanager
	 * @param userName is the input username
	 * @param password is the input password
	 * @return true if the password matches the records, else returns false
	 */
	public boolean passwordCheck (String userName, String password) {
		int i = this.getIndexFromUserName(userName);
		if (userList.get(i).getPassword().contentEquals(password) && userList.get(i).getUserName().contentEquals(userName)) {
			System.out.println("Sup");
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * This takes in a username and filters out any non numeric characters to give a number representing the user's index in the user array
	 * @param userName is the user's username
	 * @return the numerics in the username that are utilized by the userManager as array indexes
	 */
	public int getIndexFromUserName(String userName) {
		int index = 0;
		// I modified the regex because this takes in only digits! that's what we need to find the index!
		String str = userName.replaceAll("[^0-9]", "");
		try {
			// This way they can just type in admin admin
			if(str.equals("")) {
				str = "0";
			}
			index = Integer.parseInt(str);
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
			index = 0;
		}
		return index;
	}
	/**
	 * Logs a user in by taking in their credentials and returning the user data object
	 * @param userName is the user's username
	 * @param password is the user's password
	 * @return the user's userData if credentials are good, else returns null
	 */
	public UserData login(String userName, String password) {
		int index = getIndexFromUserName(userName);
		if(index < 0 || index >= userList.size()) {
			return null;
		}
		if(passwordCheck(userName, password)) {
			return this.getUser(index);
		}
		return null; 
	}
	/**
	 * Saves the user data list to the file directory
	 */
	public void saveUserList() {
		String adr = "resources/userdat.data";
		DataSaver.writeObject(this, adr);
	}
	/**
	 * loads the user data list from the file directory
	 */
	public void loadUserList() {
		String adr = "resources/userdat.data";
		File file = new File(adr);
		boolean exists = file.exists();
		if (exists) {
			UserDataManager temp = (UserDataManager)DataLoader.readObject(adr);
			this.userList = temp.getUserList();
		}
	}
	public ArrayList<UserData> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserData> userList) {
		this.userList = userList;
	}
}
