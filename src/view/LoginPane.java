package view;

import static util.LightWork.initGridPaneSettings;
import static util.LightWork.loadHBox;
import static util.LightWork.loadVBox;

import control.LoginButton;
import control.MyLabel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Garage;

public class LoginPane extends GridPane {
	public static final int WIDTH = 300, HEIGHT = 300;
	private Garage garage;
	private MyLabel lblPrompt;
	private TextField tfUsername;
	private PasswordField tfPassword;
	private LoginButton btLogin;
	
	public LoginPane(Garage garage) {
		this.garage = garage;
		initGridPaneSettings(this);
		initControls();
		showControls();
	}
	
	public Garage getGarage() {
		return garage;
	}
	
	public String getUsername() {
		return tfUsername.getText();
	}
	
	public String getPassword() {
		return tfPassword.getText();
	}
	
	private void initControls() {
		lblPrompt = new MyLabel("Please enter your credentials below:", 14);
		tfUsername = new TextField();
		tfPassword = new PasswordField();
		btLogin = new LoginButton(this);
		super.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER)
				btLogin.fire();
		});
	}
	
	private void showControls() {
		VBox vBox = loadVBox(new MyLabel("Parking Garage Project", 24), new MyLabel("By The Three Stooges", 16));
		vBox.setAlignment(Pos.CENTER);
		HBox hBox = loadHBox(btLogin);
		hBox.setAlignment(Pos.CENTER);
		add(vBox, 0, 0, 2, 1);
		add(lblPrompt, 0, 1, 2, 1);
		addRow(2, new Label("Username:"), tfUsername);
		addRow(3, new Label("Password:"), tfPassword);
		add(hBox, 0, 4, 2, 1);
	}
}
