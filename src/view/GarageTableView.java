package view;


import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import pLData.ParkingLot;
import pLData.Space;

public class GarageTableView {
	
	ScrollPane container;
	GridPane grid;
	
	public GarageTableView(ParkingLot lot) {
		this.generateLayout(lot);
	}

	private void generateLayout(ParkingLot lot) {
		container = new ScrollPane();
		grid = new GridPane();
		ArrayList<Space> spaces = lot.getParkingLotArray();
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
			
			grid.add(label, i%10, i/10);
			GridPane.setMargin(label, new Insets(5, 0,0, 5));
			
		}
		container.setContent(grid);
	}

	public ScrollPane getContainer() {
		return container;
	}

	public void setContainer(ScrollPane container) {
		this.container = container;
	}
	

}
