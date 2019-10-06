package view;

import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import model.UserData;
import model.UserDataManager;

public class UserDataViewer extends BorderPane {
	private UserDataManager users;
	private TableView<UserData> tvUsers;
	
	public UserDataViewer(UserDataManager users) {
		this.users = users;
		tvUsers = new TableView<UserData>();
	}
}
