package drassessment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 16, 2016
 * This class is represents all Symbols
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class WhiteSpace extends Data {
    WhiteSpace(String t) {
        this.text = t;
    }
}