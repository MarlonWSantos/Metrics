package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;
import java.io.File;

public class Cluster {

	private static Instances data;

	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;

		try {
			inputReader = new BufferedReader(new FileReader(filename));

		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
		return inputReader;
	}

	public static void loadCSV() throws IOException {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("/home/marlon/motes_coordinates.csv"));
		data = loader.getDataSet();
	}

	public static void saveARFF() throws IOException {
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("/tmp/.motes_coordinates.arff"));
		saver.setDestination(new File("/tmp/.motes_coordinates.arff"));
		saver.writeBatch();
	}


	public static void main(String[] args) throws Exception {
		SimpleKMeans kmeans = new SimpleKMeans();
		kmeans.setSeed(10);
		//important parameter to set: preserver order, number of cluster.
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(3);
		
		loadCSV();
		
		saveARFF();
		
		BufferedReader datafile = readDataFile("/tmp/.motes_coordinates.arff");

		Instances data = new Instances(datafile);
		System.out.println(data);
		kmeans.buildClusterer(data);
		// This array returns the cluster number (starting with 0) for each instance
		// The array has as many elements as the number of instances
		int[] assignments = kmeans.getAssignments();

		int i=0;
		for(int clusterNum : assignments) {
			Graphic grap = new Graphic();
			grap.createSerie();
			System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
			/*if(clusterNum == 0) {
				grap.setCoordinatesSeries1(1.1,1.1);
			}
			if(clusterNum == 1) {
				grap.setCoordinatesSeries2(5.5,5.5);
			}
			if(clusterNum == 2) {
				grap.setCoordinatesSeries3(9.5,10.5);
			}
			if(clusterNum == 3) {
				grap.setCoordinatesSeries4(10.1,10.1);
			}
			if(clusterNum == 4) {
				//grap.setCoordinatesSeries5();
			}
			if(clusterNum == 5) {
				//grap.setCoordinatesSeries6();
			}	*/
			i++;
		}
	}
}