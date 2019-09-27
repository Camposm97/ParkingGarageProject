package view;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginPane extends GridPane {
	private TextField tfUsername;
	private PasswordField tfPassword;
	
	public LoginPane() {
		tfUsername = new TextField();
		tfPassword = new PasswordField();
		addRow(0, new Label("Username:"), tfUsername);
		addRow(1, new Label("Password:"), tfPassword);
	}
}
