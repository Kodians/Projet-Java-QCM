
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
    private JTextArea code;
    
    private int id;



    /**
     * Constructor
     * @param String title 
     * @param TextArea code
     */
    public Question( String title,  JTextArea code) {
        this.title = title;
        this.code = code;
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
    public void setQuestion( String title, JTextArea code) {
        this.title = title;
        this.code = code;
        
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
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

	public JTextArea getCode() {
		return code;
	}

	public void setCode(JTextArea code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}