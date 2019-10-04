package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import userData.UserDataManager;
import view.LoginPane;

public class App extends Application {
	public static final int WIDTH = 600, HEIGHT = 500;
	public static final String APP_TITLE = "Parking Garage: By The Three Stooges";
	private UserDataManager users;
	private BorderPane root;
	
	
	@Override
	public void init() {
		users = new UserDataManager(); // Load Data Here: DataLoader.loadObject(src);
		root = new BorderPane();
		root.setCenter(new LoginPane(users));		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle(APP_TITLE);
		stage.setScene(new Scene(root));
		stage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
