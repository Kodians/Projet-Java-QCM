package controllers;

import java.util.ArrayList;

/**
 * @author Danko Konate
 * @author Mamadou Niakaté
 */
public class Student extends User {
    private double score;
    private  double totalCorrectAnswer;
    private  double totalAnswer;
    private ArrayList<Score> studentScores = new ArrayList<Score>();

    /**
     * Score {
     * 	resultat = 2 / 5
     * 	source = héritage / Java
     * }
     */
	
    /**
     * constructeur par défault
     */
    public Student(String nom) {
    	this.firstName = nom;
    	score = 0;
    }
    /**
     * constructeur avec parametre 
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param role
     */
    public Student(String firstName, String lastName, String userName,  char password, String role) {
    	super(firstName,lastName,userName,password,role);
    }
    

    /**
     * Calcule le score de l'etudiant
     * @param int correct int total 
     * @return
     */
    public double calculateScore( int correct, int  total) {
        // TODO implement here
        return 0.0d;
    }
    /**
	 * modifie le totalCorrectAnswer & totalAnswer d'un étudiant
	 * @param totalCorrectAnswer
	 * @param totalAnswer
	 */
    public  void setStudentAnswersInfo(double totalCorrectAnswer, double totalAnswer ) {
    	this.totalCorrectAnswer=totalCorrectAnswer;
    	this.totalAnswer=totalAnswer;
    }
    /**
	 * retourne le totalCorrectAnswer/totalAnswer d'un étudiant
	 * @return totalCorrectAnswer/totalAnswer
	 */
    public String getStudentAnswersInfo() {
    	return totalCorrectAnswer + "/" + totalAnswer;
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
	}


	/**
	 * retourne la liste du score d'un étudiant
	 * @return the studentScores
	 */
	public ArrayList<Score> getStudentScores() {
		return studentScores;
	}

	/**
	 * modifie le score d'un étudiant
	 * @param studentScores the studentScores to set
	 */
	public void setStudentScores(ArrayList<Score> studentScores) {
		this.studentScores = studentScores;
	};

}