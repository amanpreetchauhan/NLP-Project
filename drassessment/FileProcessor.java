package drassessment;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 
 * @author Amanpreet
 * Dated: Aug 14, 2016
 * This class is used to process text in a file and convert it into a single string
 */
public class FileProcessor{
	
	//function to convert text in a file in a string
    public static String convertToString(String path, Charset code) throws IOException{
    		  byte[] encode = Files.readAllBytes(Paths.get(path));
    		  return new String(encode, code);
    		}
}
