package view;

import javafx.scene.layout.BorderPane;
import userData.UserData;
import userData.UserDataManager;

public class MainMenu extends BorderPane {
	private UserDataManager users;
	private UserData userData; // User that's currently logged in
	
	public MainMenu(UserDataManager users, UserData userData) {
		this.users = users;
		this.userData = userData;
		super.setTop(new GarageMenuBar());
	}
}
