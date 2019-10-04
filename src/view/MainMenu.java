package view;

import javafx.scene.layout.BorderPane;
import userData.UserData;
import userData.UserDataManager;

public class MainMenu extends BorderPane {
	
	public MainMenu(UserDataManager users, UserData userData) {
		super.setTop(new GarageMenuBar(users));
	}
}
