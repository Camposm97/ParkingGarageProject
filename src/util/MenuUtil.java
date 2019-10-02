package util;

import static util.Web.*;
import static util.ImgUtil.*;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class MenuUtil {
	public static List<Menu> loadMenus() {
		List<Menu> list = new LinkedList<>();
		list.add(loadMenuFile());
		list.add(loadMenuEdit());
		list.add(loadMenuHelp());
		return list;
	}
	
	public static Menu loadMenuFile() {
		MenuItem mi = new MenuItem("Exit");
		mi.setGraphic(loadImgV(EXIT_ICON));
		mi.setOnAction(e -> {
			// Before exiting, save data (not yet implemented)
			Platform.exit();
		});
		Menu m = new Menu("File");
		m.getItems().add(mi);
		return m;
	}
	
	public static Menu loadMenuEdit() {
		MenuItem miUser = new MenuItem("User");
		MenuItem miCar = new MenuItem("Car");
		Menu mInsert = new Menu("Insert");
		mInsert.getItems().addAll(miUser, miCar);
		Menu mDelete = new Menu("Delete");
		mDelete.getItems().addAll(miUser, miCar);
		Menu m = new Menu("Edit");
		m.getItems().addAll(mInsert, mDelete);
		return m;
	}
	
	public static Menu loadMenuHelp() { // Not Finished
		MenuItem mi1 = new MenuItem("Michael Campos");
		mi1.setOnAction(e -> { browse(CAMPOS_GITHUB); });
		MenuItem mi2 = new MenuItem("Matthew Guidi");
		mi2.setOnAction(e -> { browse(GUIDI_GITHUB); });
		MenuItem mi3 = new MenuItem("Chris Demonte");
		mi3.setOnAction(e -> { browse(DEMONTE_GITHUB); });
		Menu m2 = new Menu("Developer's Github");
		m2.setGraphic(loadImgV(GITHUB_ICON));
		m2.getItems().addAll(mi1, mi2, mi3);
		Menu m1 = new Menu("Help");
		m1.getItems().add(m2);
		return m1;
	}
}	
