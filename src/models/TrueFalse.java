package models;

/**
 * Classe représentation les questions à réponse vrai ou faux
 * @author Mamadou Niakate
 * @author Danko Konaté
 */
public class TrueFalse extends Question {

	/**
	 * Réponse de la question
	 */
    private String answer;

    /**
     * Constructor par défault
     */
    public TrueFalse() {
    	this.answer = "";
    }
    
    /**
     * Constructeur fixant le titre, le code et la réponse de la question
     * @param title
     * @param code
     * @param answer
     */
    public TrueFalse(String title, String code, String answer) {
    	super(title,code);
    	this.answer = answer;
    }

    /**
     * Tranforme la classe en chaine de caractère grâce à ses attributs
     */
    public String toString() {
    	String output = "\n\t" + this.title + "\n\t" + this.code + "\n"
    			+ "\n - Oui \n - NON";		
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


	/**
	 * Méthode hériter de la classe parent Question véfiant si la réponse passée en paramètre est vraie ou fausse
	 * @param answer
	 */
	public Boolean isCorrect(String answer) {
		return this.answer.equals(answer);
	}

}