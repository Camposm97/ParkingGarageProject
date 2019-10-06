package control;

import static util.ImgUtil.GARAGE_ICON;
import static util.ImgUtil.loadImg;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.*;
import util.LightWork;
import view.GarageTableView;

/**
 * Purpose of this class is when pressed, it opens a window
 * display all the statuses of the Parking Garage.
 * @author Michael Campos
 */
public class ViewGarageButton extends Button {	
	
	public ViewGarageButton(ParkingLot spaces) {
		super("View Garage");
		this.setOnAction(new ViewGarageHandler(spaces));
	}
	
	
	/**
	 * EventHandler for the ViewGarageButton. 
	 * @author Michael Campos
	 */
	public class ViewGarageHandler implements EventHandler<ActionEvent> {
		private ParkingLot spaces;
		
		public ViewGarageHandler(ParkingLot spaces) {
			this.spaces = spaces;
		}
		
		@Override
		public void handle(ActionEvent e) {
			BorderPane root = new BorderPane();
			root.setPadding(LightWork.DEFAULT_INSETS);
			GarageTableView garageView = new GarageTableView(spaces, root);
			root.setCenter(garageView.getContainer());
			Stage stage = new Stage();
			stage.setTitle(App.TITLE);
			stage.getIcons().add(loadImg(GARAGE_ICON));
			stage.setScene(new Scene(root));
			stage.show();
			
		}
		
		
	}
}
