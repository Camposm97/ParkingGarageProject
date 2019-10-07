package view;

import static util.ImgUtil.GARAGE_ICON;
import static util.ImgUtil.loadImg;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import app.App;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Stage;
import model.UserData;
import model.UserDataManager;

/**
 * Purpose of this class is to display a ComboBox allowing the user to choosse a
 * username to "delete" from the user data structure.
 * 
 * @author Michael Campos
 */
public class DeleteUserDialog extends ChoiceDialog<String> {

	public DeleteUserDialog(UserDataManager users) {
		((Stage) super.getDialogPane().getScene().getWindow()).getIcons().add(loadImg(GARAGE_ICON));
		super.setTitle(App.TITLE);
		super.setHeaderText("Please enter choice the user\nyou would like to delete:");
		super.setContentText("Username:");
		List<String> usernameList = new LinkedList<>();
		for (UserData user : users.getUserList())
			usernameList.add(user.getUserName());
		super.getItems().addAll(usernameList);
		Optional<String> result = this.showAndWait();
		if (result.isPresent()) {
			int index = users.getIndexFromUserName(result.get());
			UserData user = users.getUserList().get(index);
			if (user.closeAccount() == true) {
				showDisabledAccount(user);
			} else {
				cannotDisableAccount(user);
			}
		}
	}

	private void showDisabledAccount(UserData user) {
		Alert alert = new Alert(AlertType.INFORMATION);
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(loadImg(GARAGE_ICON));
		alert.setTitle(App.TITLE);
		alert.setHeaderText("Successfully removed: " + user.getUserName());
		alert.setContentText("This account is now closed.");
		alert.showAndWait();
	}

	private void cannotDisableAccount(UserData user) {
		Alert alert = new Alert(AlertType.ERROR);
		((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(loadImg(GARAGE_ICON));
		alert.setTitle(App.TITLE);
		alert.setHeaderText("You cannot remove " + user.getUserName());
		alert.setContentText("This is the root admin!");
		alert.showAndWait();
	}
}
