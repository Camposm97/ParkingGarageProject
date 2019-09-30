package util;

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
		mi.setOnAction(e -> {
			// Before exiting, save data (not yet implemented)
			Platform.exit();
		});
		Menu menu = new Menu("File");
		menu.getItems().add(mi);
		return menu;
	}
	
	public static Menu loadMenuEdit() {
		Menu menu = new Menu("Edit");
		return menu;
	}
	
	public static Menu loadMenuHelp() {
		Menu menu = new Menu("Help");
		return menu;
	}
}	
