package view;

import javafx.scene.layout.BorderPane;
import model.Garage;
import model.UserData;

public class MainMenu extends BorderPane {
	
	public MainMenu(Garage garage, UserData userData) {
		super.setTop(new GarageMenuBar(garage, userData));
	}
}
