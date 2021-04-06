import java.util.Scanner;

public class QuizManager {
	
    public static void main(String[] argStrings) {
    	Scanner scanner = new Scanner(System.in);
    	
    	BaseLangage baseLangage = new BaseLangage();
    	Profesor profesor = new Profesor(baseLangage);
    	Student student = new Student(baseLangage);
    	
    	initialize(scanner, profesor, student);
    }
    //Methode d'initialisation
    public static void initialize(Scanner scanner, Profesor profesor, Student student) {
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