package views;
import java.util.Scanner;

import controllers.Profesor;
import controllers.Student;
import models.BaseLangage;

public class QuizManager {
	
    public static void main(String[] argStrings) {
    	Scanner scanner = new Scanner(System.in);
    	
    	BaseLangage baseLangage = new BaseLangage();
    	Profesor profesor = new Profesor(baseLangage);
    	Student student = new Student(baseLangage);
 
    	Menu menu = new Menu(scanner, profesor, student);
    	
    	profesor.setMenu(menu);
    	
    	menu.setMenu();
    }

}