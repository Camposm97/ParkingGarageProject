package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.LightWork;
import view.LoginPane;

public class App extends Application {
	private static final String APP_TITLE = "Parking Garage: By The Three Stooges";
	private BorderPane root;
	
	@Override
	public void init() {
		root = new BorderPane();
		root.setPadding(LightWork.DEFAULT_INSETS);
		root.setCenter(new LoginPane());
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
