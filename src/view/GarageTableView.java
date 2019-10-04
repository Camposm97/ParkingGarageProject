package view;


import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pLData.ParkingLot;
import pLData.Space;

/**
 * GarageTableView is not a table view. It is a GridPane inside a ScrollPane. 
 * It requires a ParkingLot object to be constructed.
 * The public function refreshGrid requires a ParkingLot object, and refreshes the grid
 * Has a getter and setter for the ScrollPane 
 * @author chris
 *
 */

public class GarageTableView {
	
	ScrollPane container;
	GridPane grid;
	
	public GarageTableView(ParkingLot lot) {
		this.generateLayout(lot);
		container = new ScrollPane();
	}

	private void generateLayout(ParkingLot lot) {
		GridPane grid1 = new GridPane();
		ArrayList<Space> spaces = lot.getParkingLotArray();
		
		/*this loop creates a bunch of clickable labels that represent each spot in the garage. 
		 * If the spot is taken the button is made yellow and the license plate number is shown
		 * If the spot is free the button is made green and "Space is Empty" is shown
		 */
		for (int i = 0; i < spaces.size(); i++) {
			String info = new String ("" + i);
			Label label = new Label();
			if (spaces.get(i).getVehicleParked() != null) {
				info+= "\nCar Parked: " + spaces.get(i).getVehicleParked().getLicensePlate();
				label.setBackground(new Background(new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY, Insets.EMPTY)));
			}
			else {
				info+= "\nSpace Empty.";
				label.setBackground(new Background(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY, Insets.EMPTY)));
			}
			label.setText(info);
			
			//The grid is 10xn 
			grid1.add(label, i%10, i/10);
			GridPane.setMargin(label, new Insets(5, 0,0, 5));
			
		}
		this.grid = grid1;
		container.setContent(grid);
	}
	public void refreshGrid(ParkingLot lot) {
		this.generateLayout(lot);
	}

	public ScrollPane getContainer() {
		return container;
	}

	public void setContainer(ScrollPane container) {
		this.container = container;
	}
	

}
