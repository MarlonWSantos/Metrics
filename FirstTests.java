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
		stage.setTitle("Network Density");
		final NumberAxis xAxis = new NumberAxis(0, 100, 5);
		final NumberAxis yAxis = new NumberAxis(0, 100, 5);
		ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("X axis");
		yAxis.setLabel("Y axis");
		sc.setTitle("Network Density");
		sc.setPrefSize(500, 400);
		Scene scene = new Scene(new Group());

		Graphic graphic = new Graphic();
		Cluster cluster = new Cluster();
		
		graphic.createSerie();
		
		cluster.readCSVInsertSeries(graphic);
		
		sc.getData().add(graphic.getCoordinateSeries0());
		sc.getData().add(graphic.getCoordinateSeries1());
		sc.getData().add(graphic.getCoordinateSeries2());
		sc.getData().add(graphic.getCoordinateSeries3());
		sc.getData().add(graphic.getCoordinateSeries4());
		sc.getData().add(graphic.getCoordinateSeries5());
		sc.getData().add(graphic.getCoordinateSeries6());

		((Group) scene.getRoot()).getChildren().add(sc);
		stage.setScene(scene);
		stage.show();



	}
}
