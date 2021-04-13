import java.util.Scanner;

/**
 * 
 */
public class User {
    private String firstName;
    public String lastName;
    public String userName;
    public char password;
    public String role;
    
	//protected BaseLangage baseLangage = null;
	//protected Scanner scanner = new Scanner(System.in);

    
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
    
    public User(String firstName, String lastName, String userName,  char password, String role) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.userName = userName;
    	this.password = password;
    	this.role = role;
    }

    /**
     * @param String userName 
     * @param char password
     */
    public void login( String userName,  char password) {
        // TODO implement here
    }

    /**
     * @param String firstName 
     * @param String lastName 
     * @param String userName 
     * @param char password 
     * @param String role
     */
    public void register( String firstName,  String lastName,  String userName,  char password,  String role) {
        // TODO implement here
    }
    

}