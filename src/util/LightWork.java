package util;

import java.time.LocalDate;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LightWork { // Originally named CamposFX
	public static final String GARAGE_SRC = "systemData/garage.dat";
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
	public static String emitDailyLog(LocalDate date) {
		return "systemData/log/daily_" + date.getYear() + "_" + date.getMonthValue() + "_" + date.getDayOfMonth() + ".log";
	}
	
	public static VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		for (Node n : nodes)
			vBox.getChildren().add(n);
		return vBox;
	}
	
	public static HBox loadHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		for (Node n : nodes)
			hBox.getChildren().add(n);
		return hBox;
	}
	
	public static void initGridPaneSettings(GridPane gridPane) {
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(DEFAULT_INSETS);
		gridPane.setAlignment(Pos.CENTER);
	}
	
	public static <T> ComboBox<T> loadCb(T[] arr) {
		ComboBox<T> cb = new ComboBox<>();
		for (T elem : arr)
			cb.getItems().add(elem);
		return cb;
	}
	
	public static <T> ComboBox<T> loadCb(List<T> list) {
		ComboBox<T> cb = new ComboBox<>();
		for (T elem : list)
			cb.getItems().add(elem);
		return cb;
	}
}
