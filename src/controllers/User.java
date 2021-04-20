package controllers;
import java.util.ArrayList;
import java.util.Scanner;

import models.BaseLangage;
import models.ConceptQuiz;
import models.Langage;

/**
 * 
 */
public class User {
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected char password;
    protected String role;
    
    private Scanner scanner = new Scanner(System.in);
	protected BaseLangage baseLangage = null;
    
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
    
    public User(BaseLangage baseLangage) {
    	this.baseLangage = baseLangage;
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
    
    
    /**
     * Affiche la liste des langages créés par le Professeur
     * Choisir un langage donné
     * @return void
     */
    protected Langage chooseLangageFromLangageCollection() {
    	 ArrayList<Langage> langages = baseLangage.getLangages(); 
    	 for (Langage langage : langages) {
			if (langage != null) {
				System.out.println(langages.indexOf(langage) + ". Pour ---> " + langage);
			}
		 }
    	 System.out.print("Entrez le numero du langage de votre choix : ");
    	 int choice = scanner.nextInt();
    	 Langage langage = baseLangage.getLangages().get(choice);
    	 return langage;
    }
    
    /**
     * Affiche la liste des concpets créés par le Professeur pour un langage
     * Choisir un concept donné
     * @param chosenLangage
     * @return
     */
    protected ConceptQuiz chooseConceptQuizFromConceptQuizCollections(Langage chosenLangage) {    	
    	for(ConceptQuiz cq : chosenLangage.getConceptQuiz()) {
			if(cq != null) {
				System.out.println(cq.getId() + " --> Pour " + cq.getTitle());
			}
		}
		
		System.out.print("Entrez votre choix de Concept : ");
		int langConceptID = scanner.nextInt();
		
		ConceptQuiz chosenConceptQuiz = null;
							
		for(ConceptQuiz conceptQuiz : chosenLangage.getConceptQuiz()) {
			if(conceptQuiz.getId() == langConceptID) {
				chosenConceptQuiz = conceptQuiz;
			}
		}
		
		return chosenConceptQuiz;
    }
    

}