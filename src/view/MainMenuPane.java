package view;

import javafx.scene.layout.BorderPane;
import model.Garage;
import model.UserData;

/**
 * Purpose of this class is that it's a container that contains the 
 * GarageMenuBar to enable the user to interact with the Parking Garge.
 * @author Michael Campos
 */
public class MainMenuPane extends BorderPane {
	public MainMenuPane(Garage garage, UserData userData) {
		super.setTop(new GarageMenuBar(garage, userData));
	}
}
