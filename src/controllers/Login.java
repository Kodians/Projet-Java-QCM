package controllers;


/**
 * @author Danko Konate
 * @author Mamadou Niakaté
 */
public class Login {

    /**
     * Default constructor
     */
    public Login() {
    }

    /**
     * 
     */
    public String userName;

    /**
     * 
     */
    public char password;


    /**
     * Veifie si c'est un etudiant ou prof qui se connecte 
     * @param String unserName 
     * @param chaer password 
     * @return Boolean
     */
    public boolean checkLogin( String unserName,  char password) {
        // TODO implement here
        return false;
    }


	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}

}