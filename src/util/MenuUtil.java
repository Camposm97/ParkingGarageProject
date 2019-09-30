package util;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Menu;

public class MenuUtil {
	public static List<Menu> loadMenus() {
		List<Menu> list = new ArrayList<>();
		Menu m1 = new Menu("File");
		Menu m2 = new Menu("Edit");
		Menu m3 = new Menu("Help");
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}
}	
