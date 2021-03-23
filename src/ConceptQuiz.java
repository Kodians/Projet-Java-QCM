
import java.util.*;

import javax.swing.JTextArea;

/**
 * @author Mamadou Niakate
 * 
 */
public class ConceptQuiz {
    /**
     * 
     */
    public ArrayList<Question> questions;

    /**
     * 
     */
    public  String title;
    
    private  int id;


    /**
     * 
     */
    public Student Answers;
    
    
    /**
     * Default constructor
     */
    public ConceptQuiz() {
    }
    
    
    public ConceptQuiz(String title) {
    	this.title = title;
    }


    /**
     * Permet d'afficher une question à multiple réponses
     * @param MultipleChoise titre 
     * @return
     */
    public void displayMC( MultipleChoice multipleChoice) {
    	System.out.println(multipleChoice.getTitle());
    	System.out.println(multipleChoice.getCode());
    	
    	System.out.println(multipleChoice.getAnswers());
    }

    /**
     * Permet d'afficher une question à réponse Vrai ou Faux
     * @param TrueFalse questionTrueFalse 
     * @return
     */
    public void displayTrueFalse( TrueFalse questionTrueFalse) {
        System.out.println(questionTrueFalse.getTitle());
        System.out.println(questionTrueFalse.getCode());
        
        System.out.println(questionTrueFalse.getAnswers());
        
        System.out.println("Hello WORLD");
    }

    /**
     * 
     */
    public ArrayList<Question> randomize(ArrayList<Question>titre) {    	
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
        this.questions.add(new Question(titre,code));
    }

    /**
     * Permet d'éditer une question
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void editQuestion(int id,String titre,  JTextArea code) {
    	this.questions.get(id).setQuestion(titre, code);
    }

    /**
     * Supprime la Question dont 'ID est passé en paramètre
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void removeQuestion(int id) {
    	this.questions.remove(this.questions.get(id));
    }


	public ArrayList<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

}