package application;

import java.io.FileNotFoundException;
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
	
	private static ScatterChart<Number, Number> scNetwork;
	private static ScatterChart<Number, Number> scActives;
	private static ScatterChart<Number, Number> scCluster;


	public static void main(String[] args) throws IOException {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Network Density");
		
		createGraphicNetwork();
	//	createGraphicMotesActives();
	//	createGraphicClusters();
		
		Scene scene = new Scene(new Group());

		((Group) scene.getRoot()).getChildren().add(scNetwork);
		stage.setScene(scene);
		stage.show();
	}
	
	public void createGraphicNetwork() throws FileNotFoundException {
		final NumberAxis xAxis = new NumberAxis(0, 100, 5);
		final NumberAxis yAxis = new NumberAxis(0, 100, 5);
		scNetwork = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("X axis");
		yAxis.setLabel("Y axis");
		scNetwork.setTitle("Network Density");
		scNetwork.setPrefSize(500, 400);
		
		Graphic graphic = new Graphic();
		Cluster cluster = new Cluster();
		
		graphic.createSerieNetwork();
		
		cluster.readCSVInsertSeries(graphic);
		scNetwork.getData().add(graphic.getCoordinateSeries0());		
	}
	
	public void createGraphicMotesActives() throws FileNotFoundException {
		final NumberAxis xAxis = new NumberAxis(0, 100, 5);
		final NumberAxis yAxis = new NumberAxis(0, 100, 5);
		scActives = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("X axis");
		yAxis.setLabel("Y axis");
		scActives.setTitle("Network Density");
		scActives.setPrefSize(500, 400);
		
		Graphic graphic = new Graphic();
		Cluster cluster = new Cluster();
		
		graphic.createSerieNetwork();
		
		cluster.readCSVInsertSeries(graphic);
		scActives.getData().add(graphic.getCoordinateSeries0());		
	}
	
	public void createGraphicClusters() throws FileNotFoundException {
		final NumberAxis xAxis = new NumberAxis(0, 100, 5);
		final NumberAxis yAxis = new NumberAxis(0, 100, 5);
		scCluster = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("X axis");
		yAxis.setLabel("Y axis");
		scCluster.setTitle("Network Density");
		scCluster.setPrefSize(500, 400);
		
		Graphic graphic = new Graphic();
		Cluster cluster = new Cluster();
		
		graphic.createSerieNetwork();
		
		cluster.readCSVInsertSeries(graphic);
		scCluster.getData().add(graphic.getCoordinateSeries0());		
	}
}
