
import java.util.*;

import javax.swing.JTextArea;

/**
 * 
 */
public class Question {

    /**
     * Default constructor
     */
    public Question() {
    }
     

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String code;
    
    private int id;



    /**
     * Constructor
     * @param String title 
     * @param TextArea code
     */
    public Question( String title,  String code, int id) {
        this.title = title;
        this.code = code;
        this.id=id;
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
	public ArrayList<String> getAnswers(){
		return null;
	}
}