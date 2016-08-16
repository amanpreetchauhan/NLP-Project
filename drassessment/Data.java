package drassessment;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 5, 2016
 * This class is an abstract class that represents any Alphabets or Symbols
 */
@XmlTransient
@XmlSeeAlso({ Alphabets.class, WhiteSpace.class, Punctuation.class, ProperNoun.class })
public abstract class Data {
    String text;
    
}