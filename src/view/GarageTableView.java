package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import pLData.ParkingLot;
import pLData.Space;

public class GarageTableView {
	
	Pane container;
	TableView<Space> table;
	
	public GarageTableView(ParkingLot lot) {
		this.generateTable(lot);
	}

	private void generateTable(ParkingLot lot) {
		TableView<Space> table = new TableView<Space>();
		TableColumn<Space, String> spots = new TableColumn<Space, String>("Attacks");
		spots.setCellValueFactory(
	            new PropertyValueFactory<Space, String>("name"));
		table.getColumns().addAll(spots);
		
		
		
		ObservableList<Space> list1 = FXCollections.observableArrayList(lot.getParkingLotArray());
		table.setItems(list1);
		
	}

}
