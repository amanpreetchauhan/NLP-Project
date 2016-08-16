package drassessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 14, 2016
 * This class is represents all meaningful Alphabets
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Alphabets extends Data {
    public Alphabets(String t) {
        this.text = t;
    }
}