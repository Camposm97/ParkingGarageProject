package control;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import userData.UserDataManager;

public class LoginButton extends Button {
	private UserDataManager users;
	
	public LoginButton(UserDataManager users) {
		super("Login");
		super.setOnAction(new LoginHandler());
		this.users = users;
	}
	
	private class LoginHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			
		}
	}
}
