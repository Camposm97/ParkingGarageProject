package view;

import javafx.scene.layout.BorderPane;
import model.Garage;
import model.UserData;

/**
 * 
 * @author Michael Campos
 */
public class MainMenuPane extends BorderPane {
	public MainMenuPane(Garage garage, UserData userData) {
		super.setTop(new GarageMenuBar(garage, userData));
	}
}
