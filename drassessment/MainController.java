package drassessment;

import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBException;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 14, 2016
 * This class is the entry class that contains the main method
 */
public class MainController {

	public static void main(String[] args) throws IOException, JAXBException{
    	
    	String StringText;
    	
    	//taking user input for file path
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter complete path of the nlp_data.txt (input) file :  \n(Example : C:/Users/Amanpreet/nlp_data.txt)");
    	String path = sc.nextLine();
    	
    	//converting text in the file into a single string
    	StringText = FileProcessor.convertToString(path, StandardCharsets.UTF_8);
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
    	
    	
    	sc.close();
    }
	
}