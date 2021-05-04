package controllers;

/**
 * 
 */
public class Student extends User {
    private double score;
    
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
    
    public Student(String firstName, String lastName, String userName,  char password, String role) {
    	super(firstName,lastName,userName,password,role);
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