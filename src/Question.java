
import java.util.*;

import javax.swing.JTextArea;

/**
 * 
 */
public abstract class Question {
	private static int count;

    /**
    public Question() {
     * 
     */
    protected String title;
    protected String code;
    protected int id;

    
    /**
     * Default constructor
     */
    public Question() {
    }

 
    /**
     * Constructor
     * @param String title 
     * @param TextArea code
     */
    public Question( String title,  String code) {
        this.title = title;
        this.code = code;
        this.id= ++count;
    }

    /**
     * @return
     */
    public String[] getQuestion() {
        // TODO implement here
        return null;
    }

    /**
     * @param titre 
     * @param code 
     * @return
     */
    public void setQuestion( String title, String code) {
        this.title = title;
        this.code = code;
        
    }

   
    /**
     * @return
     */
    public boolean isCorrect() {
        // TODO implement here
        return false;
    }

    
    /******************** SETTERS & GETTERS *****/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return this.title;
		
	}
	
	/**
	 * Méthode abtraite permettant de retourner les réponse à une question
	 * @return
	 */
	public abstract ArrayList<String> getAnswers();
}