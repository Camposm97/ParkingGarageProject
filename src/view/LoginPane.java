package view;

import static util.LightWork.initGridPaneSettings;
import static util.LightWork.loadHBox;

import control.LoginButton;
import control.MyLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import userData.UserDataManager;

public class LoginPane extends GridPane {
	private UserDataManager users;
	private TextField tfUsername;
	private PasswordField tfPassword;
	private LoginButton btLogin;
	
	public LoginPane(UserDataManager users) {
		this.users = users;
		initGridPaneSettings(this);
		initControls();
		showControls();
	}
	
	public UserDataManager getUsers() {
		return users;
	}
	
	public String getUsername() {
		return tfUsername.getText();
	}
	
	public String getPassword() {
		return tfPassword.getText();
	}
	
	private void initControls() {
		tfUsername = new TextField();
		tfPassword = new PasswordField();
		btLogin = new LoginButton(this);
		super.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				btLogin.fire();
		});
	}
	
	private void showControls() {
		HBox hBox = loadHBox(btLogin);
		hBox.setAlignment(Pos.CENTER);
		add(new MyLabel("Please enter your credentials:", 16), 0, 0, 2, 1);
		addRow(1, new Label("Username:"), tfUsername);
		addRow(2, new Label("Password:"), tfPassword);
		add(hBox, 0, 3, 2, 1);
	}
}
