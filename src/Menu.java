import java.util.Scanner;

public class Menu {
	private Scanner scanner;
	private Profesor profesor;
	private Student student;
	
	/**
	 * Constructeur par défaut de la classe Menu
	 */
	public Menu() {
		profesor = null;
		student = null;
	}
	
	/**
	 * Constructeur avec paramètre de la classe Menu
	 * @param scanner
	 * @param profesor
	 * @param student
	 */
	public Menu(Scanner scanner, Profesor profesor, Student student) {
		this.scanner = scanner;
		this.profesor = profesor;
		this.student = student;
	}
	
	/**
	 * Permet de rédiriger l'utilisateur selon son rôle
	 */
	public void setMenu() {
    	System.out.println("======== Menu ========\n");

		System.out.println("1. Vous êtes Professeur");
		System.out.println("2. Vous êtes Étudiant");
		
		System.out.print("Choisissez votre type : ");
		
		int userType = scanner.nextInt();
				
		while (userType == 1 || userType == 2 ) {
			switch (userType) {
				case 1: profesor.adminActions(); break;
				case 2: student.studentActions(); break;
				default: break;
			}
			userType = scanner.nextInt();
		} 
		
		scanner.close();
    }
}
