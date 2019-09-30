package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import util.LightWork;

public class LoginPane extends GridPane {
	private TextField tfUsername;
	private PasswordField tfPassword;
	private Button btLogin;
	
	public LoginPane() {
		initCtrls();
		displayCtrls();
	}
	
	private void initCtrls() {
		tfUsername = new TextField();
		tfPassword = new PasswordField();
		btLogin = new Button("Login");
		btLogin.setOnAction(e -> {
			System.out.println("Not Yet Implemented");
		});
	}
	
	private void displayCtrls() {
		setAlignment(Pos.CENTER);
		setPadding(LightWork.DEFAULT_INSETS);
		HBox hBox = LightWork.loadHBox(btLogin);
		hBox.setAlignment(Pos.CENTER);
		add(new Label("Please enter your credentials:"), 0, 0, 2, 1);
		addRow(1, new Label("Username:"), tfUsername);
		addRow(2, new Label("Password:"), tfPassword);
		add(hBox, 0, 3, 2, 1);
		setHgap(10);
		setVgap(10);
	}
}
