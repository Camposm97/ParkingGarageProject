package app;

import javafx.application.Application;
import javafx.stage.Stage;
import userData.UserDataManager;
import view.MainStage;

public class App extends Application {
	public static final int WIDTH = 500, HEIGHT = 400;
	public static final String TITLE = "Parking Garage v1.0";
	private UserDataManager users;
	
	@Override
	public void init() {
		users = new UserDataManager(); // Load Data Here: DataLoader.loadObject(src);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new MainStage(users);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
