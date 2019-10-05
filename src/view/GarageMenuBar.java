package view;

import static util.ImgUtil.DELETE_ICON;
import static util.ImgUtil.EXIT_ICON;
import static util.ImgUtil.GITHUB_ICON;
import static util.ImgUtil.HEAVY_WORK;
import static util.ImgUtil.INSERT_ICON;
import static util.ImgUtil.LIGHT_WORK;
import static util.ImgUtil.USER_ICON;
import static util.ImgUtil.WORK_ICON;
import static util.ImgUtil.loadImgV;
import static util.Web.CAMPOS_GITHUB;
import static util.Web.DEMONTE_GITHUB;
import static util.Web.GUIDI_GITHUB;
import static util.Web.browse;

import java.util.LinkedList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pLData.ParkingLot;
import userData.UserData;
import userData.UserDataManager;

public class GarageMenuBar extends MenuBar {
	private UserDataManager users;
	private UserData user;
	private ParkingLot spaces;

	public GarageMenuBar(UserDataManager users, UserData user) {
		this.users = users;
		this.user = user;
		this.spaces = new ParkingLot(80, 10, 10); // Have it equal to an argument (Later);
		this.getMenus().addAll(loadMenus());
	}

	public List<Menu> loadMenus() {
		List<Menu> list = new LinkedList<>();
		list.add(loadMenuFile());
		list.add(loadMenuEdit());
		list.add(loadMenuView());
		list.add(loadMenuHelp());
		return list;
	}

	public Menu loadMenuFile() {
		MenuItem mi1 = new MenuItem("Sign Out");
		mi1.setGraphic(loadImgV(USER_ICON));
		mi1.setOnAction(e -> {
			Scene scene = super.getScene();
			scene.setRoot(new LoginPane(users));
			Stage stage = (Stage) scene.getWindow();
			stage.setWidth(LoginPane.WIDTH);
			stage.setHeight(LoginPane.HEIGHT);
			stage.centerOnScreen();
		});
		MenuItem mi2 = new MenuItem("Exit");
		mi2.setGraphic(loadImgV(EXIT_ICON));
		mi2.setOnAction(e -> {
			// Before exiting, save data (not yet implemented)
			System.out.println("saveObject(src) in " + this.getClass());
			Platform.exit();
		});
		Menu m = new Menu("File");
		m.getItems().addAll(mi1, mi2);
		return m;
	}

	public Menu loadMenuEdit() {
		MenuItem miAddUser = new MenuItem("User");
		miAddUser.setOnAction(e -> {
			BorderPane root = (BorderPane) super.getParent();
			root.setCenter(new InsertUserPane(users));
		});
		MenuItem miAddCar = new MenuItem("Car (Check-In)");
		miAddCar.setOnAction(e -> {
			BorderPane root = (BorderPane) super.getParent();
			root.setCenter(new CheckInPane(spaces));
		});
		MenuItem miDelUser = new MenuItem("User");
		miDelUser.setOnAction(e -> {
			new DeleteUserWindow(users);
		});
		MenuItem miDelCar = new MenuItem("Car (Check-Out)");
		miDelCar.setOnAction(e -> {
			BorderPane root = (BorderPane) super.getParent();
			root.setCenter(new CheckOutPane(spaces));
		});
		Menu menuInsert = new Menu("Insert");
		menuInsert.setGraphic(loadImgV(INSERT_ICON));
		menuInsert.getItems().addAll(miAddUser, miAddCar);
		Menu menuDelete = new Menu("Delete");
		menuDelete.setGraphic(loadImgV(DELETE_ICON));
		if (user.isAdmin())
			menuDelete.getItems().add(miDelUser);
		menuDelete.getItems().add(miDelCar);
		Menu m = new Menu("Edit");
		m.getItems().addAll(menuInsert, menuDelete);
		return m;
	}

	public Menu loadMenuView() {
		MenuItem mi1 = new MenuItem("Daily Ticket Log");
		mi1.setOnAction(e -> {
			BorderPane root = (BorderPane) super.getParent();
			HistoryPane historyPane = new HistoryPane();
			root.setCenter(historyPane.getContainer());
		});
		Menu m = new Menu("View");
		m.getItems().addAll(mi1);
		return m;
	}

	public Menu loadMenuHelp() {
		MenuItem mi1 = new MenuItem("Michael Campos");
		mi1.setOnAction(e -> {
			browse(CAMPOS_GITHUB);
		});
		MenuItem mi2 = new MenuItem("Matthew Guidi");
		mi2.setOnAction(e -> {
			browse(GUIDI_GITHUB);
		});
		MenuItem mi3 = new MenuItem("Chris Demonte");
		mi3.setOnAction(e -> {
			browse(DEMONTE_GITHUB);
		});
		Menu m2 = new Menu("Developer's Github");
		m2.setGraphic(loadImgV(GITHUB_ICON));
		m2.getItems().addAll(mi1, mi2, mi3);

		Menu m1 = new Menu("Help");
		m1.getItems().addAll(m2, loadWorkMenu());
		return m1;
	}

	public Menu loadWorkMenu() {
		MenuItem mi1 = new MenuItem();
		mi1.setGraphic(loadImgV(HEAVY_WORK));
		MenuItem mi2 = new MenuItem();
		mi2.setGraphic(loadImgV(LIGHT_WORK));

		Menu m1 = new Menu("Heavy Work");
		m1.getItems().add(mi1);
		Menu m2 = new Menu("Light Work");
		m2.getItems().add(mi2);
		Menu m = new Menu("Work");
		m.setGraphic(loadImgV(WORK_ICON));
		m.getItems().addAll(m1, m2);
		return m;
	}
}
