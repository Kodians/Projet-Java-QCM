package controllers;

import java.util.*;

import models.BaseLangage;
import models.ConceptQuiz;
import models.Langage;
import models.Question;

/**
 * 
 */
public class Student extends User {
	private Scanner scanner = new Scanner(System.in);
    private double score;
	
    /**
     * constructeur par défault
     */
    public Student() {
    	this.baseLangage = new BaseLangage();
    }
    
    public Student(String firstName, String lastName, String userName,  char password, String role) {
    	super(firstName,lastName,userName,password,role);
    }
    
    /**
     * Constructeur avec paramètre
     * @param baseLangage
     */
    public Student(BaseLangage baseLangage) {
    	super(baseLangage);
    }

    /**
     * @param int correct int total 
     * @return
     */
    public double calculateScore( int correct, int  total) {
        // TODO implement here
        return 0.0d;
    }
    
    

	/**
	 * retourne le score d'un étudiant
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * modifie le score d'un étudiant
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	};

}