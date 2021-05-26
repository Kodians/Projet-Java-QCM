package models;

import java.util.*;

/**
 * 
 */
public class Numeric extends Question {

	private String answer;
    /**
     * Default constructor
     */
    public Numeric() {
    	this.setAnswer("");
    }


    /**
     * @param String titre 
     * @param int answer
     */
    public Numeric(String title, String code,String answer) {
        super(title,code);
        this.answer = answer;
    }


    /**
     * @return
     */
    public String toString() {
    	String output = "\n\t" + this.title + "\n\t" + this.code + "\n";

		return output ;
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
	


	@Override
	public Boolean isCorrect(String answer) {
		return this.answer.equals(answer);
	}

}