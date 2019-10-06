package view;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.ParkingLot;

public class ParkingLotViewer extends Stage {
	private GarageTableView garageView;
	private int chosenSpaceNum;
	
	public ParkingLotViewer(ParkingLot spaces) {
		BorderPane root = new BorderPane();
		this.garageView = new GarageTableView(spaces, root);
		root.setCenter(garageView.getContainer());
	}
}
