package models;

import java.util.*;
import controllers.Student;

/**
 * @author Mamadou Niakate
 * 
 */
public class ConceptQuiz {
	private static int count;
	
    /**
     * 
     */
    public ArrayList<Question> questions= new ArrayList<>();

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
    	this.questions = null;
    	this.title = "";
    }
    
    public ConceptQuiz(String title) {
    	this.title = title;
    	this.id= ++count;
    }

    /**
     * Melange / désordonne les éléments d'une liste
     * @return
     */
    public ArrayList<Question> randomize(ArrayList<Question> questions) { 
    	Collections.shuffle(questions);
    	
    	return questions;
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
     * Ajotuer une question à la liste des questions d'un ConceptQuiz
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void addQuestion( Question q) {
        this.questions.add(q);
    }

    /**
     * Permet d'éditer une question
     * @param String titre 
     * @param TextArea code 
     * @return
     */
    public void editQuestion(int id,String titre,  String code) {
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


    /**
     * Retourne la listes des questions d'un conceptQuiz
     * @return
     */
	public ArrayList<Question> getQuestions() {
		ArrayList<Question> questionsRandomized = questions;
		Collections.shuffle(questionsRandomized);
		return questionsRandomized;
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


	@Override
	public String toString() {
		return this.getTitle();
	}

}