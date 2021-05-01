package views;
import java.util.ArrayList;
import java.util.Scanner;

import controllers.Profesor;
import controllers.Student;
import models.BaseLangage;
import models.ConceptQuiz;
import models.Langage;
import models.MultipleChoice;
import models.Numeric;
import models.TrueFalse;

public class Menu {
	private Scanner scanner;
	private Profesor profesor;
	private Student student;
	private BaseLangage baseLangage;
	
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
	public Menu(Scanner scanner, Profesor profesor, Student student,BaseLangage baseLangage ) {
		this.scanner = scanner;
		this.profesor = profesor;
		this.student = student;
		this.baseLangage = baseLangage;
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
				case 1: adminActions(); break;
				case 2: student.studentActions(); break;
				default: break;
			}
			userType = scanner.nextInt();
		} 
		
		scanner.close();
    }
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	public void adminActions() {		
		System.out.println("\n======================================\n"
				+ "1. Ajouter un langage \n\n"
				+ "0. Modifier un langage \n\n"
				+ "2. Créer une question\n\n"
				+ "3. Revenir au Menu \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3 || choice == 0) {
			switch (choice) {
				case 1: createLangageAndConcepts(); break;
				case 2: createQuestionForLangageConcept();break;
				case 0: 
					Langage langageToEdit= profesor.chooseLangageFromLangageCollection();
					editLangage(langageToEdit);
					break;
				case 3: setMenu(); break;
				default: break;
			}
			
			System.out.println("\n======================================\n"
					+ "1. Ajouter un langage \n\n"
					+ "0. Modifier un langage \n\n"
					+ "2. Créer une question\n\n"
					+ "3. Revenir au Menu\n\n"
					+ "N'importe quel autre chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
		
		System.out.println("\n\n************OPÉRATION TERMINÉ*************\n\n");
	}
	
	public void editLangage(Langage langage) {	
		System.out.println("\n=============="+ langage +"========================\n"
				+ "1. Modifier le nom du langage \n\n"
				+ "2. Supprimer le langage \n\n"
				+ "3. Ajouter des concepts \n\n"
				+ "4. Modifier un concept \n\n"
				+ "5. RETOURNER AU MENU \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 ) {
			switch (choice) {
				case 1 : 
					scanner.nextLine();
					System.out.print("Entrez le nouveau le nom du langage : ");
					String name = scanner.nextLine();
					langage.setName(name);
					break;
				case 2 : profesor.deleteLangage(baseLangage,langage); break;
				case 3 : scanner.nextLine(); addConcept(langage);break;
				case 4 : editConcept(langage); break;
				case 5 : setMenu(); break;
				default: break;
			}
			
			System.out.println("\n=============="+ langage +"========================\n"
					+ "1. Modifier le nom du langage \n\n"
					+ "2. Supprimer le langage \n\n"
					+ "3. Ajouter des concepts \n\n"
					+ "4. Modifier un concept \n\n"
					+ "5. RETOURNER AU MENU \n\n"
					+ "N'importe quel chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
		
		System.out.println("\n\n************OPÉRATION TERMINÉ*************\n\n");
	}
	
	public void editConcept(Langage langage) {
		ConceptQuiz chosenConceptQuiz = profesor.chooseConceptQuizFromConceptQuizCollections(langage);
		System.out.println("\n=============="+ chosenConceptQuiz +"========================\n"
				+ "1. Modifier le titre du concept \n\n"
				+ "2. Supprimer le concept \n\n"
				+ "3. Ajouter des questions \n\n"
				+ "4. Modifier des questions \n\n"
				+ "5. RETOURNER AU MENU \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5) {
			switch (choice) {
				case 1 : 
					scanner.nextLine();
					System.out.print("Entrez le nouveau le titre du concept : ");
					String title = scanner.nextLine();
					chosenConceptQuiz.setTitle(title);
					break;
				case 2 : profesor.deleteConceptFromLangage(langage,chosenConceptQuiz); break;
				//case 3 : scanner.nextLine(); addConcept(langage);break;
				//case 4 : editConcept(langage); break;
				case 5 : setMenu(); break;
				default: break;
			}
			
			System.out.println("\n=============="+ chosenConceptQuiz +"========================\n"
					+ "1. Modifier le titre du concept \n\n"
					+ "2. Supprimer le concept \n\n"
					+ "3. Ajouter des questions \n\n"
					+ "4. Modifier des questions \n\n"
					+ "5. RETOURNER AU MENU \n\n"
					+ "N'importe quel chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
		
		System.out.println("\n\n************OPÉRATION TERMINÉ*************\n\n");
	}
	
	 public void createLangageAndConcepts() {
	    	System.out.print("Entrez le nom d'un langage : ");
			scanner.nextLine();
			String newLangage = scanner.nextLine();
					
			if(!newLangage.equals("")) {
				Langage langage = new Langage(newLangage);
				profesor.addLang(baseLangage,langage);
				
				/** vérifier que notre langage à bien été ajouté à notre collection de langage*/
				if(profesor.getLangagesList().get(langage.getId()) != null) {
					addConcept(langage);
					System.out.println("Entrer un concept de " + langage.getName() + " ou clique sur 'Entrez' pour finir");
					
					String langageConcept = scanner.nextLine();
					
					while (!langageConcept.equals("")) {
						ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
						langage.addConceptQuiz(newConceptQuiz);
						
						System.out.println("Entrer un concept de " + langage.getName() +  " ou cliquez sur 'Entrer' pour finir");
						
						langageConcept = scanner.nextLine();
					}
				}
			}
	    }
	 
	 public void addConcept(Langage langage) {
	    	System.out.println("Entrer un concept de " + langage.getName() + " ou clique sur 'Entrez' pour finir");
			String langageConcept = scanner.nextLine();
			
			while (!langageConcept.equals("")) {
				ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
				langage.addConceptQuiz(newConceptQuiz);
				
				System.out.println("Entrer un concept de " + langage.getName() + "ou cliquz sur 'Entrer' pour finir");
				
				langageConcept = scanner.nextLine();
			}
	    }
	 
	  public void createQuestionForLangageConcept() {
			/***************** SELECTION DU LANGAGE POUR LE QCM  *****************/
			System.out.println("Choisissez un langage pour lequel vous souhaitez créer un QCM");
			Langage chosenLangage = profesor.chooseLangageFromLangageCollection();
			
			/***************** SELECTION DU CONCEPTION DU LANGAGE CHOISI *****************/
			System.out.println("Choisissez le concept du langage "+chosenLangage.getName()+" pour lequel vous souhaitez créer un QCM");
			ConceptQuiz chosenConceptQuiz = profesor.chooseConceptQuizFromConceptQuizCollections(chosenLangage);
			
			/*** CREER UNE QUESTION */
			System.out.println("\n======================================\n"
					+ "1. Créer une question à réponse multiple \n\n"
					+ "2. Créer une question à réponse VRAI/FAUX \n\n"
					+ "3. Créer une question à réponse Numérique \n\n"
					+ "N'importe quel autre chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			
			int questionType = scanner.nextInt();
			
			while (questionType == 1 || questionType == 2 || questionType == 3) {
				
				switch (questionType) {
					case 1:
						/***************** SAISIE DES QUESTIONS À RÉPONSES MULTIPLE*****************/
						System.out.println("\n\t********************* RÉPONSES MULTIPLE***************\n");

						scanner.nextLine();
						System.out.println("Entrez la question : ");
						String questionTitle = scanner.nextLine();
						
						System.out.println("Entrez le code : ");
						String questionCode = scanner.nextLine();
						
						MultipleChoice mChoice = new MultipleChoice();
						
						mChoice.setTitle(questionTitle);
						mChoice.setCode(questionCode);
						
						/***************** ENTRÉE DES BONNES RÉPONSES *****************/
						System.out.println("\n\n\t***************** SAISIES DES BONNES RÉPONSES *****************\n\n");
						System.out.println("Entrez les bonnes réponses et cliquez sur \'Entrez\' pour finir : ");
						ArrayList<String> questionCorrectAnswers = new ArrayList<>();
						String correctAnswer = "";
						correctAnswer = scanner.nextLine();
						
						while (!correctAnswer.equals("")) {
							questionCorrectAnswers.add(correctAnswer);
							System.out.println("Entrez les bonnes réponses et cliquez sur \'Entrez\' pour finir : ");
							correctAnswer = scanner.nextLine();
						}
						
						mChoice.setCorrectAnswers(questionCorrectAnswers);
						
						/***************** ENTRÉE DES MAUVAISES RÉPONSES *****************/
						System.out.println("\n\n\t***************** SAISIES DES MAUVAISES RÉPONSES *****************\n\n");
						System.out.println("Entrez les mauvaises réponses et cliquez sur \'Entrez\' pour finir : ");
						ArrayList<String> questionInCorrectAnswers = new ArrayList<>();
						String inCorrectAnswer = "";
						inCorrectAnswer = scanner.nextLine();
						
						while (!inCorrectAnswer.equals("")) {
							questionInCorrectAnswers.add(inCorrectAnswer);
							System.out.println("Entrez les mauvaises réponses et cliquez sur \'Entrez\' pour finir : ");
							inCorrectAnswer = scanner.nextLine();
						}
						
						mChoice.setIncorrectAnswers(questionInCorrectAnswers);
						
						/***************** AJOUTER LA QUESTION AU CONCEPT *****************/
						chosenConceptQuiz.addQuestion(mChoice);
						
						break;
					case 2:
						System.out.println("\n\t********************* RÉPONSES VRAI/FAUX***************\n");
						scanner.nextLine();
						System.out.println("Entrez la question : ");
						String qTitle = scanner.nextLine();
						
						System.out.println("Entrez le code : ");
						String qCode = scanner.nextLine();
						
						TrueFalse trueFalse = new TrueFalse();
						
						trueFalse.setTitle(qTitle);
						trueFalse.setCode(qCode);
						
						System.out.println("Saisissez la bonne réponse (OUI|NON) : ");
						String goodAnswer = scanner.nextLine();
						
						while (!(goodAnswer.equals("oui") || goodAnswer.equals("non"))) {
							System.out.println("Désolé la réponse doit être OUI ou NON : ");
							goodAnswer = scanner.nextLine();
						}
											
						trueFalse.setAnswer(goodAnswer);
						
						chosenConceptQuiz.addQuestion(trueFalse);
						
						break;
					case 3:
						scanner.nextLine();
						System.out.println("Entrez la question : ");
						String numQTitle = scanner.nextLine();
						
						System.out.println("Entrez le code : ");
						String numQCode = scanner.nextLine();
						
						Numeric numeric = new Numeric();
						numeric.setTitle(numQTitle);
						numeric.setCode(numQCode);
						
						System.out.println("Saisissez la bonne réponse : ");
						String goodAnswer1 = scanner.nextLine();
						
						while (goodAnswer1.equals("")) {
							System.out.println("Désolé vous devez donner la bonne réponse : ");
							goodAnswer1 = scanner.nextLine();
						}
											
						numeric.setAnswer(goodAnswer1);
						
						chosenConceptQuiz.addQuestion(numeric);
						break;
					default: break;
				}
				
				System.out.println("\n======================================\n"
						+ "1. Créer une question à réponse multiple \n\n"
						+ "2. Créer une question à réponse VRAI/FAUX \n\n"
						+ "3. Créer une question à réponse Numérique \n\n"
						+ "N'importe quel autre chiffre POUR QUITTER \n"
						+ "======================================\n\n"
						+ "Faire une action : ");
				
				questionType = scanner.nextInt();
			}
	    }
    
	
}
