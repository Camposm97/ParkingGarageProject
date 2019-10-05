package view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pLData.ParkingLot;
import util.LightWork;
import vehicleH.Vehicle;
import vehicleH.VehicleType;

public class CheckInPane extends GridPane {
	private ParkingLot spaces;
	private TextField tfPlate, tfSpaceNum;
	private CheckBox cbSkip;
	private ComboBox<VehicleType> cbVehicleType;
	
	public CheckInPane(ParkingLot spaces) {
		this.spaces = spaces;
		initControls();
		showControls();
	}
	
	private void initControls() {
		LightWork.initGridPaneSettings(this);
		tfPlate = new TextField();
		tfSpaceNum = new TextField();
		cbSkip = new CheckBox("Find a Closer Parking Spot");
		cbSkip.setOnAction(e -> {
			System.out.println("Checked");
		});
		cbVehicleType = LightWork.loadCb(VehicleType.values());
		cbVehicleType.setOnAction(e -> {
			Vehicle v = new Vehicle(tfPlate.getText(), cbVehicleType.getValue());
			int i = spaces.spaceFinder(v.getVType(), false);
			System.out.println(i);
		});
	}
	
	private void showControls() {
		addRow(0, new Label("Vehicle Type:"), cbVehicleType);
		addRow(1, new Label("License Plate:"), tfPlate);
		addRow(2, cbSkip);
		addRow(3, new Label("Space Number:"), tfSpaceNum);
		cbVehicleType.setPrefWidth(tfPlate.getWidth());
		cbVehicleType.prefWidthProperty().bind(tfPlate.widthProperty());
	}
}
