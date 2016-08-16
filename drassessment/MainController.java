package drassessment;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 15, 2016
 * This class is the entry class that contains the main method
 */
public class MainController {
	
	public static String location;

	public static void main(String[] args) throws IOException, JAXBException{
    	
    	String path;
    	File[] listOfFiles;
    	final int threads = 1;
    	
    	//taking user input for directory path
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter complete path of the directory containing the extracted files :  \n(Example : C:/Users/Amanpreet/nlp_data)");
    	path = sc.nextLine();
    	
       	//taking user input for NER.txt file path
    	System.out.println("\nPlease enter complete path of the NER.txt file that contains list of named entities:  \n(Example : C:/Users/Amanpreet/NER.txt)");
    	location = sc.nextLine();
    	
    	//getting each file attributes in an array
    	listOfFiles = FileProcessor.getFiles(path);
    	
    	//creating thread pool
    	ExecutorService service = Executors.newFixedThreadPool(threads);
    	
    	//submitting each file to runnable task
        for(File file : listOfFiles){
        	
        	//submit runnable task for each file 
            service.execute(new RunnableTask(file.getAbsolutePath()));
        }

        //shutting down the threadpool
        service.shutdown();

        //closing scanner
    	sc.close();
    }
	
}