package drassessment;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 16, 2016
 * This class holds list of sentences
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SentenceHolder {

    @XmlElement(name = "sentence")
    public List<DataHolder> dataList = new ArrayList<DataHolder>();

}