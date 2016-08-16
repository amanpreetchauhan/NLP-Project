package drassessment;

import java.io.PrintStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 14, 2016
 * This class prints XML representation of java class on Stdout
 */
public class XmlRepresentation {
	
	//method to print XML representation of java class on Stdout
    public static void printXml(SentenceHolder sHolder, PrintStream pstream) throws JAXBException {
    	
    	System.out.println("\nPrinting below the XML Representation of the Java Object : \n");
    	//passing an instance of SentenceHolder class
    	JAXBContext jContext = JAXBContext.newInstance(SentenceHolder.class);
    	
        Marshaller marshall = jContext.createMarshaller() ;
        marshall.setProperty( Marshaller.JAXB_SCHEMA_LOCATION,"");
        marshall.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshall.marshal( sHolder,pstream);
    }

}
