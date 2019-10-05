package view;

import javafx.scene.layout.GridPane;
import pLData.ParkingLot;

public class CheckOutPane extends GridPane {
	private ParkingLot spaces;
	
	public CheckOutPane(ParkingLot spaces) {
		this.spaces = spaces;
	}
}
