package drassessment;

import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 15, 2016
 * This class contains the definition for runnable task
 */
public class RunnableTask implements Runnable{

	//variable to store path of file
	private String path;
	
	//constructor to initialize class
	public RunnableTask(String path) {
		// TODO Auto-generated constructor stub
		this.path = path; 
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		
		try{
	    	//converting text in the file into a single string
	    	String StringText = FileProcessor.convertToString(path, StandardCharsets.UTF_8);
	    	//System.out.println(StringText);
	    	
	    	// create instance of main class
	    	Composer composer = new Composer();
	    	
	    	//function to read file for proper nouns and store them in hashset
	    	Set<String> hSet = ProperNounPrinter.storeNouns();
	    	
	    	//printing the list of proper nouns occurring in text file
	    	ProperNounPrinter.printNouns(hSet, StringText);
	    	
	    	//function to compose sentences and return object of SentenceHolder
	    	SentenceHolder sHolder = composer.composeSentences(StringText, hSet);
	    	
	    	//printing XML representation of the java object
	    	XmlRepresentation.printXml(sHolder, System.out);	    	
		}
		catch(Exception e) {
            System.out.println(e);
        }

	}

}
