package models;


/**
 * 
 */
public class Numeric extends Question {

	/**
	 * Réponse de la question
	 */
	private String answer;
	
	
    /**
     * Constructeur par défaut
     */
    public Numeric() {
    	this.setAnswer("");
    }


    /**
     * Constructeur fixant le titre, le code et la réponse de la question
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
	 * Retourne la réponse de la question
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}


	/**
	 * Fixe la réponse de la question
	 * @param answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	


	@Override
	public Boolean isCorrect(String answer) {
		return this.answer.equals(answer);
	}

}