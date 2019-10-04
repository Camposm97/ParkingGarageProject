package util;

import static util.ImgUtil.*;
import static util.Web.CAMPOS_GITHUB;
import static util.Web.DEMONTE_GITHUB;
import static util.Web.GUIDI_GITHUB;
import static util.Web.browse;

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
		MenuItem mi1 = new MenuItem("Sign Out");
		mi1.setOnAction(e -> {
			System.out.println("Not Yet Implemented");
		});
		MenuItem mi2 = new MenuItem("Exit");
		mi2.setGraphic(loadImgV(EXIT_ICON));
		mi2.setOnAction(e -> {
			// Before exiting, save data (not yet implemented)
			Platform.exit();
		});
		Menu m = new Menu("File");
		m.getItems().addAll(mi1, mi2);
		return m;
	}
	
	public static Menu loadMenuEdit() {
		MenuItem miAddUser = new MenuItem("User");
		MenuItem miAddCar = new MenuItem("Car");
		MenuItem miDelUser = new MenuItem("User");
		Menu menuInsert = new Menu("Insert");
		menuInsert.setGraphic(loadImgV(INSERT_ICON));
		menuInsert.getItems().addAll(miAddUser, miAddCar);
		Menu menuDelete = new Menu("Delete");
		menuDelete.setGraphic(loadImgV(DELETE_ICON));
		menuDelete.getItems().addAll(miDelUser);
		Menu m = new Menu("Edit");
		m.getItems().addAll(menuInsert, menuDelete);
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
		m1.getItems().addAll(m2, loadWorkMenu());
		return m1;
	}
	public static Menu loadWorkMenu() {
		MenuItem mi1 = new MenuItem();
		mi1.setGraphic(loadImgV(HEAVY_WORK));
		MenuItem mi2 = new MenuItem();
		mi2.setGraphic(loadImgV(LIGHT_WORK));
		
		Menu m1 = new Menu("Heavy Work");
		m1.getItems().add(mi1);
		Menu m2 = new Menu("Light Work");
		m2.getItems().add(mi2);
		Menu m = new Menu("Work");
		m.getItems().addAll(m1, m2);
		return m;
	}
}	
