package drassessment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 8, 2016
 * This class holds list of tokens
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataHolder{
    @XmlElement(name = "data")
    
    List<Data> tokenList = new ArrayList<Data>();

}