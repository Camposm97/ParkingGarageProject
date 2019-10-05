package view;

import javax.swing.JOptionPane;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import pLData.ParkingLot;
import pLData.Space;
import util.ImgUtil;
import util.LightWork;
import vehicleH.State;
import vehicleH.Vehicle;
import vehicleH.VehicleType;

public class CheckInPane extends GridPane {
	private ParkingLot spaces;
	private TextField tfPlate, tfSpaceNum;
	private CheckBox cbSkip;
	private ComboBox<VehicleType> cbVehicleType;
	private ComboBox<String> cbState;
	private Button btAddVehicle;
	private Button btViewGarage;
	
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
		cbSkip.setOnAction(e -> { computeSpaceNumber(); });
		cbVehicleType = LightWork.loadCb(VehicleType.values());
		cbVehicleType.setOnAction(e -> { computeSpaceNumber(); });
		cbState = LightWork.loadCb(State.getAbbreviationList());
		btAddVehicle = loadBtAddVehicle();
		btViewGarage = loadBtViewGarage();
	}
	
	private void showControls() {
		HBox hBox = LightWork.loadHBox(btAddVehicle, btViewGarage);
		hBox.setAlignment(Pos.CENTER);
		addRow(0, new Label("License Plate:"), tfPlate);
		addRow(1, new Label("State:"), cbState);
		addRow(2, new Label("Vehicle Type:"), cbVehicleType);
		add(cbSkip, 1, 3);
		addRow(4, new Label("Space Number:"), tfSpaceNum);
		add(hBox, 0, 5, 2, 1);
		cbState.prefWidthProperty().bind(tfPlate.widthProperty());
		cbVehicleType.prefWidthProperty().bind(tfPlate.widthProperty());
	}
	
	private void computeSpaceNumber() {
		Vehicle v = new Vehicle(tfPlate.getText(), cbVehicleType.getValue(), cbState.getValue());
		int i = spaces.spaceFinder(v.getVType(), cbSkip.isSelected());
		tfSpaceNum.setText(String.valueOf(i));
	}
	
	private Button loadBtAddVehicle() {
		Button bt = new Button("Add Vehicle");
		bt.setOnAction(e -> {
			String spaceNum = tfSpaceNum.getText();
			String licensePlate = tfPlate.getText();
			VehicleType vType = cbVehicleType.getValue();
			String state = cbState.getValue();
			if (spaceNum != null && state != null) {
				int i = JOptionPane.showConfirmDialog(null, "Do they want Space # " + spaceNum + "?",
						"Space Confirmation" , 0, 3);
				if (i == 0) { // Yes
					Vehicle v= new Vehicle(licensePlate, vType, state);
					Space space = spaces.spaceInserter(v, Integer.valueOf(spaceNum));
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
	
	private Button loadBtViewGarage() {
		Button bt = new Button("View Garage");
		bt.setOnAction(e -> {
			BorderPane root = new BorderPane();
			GarageTableView garageView = new GarageTableView(spaces, root);
			root.setCenter(garageView.getContainer());
			Stage stage = new Stage();
			stage.setTitle(App.TITLE);
			stage.getIcons().add(ImgUtil.loadImg(ImgUtil.GARAGE_ICON));
			stage.setScene(new Scene(root));
			stage.showAndWait();
		});
		return bt;
	}
}
