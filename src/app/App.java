package app;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	private static final String APP_TITLE = "Parking Garage: By The Three Stooges";
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
