package models;

import java.util.*;

/**
 * 
 */
public class TrueFalse extends Question {
	
	/**
     * 
     */
    private String answer;

    /**
     * Constructor par défault
     */
    public TrueFalse() {
    	this.setAnswer("");
    }
    
    public TrueFalse(String title, String code, String answer) {
    	super(title,code);
    	this.answer = answer;
    }

    /**
     * @return
     */
    public ArrayList<String> getAnswers() {
        // TODO implement here
        return null;
    }

    /**
     * tranforme la classe en chaine de caractère
     * @return
     */
    public String toString() {
    	String output = "\n\t" + this.title + "\n\t" + this.code + "\n"
    			+ "\n - Oui \n - NON";		
		return output ;
    }

    /**
     * @return
     */
    public boolean isCorrect() {
        // TODO implement here
        return false;
    }

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

}