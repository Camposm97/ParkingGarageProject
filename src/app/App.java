package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userData.UserDataManager;
import view.LoginPane;

public class App extends Application {
	public static final int WIDTH = 600, HEIGHT = 500;
	public static final String TITLE = "Parking Garage v1.0";
	private UserDataManager users;	
	
	@Override
	public void init() {
		users = new UserDataManager(); // Load Data Here: DataLoader.loadObject(src);	
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(TITLE);
		stage.setScene(new Scene(new LoginPane(users), LoginPane.WIDTH, LoginPane.HEIGHT));
		stage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
