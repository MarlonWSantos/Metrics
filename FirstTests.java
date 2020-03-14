package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstTests extends Application {

	public static void main(String[] args) throws IOException {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Scatter Chart Sample");
		final NumberAxis xAxis = new NumberAxis(0, 10, 1);
		final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
		ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("Age (years)");
		yAxis.setLabel("Returns to date");
		sc.setTitle("Investment Overview");
		sc.setPrefSize(500, 400);
		Scene scene = new Scene(new Group());

		//Graphic graphic = new Graphic();
		//graphic.createSerie();
		//graphic.setCoordinatesSeries1(5.5,5.5);
		//sc.getData().addAll(graphic.getCoordinateSeries1());
		/*sc.getData().add(graphic.getCoordinateSeries2());
		sc.getData().add(graphic.getCoordinateSeries3());
		sc.getData().add(graphic.getCoordinateSeries4());
		sc.getData().add(graphic.getCoordinateSeries5());
		sc.getData().add(graphic.getCoordinateSeries6());*/

		XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
		XYChart.Series<Number, Number> series2 = new XYChart.Series<>();


		series1.setName("Cluster 1");
		series2.setName("Cluster 2");

		series1.getData().add(new XYChart.Data<>(4.2, 193.2));
		series2.getData().add(new XYChart.Data<>(2.8, 33.6));
		series1.getData().add(new XYChart.Data<>(6.2, 24.8));
		series2.getData().add(new XYChart.Data<>(1, 14));
		series1.getData().add(new XYChart.Data<>(1.2, 26.4));
		series2.getData().add(new XYChart.Data<>(4.4, 114.4));
		series1.getData().add(new XYChart.Data<>(8.5, 323));
		series2.getData().add(new XYChart.Data<>(6.9, 289.8));
		series1.getData().add(new XYChart.Data<>(9.9, 287.1));
		series2.getData().add(new XYChart.Data<>(0.9, -9));
		series1.getData().add(new XYChart.Data<>(3.2, 150.8));
		series2.getData().add(new XYChart.Data<>(4.8, 20.8));
		series1.getData().add(new XYChart.Data<>(7.3, -42.3));
		series2.getData().add(new XYChart.Data<>(1.8, 81.4));
		series1.getData().add(new XYChart.Data<>(7.3, 110.3));
		series2.getData().add(new XYChart.Data<>(2.7, 41.2));

		sc.getData().addAll(series1,series2);

		((Group) scene.getRoot()).getChildren().add(sc);
		stage.setScene(scene);
		stage.show();



	}
}
