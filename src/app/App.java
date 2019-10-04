package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pLData.ParkingLot;
import view.GarageMenuBar;
import view.GarageTableView;
import view.LoginPane;

public class App extends Application {
	private static final String APP_TITLE = "Parking Garage: By The Three Stooges";
	private BorderPane root;
	
	@Override
	public void init() {
		
		root = new BorderPane();
		root.setTop(new GarageMenuBar()); // Temporary (Testing)
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
