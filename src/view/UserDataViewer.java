package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.UserData;
import model.UserDataManager;

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
			ContextMenu cm = new ContextMenu();
			MenuItem mi1 = new MenuItem("Enable User");
			mi1.setOnAction(new ContextMenuHandler());
			MenuItem mi2 = new MenuItem("Disable User");
			mi2.setOnAction(new ContextMenuHandler());
			MenuItem mi3 = new MenuItem("Enable Admin Powers");
			mi3.setOnAction(new ContextMenuHandler());
			MenuItem mi4 = new MenuItem("Disable Admin Powers");
			mi4.setOnAction(new ContextMenuHandler());
			cm.getItems().addAll(mi1, mi2, mi3, mi4);
			cm.show(this.getScene().getWindow());
		});
		tv.getItems().addAll(users.getUserList());
	}
	
	private void initTableColumns() {
		TableColumn<UserData, String> colUsername = new TableColumn<>("Username");
		colUsername.setCellValueFactory(new PropertyValueFactory<UserData, String>("userName"));
		TableColumn<UserData, String> colPassword = new TableColumn<>("Password");
		colPassword.setCellValueFactory(new PropertyValueFactory<UserData, String>("password"));
		TableColumn<UserData, String> colFirstName = new TableColumn<>("First Name");
		colFirstName.setCellValueFactory(new PropertyValueFactory<UserData, String>("firstName"));
		TableColumn<UserData, String> colLastName = new TableColumn<>("Last Name");
		colLastName.setCellValueFactory(new PropertyValueFactory<UserData, String>("lastName"));
		TableColumn<UserData, Boolean> colDisabled = new TableColumn<>("Disabled");
		colDisabled.setCellValueFactory(new PropertyValueFactory<UserData, Boolean>("Disabled"));
		TableColumn<UserData, Boolean> colAdmin = new TableColumn<>("Admin");
		colAdmin.setCellValueFactory(new PropertyValueFactory<UserData, Boolean>("Admin"));
		tv.getColumns().add(colUsername);
		tv.getColumns().add(colPassword);
		tv.getColumns().add(colFirstName);
		tv.getColumns().add(colLastName);
		tv.getColumns().add(colDisabled);
		tv.getColumns().add(colAdmin);
		
	}
	
	private class ContextMenuHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			UserData user = tv.getSelectionModel().getSelectedItem();
			if (user != null) {
				
			}
		}
		
	}
}
