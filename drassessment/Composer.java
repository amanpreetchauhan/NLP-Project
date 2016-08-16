package drassessment;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * 
 * @author Amanpreet
 * Dated : Aug 14, 2016
 * This class composes all the sentences and underlying tokens 
 */
public class Composer {

	//variable defined to break sentences
    private BreakIterator breakSentence = BreakIterator.getSentenceInstance(Locale.US);

    //variable defined to break tokens
    private BreakIterator breakTokens = BreakIterator.getWordInstance(Locale.US);  

    //function to take string text, break and compose into sentences and return SentenceHolder object
    public SentenceHolder composeSentences(String StringText){
    	
        //set and scan a new String 
        this.breakSentence.setText(StringText);
        
        //index of the first boundary
        int pointer2 = breakSentence.first();
        
        //create an instance of SentenceHolder class
        SentenceHolder sHolder = new SentenceHolder();

        //loop until we reach the last boundary
        while(pointer2 != BreakIterator.DONE){
            
        	//pointer1 should point to first boundary initially
        	int pointer1 = pointer2;
        	
        	//pointer2 should point to next boundary every time we loop
            pointer2 = this.breakSentence.next();

            //if pointer2 has not reached the last boundary
            if (pointer2 != BreakIterator.DONE){
            	
            	//get sentence between two pointers
                String st = StringText.substring(pointer1 ,pointer2);
                
                //function to compose tokens and return object of DataHolder
                DataHolder dHolder = composeTokens(st);
                
                //adding tokens to sentence arraylist
                sHolder.dataList.add(dHolder);
            }
        }
        return sHolder;
    }    

    //function to take sentence, break and compose into tokens and return DataHolder object
    DataHolder composeTokens(String StringText){

    	int pointer1, pointer2;
    	
    	//set and scan a new String 
    	this.breakTokens.setText(StringText);
    	
    	//create an instance of DataHolder class
        DataHolder dHolder = new DataHolder();

        //capturing first and next indexes
        pointer1 = this.breakTokens.first();
        pointer2 = this.breakTokens.next();

        //loop until we reach the last boundary
        while (pointer2 != BreakIterator.DONE) {
        	
        	//get token between two pointers
            String token = StringText.substring(pointer1, pointer2);
            
            //getting first character of each token
            char ch = token.charAt(0);
            
            //checking the first character
            if(Character.isLetterOrDigit(ch))
            {
            	//add new Alphabets object
                dHolder.tokenList.add(new Alphabets(token) );
            } 
            
            else if(ch == ' ') 
            {
            	//add new Symbols object
                dHolder.tokenList.add(new WhiteSpace(token) );
            }
            
            else
            {
            	dHolder.tokenList.add(new Punctuation(token) );
            }
            
            //move pointer1 to next
            pointer1 = pointer2;
            
            //pointer2 should point to next boundary every time we loop
            pointer2 = this.breakTokens.next();
        }
        
        //returning DataHolder instance
        return dHolder;
    }
}
