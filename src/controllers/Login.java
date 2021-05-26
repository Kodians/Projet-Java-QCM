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

   
    public String userName;

  
    public char password;


<<<<<<< Updated upstream
    /**
     * Veifie si c'est un etudiant ou prof qui se connecte
     * @param unserName
     * @param password
     * @return
     */
    public Boolean checkLogin( String unserName,  char password) {
        // TODO implement here
        return false;
    }

=======
  
>>>>>>> Stashed changes

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}

}