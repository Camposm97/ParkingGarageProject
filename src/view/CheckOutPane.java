package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import pLData.ParkingLot;
import register.CashRegister;
import util.LightWork;

public class CheckOutPane extends GridPane {
	private ParkingLot spaces;
	private CashRegister cr;
	private TextField tfPlate;
	private Button btDelete;
	
	public CheckOutPane(ParkingLot spaces) {
		this.spaces = spaces;
		initControls();
		showControls();
	}
	
	private void initControls() {
		LightWork.initGridPaneSettings(this);
		tfPlate = new TextField();
		btDelete = loadBtDelete();
	}
	
	private Button loadBtDelete() {
		Button bt = new Button("Check-Out Vehicle");
		bt.setOnAction(e -> {
			String licensePlate = tfPlate.getText();
			if (!licensePlate.isEmpty()) {
				int index = spaces.vehicleFinder(licensePlate);
				if (index != -1) {
					
				}
			}
		});
		return bt;
	}
	
	private void showControls() {
		HBox hBox = LightWork.loadHBox(btDelete);
		hBox.setAlignment(Pos.CENTER);
		addRow(0, new Label("License Plate:"), tfPlate);
		add(hBox, 0, 1, 2, 1);
	}
}
