package view;

import static util.ImgUtil.GARAGE_ICON;
import static util.ImgUtil.loadImg;

import app.App;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Garage;
import util.DataSaver;

public class MainStage extends Stage {
	
	public MainStage(Garage garage) {
		setTitle(App.TITLE);
		getIcons().add(loadImg(GARAGE_ICON));
		setScene(new Scene(new LoginPane(garage), LoginPane.WIDTH, LoginPane.HEIGHT));
		setOnCloseRequest(e -> {
			DataSaver.writeObject(garage, "");
		});
	}
}
