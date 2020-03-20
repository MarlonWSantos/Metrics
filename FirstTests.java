package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstTests extends Application {
	
	private static ScatterChart<Number, Number> scNetwork;
	protected static ScatterChart<Number,Number> sc;

	public static void main(String[] args) throws IOException {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Scatter Chart Sample");
		final NumberAxis xAxis = new NumberAxis(0, 99, 1);
		final NumberAxis yAxis = new NumberAxis(0, 99, 100);
		sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		xAxis.setLabel("Age (years)");
		yAxis.setLabel("Returns to date");
		sc.setTitle("Investment Overview");
		sc.setPrefSize(500, 400);
		Scene scene = new Scene(new Group());
		
		new ThreadCluster(this);
			
		((Group) scene.getRoot()).getChildren().add(sc);
		stage.setScene(scene);
		stage.show();
	}
	
	public void LoadGraphic() {
		
        if (!sc.getData().isEmpty()) {
            sc.getData().remove(0,sc.getData().size());
        }
		sc.getData().add(Cluster.graphic.getCoordinateSeries1());
		sc.getData().add(Cluster.graphic.getCoordinateSeries2());
		sc.getData().add(Cluster.graphic.getCoordinateSeries3());
		sc.getData().add(Cluster.graphic.getCoordinateSeries4());
		sc.getData().add(Cluster.graphic.getCoordinateSeries5());
		sc.getData().add(Cluster.graphic.getCoordinateSeries6());				
	}
}
