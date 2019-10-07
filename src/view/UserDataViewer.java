package view;

import java.awt.MouseInfo;

import app.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import model.UserData;
import model.UserDataManager;

/**
 * Purpose of this class is to take a collection of users and display them on a
 * table giving admins the ability to disable or give the selected user admin
 * permissions.
 * 
 * @author Michael Campos
 */
public class UserDataViewer extends BorderPane {
	private UserDataManager users;
	private TableView<UserData> tv;

	public UserDataViewer(UserDataManager users) {
		this.users = users;
		initTableView();
		super.setCenter(tv);
	}

	private void initTableView() {
		tv = new TableView<>();
		initTableColumns();
		tv.setOnContextMenuRequested(e -> {
			UserData user = tv.getSelectionModel().getSelectedItem();
			if (user != null)
				showContextMenu();
		});
		tv.setEditable(true); // IMPORTANT FOR EDITING PASSWORDS
		tv.getItems().setAll(users.getUserList());
	}

	public void initTableColumns() {
		final double WIDTH = App.WIDTH;
		final String STYLE = "-fx-alignment: CENTER;";
		TableColumn<UserData, String> colUsername = new TableColumn<>("Username");
		colUsername.setCellValueFactory(new PropertyValueFactory<UserData, String>("userName"));
		colUsername.setPrefWidth(WIDTH * 0.2);
		colUsername.setStyle(STYLE);

		TableColumn<UserData, String> colPassword = new TableColumn<>("Password");
		colPassword.setCellValueFactory(new PropertyValueFactory<UserData, String>("password"));
		colPassword.setCellFactory(TextFieldTableCell.forTableColumn());
		colPassword.setOnEditCommit(e -> {
			UserData user = (UserData) e.getTableView().getItems().get(e.getTablePosition().getRow());
			user.setPassword(e.getNewValue());
		});
		colPassword.setPrefWidth(WIDTH * 0.2);
		colPassword.setStyle(STYLE);

		TableColumn<UserData, String> colFirstName = new TableColumn<>("First Name");
		colFirstName.setCellValueFactory(new PropertyValueFactory<UserData, String>("firstName"));
		colFirstName.setPrefWidth(WIDTH * 0.2);
		colFirstName.setStyle(STYLE);

		TableColumn<UserData, String> colLastName = new TableColumn<>("Last Name");
		colLastName.setCellValueFactory(new PropertyValueFactory<UserData, String>("lastName"));
		colLastName.setPrefWidth(WIDTH * 0.2);
		colLastName.setStyle(STYLE);

		TableColumn<UserData, Boolean> colDisabled = new TableColumn<>("Disabled");
		colDisabled.setCellValueFactory(new PropertyValueFactory<UserData, Boolean>("Disabled"));
		colDisabled.setPrefWidth(WIDTH * 0.1);
		colDisabled.setStyle(STYLE);

		TableColumn<UserData, Boolean> colAdmin = new TableColumn<>("Admin");
		colAdmin.setCellValueFactory(new PropertyValueFactory<UserData, Boolean>("Admin"));
		colAdmin.setPrefWidth(WIDTH * 0.1);
		colAdmin.setStyle(STYLE);
		tv.getColumns().add(colUsername);
		tv.getColumns().add(colPassword);
		tv.getColumns().add(colFirstName);
		tv.getColumns().add(colLastName);
		tv.getColumns().add(colDisabled);
		tv.getColumns().add(colAdmin);
	}

	private void showContextMenu() {
		UserData user = tv.getSelectionModel().getSelectedItem();
		ContextMenu cm = new ContextMenu();
		CheckMenuItem mi1 = new CheckMenuItem("Disable");
		mi1.setSelected(user.isDisabled());
		mi1.setOnAction(new MenuItemHandler(mi1.getText(), mi1.isSelected()));
		CheckMenuItem mi2 = new CheckMenuItem("Admin");
		mi2.setSelected(user.isAdmin());
		mi2.setOnAction(new MenuItemHandler(mi2.getText(), mi2.isSelected()));
		cm.getItems().addAll(mi1, mi2);
		double x = MouseInfo.getPointerInfo().getLocation().getX();
		double y = MouseInfo.getPointerInfo().getLocation().getY();
		cm.show(getScene().getWindow(), x, y);
	}

	private class MenuItemHandler implements EventHandler<ActionEvent> {
		private String command;
		private boolean flag;

		public MenuItemHandler(String command, boolean flag) {
			this.command = command.toUpperCase();
			this.flag = flag;
		}

		@Override
		public void handle(ActionEvent event) {
			UserData user = tv.getSelectionModel().getSelectedItem();
			switch (command) {
			case "DISABLE":
				if (flag)
					user.enableAccount();
				else
					user.closeAccount();
				break;
			case "ADMIN":
				if (flag)
					user.setAdmin(false);
				else
					user.setAdmin(true);
			}
			tv.getItems().setAll(users.getUserList()); // Update TableView Items
		}
	}
}
