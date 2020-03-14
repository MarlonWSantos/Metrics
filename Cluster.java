package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;

public class Cluster {

	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;

		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}

		return inputReader;
	}

	public static void main(String[] args) throws Exception {
		SimpleKMeans kmeans = new SimpleKMeans();
		kmeans.setSeed(10);
		//important parameter to set: preserver order, number of cluster.
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(6);
		BufferedReader datafile = readDataFile("/home/marlon/motes_coordinates.txt");
		Instances data = new Instances(datafile);
		kmeans.buildClusterer(data);
		// This array returns the cluster number (starting with 0) for each instance
		// The array has as many elements as the number of instances
		int[] assignments = kmeans.getAssignments();
		int i=0;
		for(int clusterNum : assignments) {
			System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
			System.out.println(data.toString());
			/*if(clusterNum == 0) {
				setCoordinatesSeries1();
			}
			if(clusterNum == 1) {
				setCoordinatesSeries2();
			}
			if(clusterNum == 2) {
				setCoordinatesSeries3();
			}
			if(clusterNum == 3) {
				setCoordinatesSeries4();
			}
			if(clusterNum == 4) {
				setCoordinatesSeries5();
			}
			if(clusterNum == 5) {
				setCoordinatesSeries6();
			}	*/
			i++;
		}
	}
}