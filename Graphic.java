package application;

import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

public class Graphic {
	
	private XYChart.Series<Number, Number> series0;
	private XYChart.Series<Number, Number> series1;
	private XYChart.Series<Number, Number> series2;
	private XYChart.Series<Number, Number> series3;
	private XYChart.Series<Number, Number> series4;
	private XYChart.Series<Number, Number> series5;
	private XYChart.Series<Number, Number> series6;

	public void createSerie() {
		series0 = new XYChart.Series<>();
		series1 = new XYChart.Series<>();
		series2 = new XYChart.Series<>();
		series3 = new XYChart.Series<>();
		series4 = new XYChart.Series<>();
		series5 = new XYChart.Series<>();
		series6 = new XYChart.Series<>();

		series0.setName("Cluster 0  ");

		series1.setName("Cluster 1  ");
		series2.setName("Cluster 2  ");
		series3.setName("Cluster 3  ");
		series4.setName("Cluster 4  ");
		series5.setName("Cluster 5  ");
		series6.setName("Cluster 6  ");


	}
	
	public void setCoordinatesSeries0(double X,double Y) {
		series0.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public void setCoordinatesSeries1(double X,double Y) {
		series1.getData().add(new XYChart.Data<>(X, Y));
	}

	public void setCoordinatesSeries2(double X,double Y) {
		series2.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public void setCoordinatesSeries3(double X,double Y) {
		series3.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public void setCoordinatesSeries4(double X,double Y) {
		series4.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public void setCoordinatesSeries5(double X,double Y) {
		series5.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public void setCoordinatesSeries6(double X,double Y) {
		series6.getData().add(new XYChart.Data<>(X, Y));
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries0() {
		return this.series0;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries1() {
		return this.series1;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries2() {
		return this.series2;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries3() {
		return this.series3;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries4() {
		return this.series4;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries5() {
		return this.series5;
	}
	
	public XYChart.Series<Number, Number> getCoordinateSeries6() {
		return this.series6;
	}
}
