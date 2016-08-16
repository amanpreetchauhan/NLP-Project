package drassessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 8, 2016
 * This class is represents all Symbols
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class Punctuation extends Data {
    Punctuation(String t) {
        this.text = t;
    }
}