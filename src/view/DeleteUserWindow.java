package view;

import java.util.Optional;

import app.App;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import userData.UserData;
import userData.UserDataManager;

public class DeleteUserWindow extends TextInputDialog {
	
	public DeleteUserWindow(UserDataManager users) {
		super.setTitle(App.TITLE);
		super.setHeaderText("Please enter the name of the user you'd like to delete:");
		super.setContentText("Username:");
		Optional<String> result = this.showAndWait();
		if (result.isPresent()) {
			int index = users.getIndexFromUserName(result.get());
			UserData user = users.getUserList().get(index);
			user.closeAccount();
			showDisabledAccount(user);
		}
	}
	
	private void showDisabledAccount(UserData user) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(App.TITLE);
		alert.setHeaderText("Successfully removed: " + user.getUserName());
		alert.setContentText("This account is now closed.");
		alert.showAndWait();
	}
}
