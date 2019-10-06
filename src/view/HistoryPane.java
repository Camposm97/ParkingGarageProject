package view;

import java.io.File;
import java.time.LocalDate;

import history.DailyData;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import util.DataLoader;
import util.LightWork;

public class HistoryPane {
	private VBox container;
	private DatePicker datePicker;
	private TextArea taLog;
	private DailyData dailyData;

	public HistoryPane() {
		this.generateLayout();
		this.loadText(LocalDate.now());
	}

	public HistoryPane(DailyData data) {
		this.generateLayout();
		this.dailyData = data;
		this.taLog.setText(dailyData.toString());
	}

	private void generateLayout() {
		taLog = new TextArea();
		taLog.setEditable(false);
		datePicker = new DatePicker();
		datePicker.setOnAction(e -> {
			this.loadText(this.datePicker.getValue());
		});
		container = LightWork.loadVBox(datePicker, taLog);
		container.setPadding(LightWork.DEFAULT_INSETS);
		container.setAlignment(Pos.CENTER);
	}

	private void loadText(LocalDate date) {
		String src = "resources/daily_" + date.getYear() + "_" + date.getMonthValue() + "_" + date.getDayOfMonth()
				+ ".log";
		File file = new File(src);
		if (file.exists()) {
			DailyData data = (DailyData) DataLoader.readObject(src);
			this.dailyData = data;
			this.taLog.setText(dailyData.toString());
		} else {
			this.taLog.setText("There is no data for this day.");
		}
	}

	public VBox getContainer() {
		return container;
	}

	public TextArea getTaLog() {
		return taLog;
	}
}
