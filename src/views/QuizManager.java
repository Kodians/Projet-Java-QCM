package views;
import java.util.Scanner;

import controllers.Profesor;
import controllers.Student;
import models.BaseLangage;

/**
 * CLASSE MAIN DE L'APPLICATION
 */
public class QuizManager {
	
    public static void main(String[] argStrings) {
    	Scanner scanner = new Scanner(System.in);
    	
    	BaseLangage baseLangage = new BaseLangage();
    	Profesor profesor = new Profesor("Danko");
    	Student student = new Student("Mamadou");
 
    	Menu menu = new Menu(scanner, profesor, student ,baseLangage);
    	    	
    	menu.setMenu();
    }

}