package view;

import static util.ImgUtil.GARAGE_ICON;
import static util.ImgUtil.loadImg;

import app.App;
import javafx.scene.Scene;
import javafx.stage.Stage;
import userData.UserDataManager;
import util.DataSaver;

public class MainStage extends Stage {
	
	public MainStage(UserDataManager users) {
		setTitle(App.TITLE);
		getIcons().add(loadImg(GARAGE_ICON));
		setScene(new Scene(new LoginPane(users), LoginPane.WIDTH, LoginPane.HEIGHT));
		setOnCloseRequest(e -> {
//			DataSaver.writeObject(o, "");
			System.out.println("saveObject(src) in " + this.getClass());
		});
	}
}
