package userData;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDataManager implements Serializable{

	private static final long serialVersionUID = 3880700975400631301L;
	private ArrayList<UserData> userList;
	
	public UserDataManager(){
		this.createNewUserList();
	}

	//this constructor is to be used on startup if there is no DataManager saved in files
	private void createNewUserList() {
		this.userList = new ArrayList<UserData>();
		userList.add(new UserData("admin", "admin", "admin", 0));	
	}

	public void addUser(String firstName, String lastName, String password) {
		int index = this.userList.size();
		userList.add(new UserData(firstName, lastName, password, index));
	}
	//get user by index
	public UserData getUser (int index) {
		return this.userList.get(index);
	}
	//get user by username
	public UserData getUser (String userName) {
		int index = this.getIndexFromUserName(userName);
		return this.userList.get(index);
	}
	
	//removes a user using username
	public void removeUser (String userName) {
		int index = this.getIndexFromUserName(userName);
		if (index > 0) {
			this.userList.remove(index);
		}
		
	}
	//checks an entered password
	public boolean passwordCheck (String userName, String password) {
		if (userList.get(this.getIndexFromUserName(userName)).getPassword().contentEquals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	//used to generate list indexes from usernames. A regex expression removes all letters
	private int getIndexFromUserName(String userName) {
		int index = 0;
		String str = userName.replaceAll("[^a-zA-Z]", "");
		try {
			index = Integer.parseInt(str);
		}
		catch (NumberFormatException ex) {
			ex.printStackTrace();
			index = 0;
		}
		return index;
	}
	public ArrayList<UserData> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<UserData> userList) {
		this.userList = userList;
	}
	
	

}
