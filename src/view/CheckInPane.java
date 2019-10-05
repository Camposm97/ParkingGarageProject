package view;

import javax.swing.JOptionPane;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import pLData.ParkingLot;
import pLData.Space;
import util.LightWork;
import vehicleH.Vehicle;
import vehicleH.VehicleType;

public class CheckInPane extends GridPane {
	private ParkingLot spaces;
	private TextField tfPlate, tfSpaceNum;
	private CheckBox cbSkip;
	private ComboBox<VehicleType> cbVehicleType;
	private Button btAddVehicle;
	
	public CheckInPane(ParkingLot spaces) {
		this.spaces = spaces;
		initControls();
		showControls();
	}
	
	private void initControls() {
		LightWork.initGridPaneSettings(this);
		tfPlate = new TextField();
		tfSpaceNum = new TextField();
		tfSpaceNum.setEditable(false);
		cbSkip = new CheckBox("Find a Closer Parking Spot");
		cbSkip.setOnAction(e -> {
			computeSpaceNumber();
		});
		cbVehicleType = LightWork.loadCb(VehicleType.values());
		cbVehicleType.setOnAction(e -> {
			computeSpaceNumber();
		});
		btAddVehicle = loadBtAddVehicle();
	}
	
	private void computeSpaceNumber() {
		Vehicle v = new Vehicle(tfPlate.getText(), cbVehicleType.getValue());
		int i = spaces.spaceFinder(v.getVType(), cbSkip.isSelected());
		tfSpaceNum.setText(String.valueOf(i));
	}
	
	private Button loadBtAddVehicle() {
		Button bt = new Button("Add Vehicle");
		bt.setOnAction(e -> {
			String spaceNum = tfSpaceNum.getText();
			if (spaceNum != null) {
				int i = JOptionPane.showConfirmDialog(null, "Do they want Space # " + spaceNum + "?",
						"Space Confirmation" , 0, 3);
				if (i == 0) { // Yes
					Space space = spaces.spaceInserter(new Vehicle(tfPlate.getText(), cbVehicleType.getValue()), Integer.valueOf(spaceNum));
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(App.TITLE);
					alert.setHeaderText("Succesfully added vehicle to Space #" + spaceNum);
					alert.setContentText("Parked @ " + space.getTimeParked());
					alert.showAndWait();
				}
			}
		});
		return bt;
	}
	
	private void showControls() {
		HBox hBox = LightWork.loadHBox(btAddVehicle);
		hBox.setAlignment(Pos.CENTER);
		addRow(0, new Label("License Plate:"), tfPlate);
		addRow(1, new Label("Vehicle Type:"), cbVehicleType);
		add(cbSkip, 1, 2);
		addRow(3, new Label("Space Number:"), tfSpaceNum);
		add(hBox, 0, 4, 2, 1);
		cbVehicleType.setPrefWidth(tfPlate.getWidth());
		cbVehicleType.prefWidthProperty().bind(tfPlate.widthProperty());
	}
}
