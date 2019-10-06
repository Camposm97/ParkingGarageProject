package view;

import java.util.Optional;
import app.App;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.UserData;
import model.UserDataManager;
import javafx.scene.control.TextInputDialog;

public class DeleteUserWindow extends TextInputDialog {
	
	public DeleteUserWindow(UserDataManager users) {
		super.setTitle(App.TITLE);
		super.setHeaderText("Please enter the name of the \nuser you'd like to delete:");
		super.setContentText("Username:");
		Optional<String> result = this.showAndWait();
		if (result.isPresent()) {
			int index = users.getIndexFromUserName(result.get());
			UserData user = users.getUserList().get(index);
			if(user.closeAccount() == true) {
			showDisabledAccount(user);
			}else {
				cannotDisableAccount(user);
			}
		}
	}
	
	private void showDisabledAccount(UserData user) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(App.TITLE);
		alert.setHeaderText("Successfully removed: " + user.getUserName());
		alert.setContentText("This account is now closed.");
		alert.showAndWait();
	}
	private void cannotDisableAccount(UserData user) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(App.TITLE);
		alert.setHeaderText("You cannot remove " + user.getUserName());
		alert.setContentText("This is the root admin!");
		alert.showAndWait();
	}
}
