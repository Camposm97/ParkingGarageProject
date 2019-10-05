package view;

import control.ViewGarageButton;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import pLData.ParkingLot;
import register.CashRegister;
import util.LightWork;
import vehicleH.State;

public class CheckOutPane extends GridPane {
	private ParkingLot spaces;
	private TextField tfPlate;
	private ComboBox<String> cbState;
	private Button btDelete, btViewGarage;
	
	public CheckOutPane(ParkingLot spaces) {
		this.spaces = spaces;
		initControls();
		showControls();
	}
	
	private void initControls() {
		LightWork.initGridPaneSettings(this);
		tfPlate = new TextField();
		cbState = LightWork.loadCb(State.getAbbreviationList());
		btDelete = loadBtDelete();
		btViewGarage = new ViewGarageButton(spaces);
	}
	
	private void showControls() {
		HBox hBox = LightWork.loadHBox(btDelete, btViewGarage);
		hBox.setAlignment(Pos.CENTER);
		addRow(0, new Label("License Plate:"), tfPlate);
		addRow(1, new Label("State: "), cbState);
		add(hBox, 0, 2, 2, 1);
		cbState.prefWidthProperty().bind(tfPlate.widthProperty());
	}
	
	private Button loadBtDelete() {
		Button bt = new Button("Check-Out Vehicle");
		bt.setOnAction(e -> {
			String licensePlate = tfPlate.getText();
			String stateAbbr = cbState.getValue();
			
			if (!licensePlate.isEmpty() && !stateAbbr.isEmpty()) {
				State state = State.valueOfAbbreviation(stateAbbr);
				CashRegister cr = new CashRegister();
				cr.closeTicket(spaces, licensePlate, state);
				((BorderPane) this.getParent()).setCenter(null);
			}
		});
		return bt;
	}
}
