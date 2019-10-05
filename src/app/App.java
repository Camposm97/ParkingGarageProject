package app;

import javafx.application.Application;
import javafx.stage.Stage;
import userData.UserDataManager;
import view.MainStage;
/**
 * <h1> Parking Garage Application </h1>
 * <p> This is a simple project designed for a parking attendant to utilize.</p>
 * This is the main Application page that loads up the MainStage
 * 
 * 
 * @author Chris Demonte, Michael Campos, Matt Guidi
 * @version 0.8
 * @since  2019-09-25
 * 
 *
 */



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
