package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.core.converters.ArffSaver;
import java.io.File;

public class Cluster {

	private static Instances data;
	final static String PATH_CSV_FILE = "/tmp/motes_coordinates.csv";
	final static String PATH_ARFF_FILE = "/tmp/.motes_coordinates.arff";


	public BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;
		try {
			inputReader = new BufferedReader(new FileReader(filename));

		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}
		return inputReader;
	}

	public void loadCSV() throws IOException {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(PATH_CSV_FILE));
		data = loader.getDataSet();
	}

	public void saveARFF() throws IOException {
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(PATH_ARFF_FILE));
		saver.setDestination(new File(PATH_ARFF_FILE));
		saver.writeBatch();
	}

	public ArrayList<ArrayList<String>> convertCSV2Array() throws FileNotFoundException {

		ArrayList<ArrayList<String>> dataFromFile=new ArrayList<ArrayList<String>>();

		try{
			Scanner scanner=new Scanner(new FileReader(PATH_CSV_FILE));
			scanner.useDelimiter(",");

			while(scanner.hasNext())
			{
				String line=scanner.nextLine();
				String []dataLineInArray=line.split(",");
				ArrayList<String> rowDataFromFile=new ArrayList<String>(Arrays.asList(dataLineInArray));
				dataFromFile.add(rowDataFromFile);
			}
			scanner.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		return dataFromFile;
	}

	public void readCSVInsertSeries(Graphic grap) throws FileNotFoundException  {

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		list = convertCSV2Array();

		for (int i=1;i<list.size();i++) {
			grap.setCoordinatesSeries0(Double.parseDouble(list.get(i).get(1)),Double.parseDouble(list.get(i).get(2)));
		}
	}
	
	public void createClusters() throws Exception {
		
		SimpleKMeans kmeans = new SimpleKMeans();
		
		kmeans.setSeed(10);
		kmeans.setPreserveInstancesOrder(true);
		kmeans.setNumClusters(3);

		BufferedReader datafile = readDataFile(PATH_ARFF_FILE);
		Instances data = new Instances(datafile);
		
		kmeans.buildClusterer(data);
		
		int[] assignments = kmeans.getAssignments();

		int i=0;
		for(int clusterNum : assignments) {
			System.out.printf("Instance %d -> Cluster %d \n", i, clusterNum);
			i++;
		}
	}	
}
