package view;

import java.util.Optional;

import app.App;
import javafx.scene.control.TextInputDialog;
import userData.UserDataManager;

public class DeleteUserWindow extends TextInputDialog {
	private UserDataManager users;
	
	public DeleteUserWindow(UserDataManager users) {
		this.users = users;
		super.setTitle(App.TITLE);
		super.setHeaderText("Please enter the name of the user you'd like to delete:");
		super.setContentText("Username:");
		Optional<String> result = this.showAndWait();
		if (result.isPresent()) {
			System.out.println(result.get());
		}
	}
}
