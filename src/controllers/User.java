package controllers;

/**
 * @author Danko Konate
 * @author Mamadou Niakaté
 */
public class User {
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected char password;
    protected String role;
    
  
    
    /**
     * Default constructor
     */
    public User() {
    	firstName = "";
    	lastName = "";
    	userName = "";
    	password = '-';
    	role = "";
    }
    
   /**
    * Constructeur avec parametre
    * @param firstName
    * @param lastName
    * @param userName
    * @param password
    * @param role
    */
    public User(String firstName, String lastName, String userName,  char password, String role) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.userName = userName;
    	this.password = password;
    	this.role = role;
    }

    /**
     * Véfifie que l'utilisateur a bien un compte
     * @param userName
     * @param password
     */
    public void login( String userName,  char password) {
        // TODO implement here
    }

    /**
     * Permettre à l'utilisateur à s'inscrire
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     * @param role
     */
    public void register( String firstName,  String lastName,  String userName,  char password,  String role) {
        // TODO implement here
    }

    /**
     * Convertir la classe en chaine de caractère à travers ses attributs
     */
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", role=" + role + "]";
	}
    
    
  
    

}