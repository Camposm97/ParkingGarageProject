package control;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.UserData;
import model.UserDataManager;
import view.LoginPane;
import view.MainMenu;

public class LoginButton extends Button {
	private LoginPane login;
	
	public LoginButton(LoginPane login) {
		super("Login");
		super.setOnAction(new LoginHandler());
		this.login = login;
	}
	
	private class LoginHandler implements EventHandler<ActionEvent> {
		private UserDataManager users;
		private String username, password;
		private UserData user;
		
		@Override
		public void handle(ActionEvent e) {
			this.users = login.getGarage().getUsers();
			this.username = login.getUsername();
			this.password = login.getPassword();
			if (!username.isEmpty() && !password.isEmpty()) {
				this.user = users.login(username, password);
			
				if (user != null && !user.isDisabled())
					validLogin();
				else if (user == null)
					showInvalidWindow();
				else if (user.isDisabled())
					showDisabledUserWindow();
			}
		}
		
		public void validLogin() {
			Stage stage = (Stage) login.getScene().getWindow();
			login.getScene().setRoot(new MainMenu(login.getGarage(), user));
			stage.setWidth(App.WIDTH);
			stage.setHeight(App.HEIGHT);
			stage.centerOnScreen();
			stage.setTitle(App.TITLE + ": Logged in as: " + user.getUserName() + "");
		}
		
		public void showDisabledUserWindow() {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle(App.TITLE);
			alert.setHeaderText("The account you tried logging in as is no longer valid.");
			alert.setContentText("In other words, you have been terminated :D");
			alert.showAndWait();
		}
		
		public void showInvalidWindow() {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(App.TITLE);
			alert.setHeaderText("Invalid Username or Password!");
			alert.setContentText("Please make sure your username and password is correct.");
			alert.showAndWait();
		}
	}
}
