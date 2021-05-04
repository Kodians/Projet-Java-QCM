package models;

/**
 * 
 */
public class TrueFalse extends Question {

    private String answer;

    /**
     * Constructor par défault
     */
    public TrueFalse() {
    	this.answer = "";
    }
    
    public TrueFalse(String title, String code, String answer) {
    	super(title,code);
    	this.answer = answer;
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
		// TODO Auto-generated method stub
		return this.answer.equals(answer);
	}

}