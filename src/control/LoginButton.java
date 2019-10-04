package control;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import userData.UserData;
import userData.UserDataManager;
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
		@Override
		public void handle(ActionEvent e) {
			UserDataManager users = login.getUsers();
			String username = login.getUsername();
			String password = login.getPassword();
			UserData user = users.login(username, password);
			if (user != null) {
				Stage stage = (Stage) login.getScene().getWindow();
				stage.setWidth(App.WIDTH);
				stage.setHeight(App.HEIGHT);
				stage.centerOnScreen();
				login.getScene().setRoot(new MainMenu(users, null));
			}
		}
	}
}
