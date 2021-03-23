
import java.util.*;

import javax.swing.JTextArea;

/**
 * 
 */
public class ConceptQuiz {

    /**
     * Default constructor
     */
    public ConceptQuiz() {
    }

    /**
     * 
     */
    public ArrayList<Question> questions;

    /**
     * 
     */
    public  String title;


    /**
     * 
     */
    public Student Answers;


    /**
     * @param MultipleChoise titre 
     * @return
     */
    public void displayMC( MultipleChoice titre) {
        // TODO implement here
    }

    /**
     * @param TrueFalse titre 
     * @return
     */
    public void displayTrueFalse( TrueFalse titre) {
        // TODO implement here
    }

    /**
     * 
     */
    public ArrayList<Question> randomize(ArrayList<Question>titre) {
    	
        // TODO implement here
    	return null;
    }

    /**
     * @param int correct int total 
     * @return
     */
    public double calculateScore( int correct, int total) {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @param Scanner keyboard 
     * @return
     */
    public void displayResult( Scanner keyboard) {
        // TODO implement here
    }

    /**
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void addQuestion( String titre,  JTextArea code) {
        // TODO implement here
    }

    /**
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void editQuestion( String titre,  JTextArea code) {
        // TODO implement here
    }

    /**
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void removeQuestion( String titre,  JTextArea code) {
        // TODO implement here
    }

}