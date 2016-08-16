package drassessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Amanpreet
 * Dated: Aug 15, 2016
 * This class prints the proper nouns that occur in a file
 */
public class ProperNounPrinter {

	//function to store proper nouns in hashset
	public static Set<String> storeNouns()throws IOException {
		// TODO Auto-generated method stub
		
		String ln;
		
		//create a hashset to store nouns
		Set<String> set = new HashSet<String>();
		
	   	//taking user input for file path
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nPlease enter complete path of the NER.txt file that contains list of named entities:  \n(Example : C:/Users/Amanpreet/NER.txt)");
    	String path = sc.nextLine();
 
		
		//create instance of buffered reader
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		//loop until end of file
		while((ln = br.readLine() )!= null){
		
			//adding every noun to hashset
			set.add(ln.trim());
		}

		    return set;
	}
	

	//function to print proper nouns
	public static void printNouns(Set<String> hSet, String text){
		
		System.out.println("\nPrinting below the list of recognized proper nouns that are present in file :");
		
		//checking for every string in hashset if it is present in String text( in file) 
		for(String str : hSet){
			if(isThere(text,str)){
				System.out.println(str);
			}
		}
	}
	
	//function to check if one string contains other exactly
	public static boolean isThere(String text, String str) {
		  
		  //defining a pattern
		  String pattern = "\\b"+str+"\\b";
		  
		  Pattern p=Pattern.compile(pattern);
		  Matcher m=p.matcher(text);
		  
		  return m.find();
	  }
	
	
}
