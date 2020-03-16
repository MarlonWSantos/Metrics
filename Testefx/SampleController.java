package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

public class SampleController implements Initializable{
	
	@FXML private ScatterChart<Number, Number> scatterChart;
	
    @FXML
    private NumberAxis xAxis;

    @FXML
    private NumberAxis yAxis;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("estou na itit");

		
		xAxis.setLabel("X axis");
		yAxis.setLabel("Y axis");
		scatterChart.setTitle("Network Density");
		scatterChart.setPrefSize(500, 400);
		
		XYChart.Series<Number, Number> series0 = new XYChart.Series<>();
		series0.setName("Network ");
		series0.getData().add(new XYChart.Data<>(5, 5));
		scatterChart.getData().add(series0);		

		
		

	}
}
