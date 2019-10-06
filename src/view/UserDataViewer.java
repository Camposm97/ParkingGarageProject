package view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.UserData;
import model.UserDataManager;

public class UserDataViewer extends BorderPane {
	private UserDataManager users;

	public UserDataViewer(UserDataManager users) {
		this.users = users;
		super.setCenter(loadTvUsers());
	}

	public TableView<UserData> loadTvUsers() {
		TableView<UserData> tv = new TableView<>();
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
		tv.getItems().addAll(users.getUserList());
		return tv;
	}
}
