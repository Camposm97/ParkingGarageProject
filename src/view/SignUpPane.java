package view;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import static util.LightWork.DEFAULT_INSETS;

/**
 * For adding users to the Account Data Structure
 * @author Camposm97
 */
public class SignUpPane extends GridPane {
	private TextField tfFirstname, tfLastname;
	
	public SignUpPane() {
		initControls();
		showControls();
	}
	
	private void initControls() {
		tfFirstname = new TextField();
		tfLastname = new TextField();
	}
	
	private void showControls() {
		setAlignment(Pos.CENTER);
		setPadding(DEFAULT_INSETS);
	}
}
