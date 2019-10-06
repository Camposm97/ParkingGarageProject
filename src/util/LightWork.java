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

/**
 * Purpose of this class is to provide methods that will be used often throughout the program.  
 * @author Michael Campos
 */
public class LightWork { // Originally named CamposFX
	public static final String GARAGE_SRC = "systemData/garage.dat";
	public static final Insets DEFAULT_INSETS = new Insets(10);
	
	/**
	 * Takes the given date and returns a path utilizing it.  
	 * @param date
	 * @return String
	 */
	public static String emitDailyLog(LocalDate date) {
		return "systemData/log/daily_" + date.getYear() + "_" + date.getMonthValue() + "_" + date.getDayOfMonth() + ".log";
	}
	
	/**
	 * Returns a VBox filled with nodes using the given parameter(s).
	 * @param nodes
	 * @return VBox
	 */
	public static VBox loadVBox(Node...nodes) {
		VBox vBox = new VBox(10);
		for (Node n : nodes)
			vBox.getChildren().add(n);
		return vBox;
	}
	
	/**
	 * Creates a HBox filled with nodes using the given parameter(s).
	 * @param nodes
	 * @return HBox
	 */
	public static HBox loadHBox(Node...nodes) {
		HBox hBox = new HBox(10);
		for (Node n : nodes)
			hBox.getChildren().add(n);
		return hBox;
	}
	
	/**
	 * 
	 * @param gridPane
	 */
	public static void initGridPaneSettings(GridPane gridPane) {
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(DEFAULT_INSETS);
		gridPane.setAlignment(Pos.CENTER);
	}
	
	/**
	 * Returns a Generic ComboBox filled with values by using the given array.
	 * @param <T>
	 * @param arr
	 * @return ComboBox<T>
	 */
	public static <T> ComboBox<T> loadCb(T[] arr) {
		ComboBox<T> cb = new ComboBox<>();
		for (T elem : arr)
			cb.getItems().add(elem);
		return cb;
	}
	
	/**
	 * Returns of a Generic ComboBox filled with values by using the given List.
	 * @param <T>
	 * @param list
	 * @return ComboBox<T>
	 */
	public static <T> ComboBox<T> loadCb(List<T> list) {
		ComboBox<T> cb = new ComboBox<>();
		for (T elem : list)
			cb.getItems().add(elem);
		return cb;
	}
}
