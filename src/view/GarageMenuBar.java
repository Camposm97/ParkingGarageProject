package view;

import javafx.scene.control.MenuBar;
import util.MenuUtil;

public class GarageMenuBar extends MenuBar {
	
	public GarageMenuBar() {
		this.getMenus().addAll(MenuUtil.loadMenus());
	}
}
