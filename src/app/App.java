/**
 * App package contains solely the App class to run the entire program
 */
package app;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Garage;
import model.ParkingLot;
import model.UserDataManager;
import util.DataLoader;
import util.LightWork;
import view.MainStage;
/**
 * <h1> Parking Garage Application </h1>
 * <p> This is a simple project designed for a parking attendant to utilize.</p>
 * This is the main Application page that loads up the MainStage
 * 
 * 
 * @author Chris Demonte, Michael Campos, Matt Guidi
 * @version 1.0
 * @since  2019-10-7
 * 
 *
 */

public class App extends Application {
	public static final int WIDTH = 500, HEIGHT = 400;
	public static final String TITLE = "Parking Garage v1.0";
	private static final int CAR_SIZE = 80, TRUCK_SIZE = 10, MOTORCYCLE_SIZE = 10;
	private Garage garage;
	
	@Override
	public void init() {
		File file = new File(LightWork.GARAGE_SRC);
		if (file.exists())
			garage = (Garage) DataLoader.readObject(LightWork.GARAGE_SRC);
		else
			garage = new Garage(new UserDataManager(), new ParkingLot(CAR_SIZE, TRUCK_SIZE, MOTORCYCLE_SIZE));
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage = new MainStage(garage);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
