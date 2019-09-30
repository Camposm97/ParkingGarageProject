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
		add(new Label("Please enter your credentials:"), 0, 0, 2, 1);
		addRow(1, new Label("Username:"), tfUsername);
		addRow(2, new Label("Password:"), tfPassword);
		setHgap(10);
		setVgap(10);
	}
}
