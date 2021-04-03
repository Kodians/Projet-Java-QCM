import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuizManager {
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Retourne le type d'utilisateur
	 * @return
	 */
	public static int userType() {
		int userType = 0;
				
		System.out.println("======== Menu ========\n");
		
		System.out.println("1. Vous êtes Professeur");
		System.out.println("2. Vous êtes Étudiant");
		
		System.out.print("Choisissez votre type : ");
		
		userType = scanner.nextInt();
				
		while (userType <= 0 || userType > 2 ) {
			System.out.println("Désolé vous devez choisir entre 1 et 2 : ");
			userType = scanner.nextInt();
		}
		
		//scanner.close();	
		
		return userType;
	}
	
	/**
	 * Permet à un admin (professeur) de créer un QCM
	 */
	public static void adminActions() {
		BaseLangage baseLangage = new BaseLangage();
		
		System.out.println("\n======================================\n"
				+ "1. Ajouter un langage \n\n"
				+ "2. Créer une question\n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		String newLangage = "";
		String langageConcept = "";
		int langID;
		int langConceptID;
		int questionType;
		
		while (choice == 1 || choice == 2) {
			switch (choice) {
				case 1:
					// créer un langage et ses, concepts
					System.out.print("Entrez le nom d'un langage : ");
					scanner.nextLine();
					newLangage = scanner.nextLine();
					
					Langage langage = null;
					
					if(!newLangage.equals("")) {
						langage = new Langage(newLangage);
						baseLangage.AddLangage(langage);
						
						/** vérifier que notre langage à bien 
						 * été ajouté à notre collection de langage*/
						if(baseLangage.getLangages().get(langage.getId()) != null) {
							System.out.println(""
									+ "Entrer un concept du langage "
									+ langage.getName() + " "
									+ "ou clique sur 'Entrez' pour finir "
									);
							
							langageConcept = scanner.nextLine();
							
							while (!langageConcept.equals("")) {
								ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
								langage.addConceptQuiz(newConceptQuiz);
								
								System.out.println(""
										+ "Entrer un concept du langage "
										+ langage.getName() + " "
										+ "ou cliquz sur 'Entrer' pour finir ");
								
								langageConcept = scanner.nextLine();
							}
						}
					}
					break;
				case 2:
					//Créer des questions par rapport à un concept d'un langage donné
					
					
					/***************** SELECTION DU LANGAGE POUR LE QCM  *****************/
					System.out.println("Choisissez un langage pour lequel vous souhaitez créer un QCM");
					
					for(Langage l : baseLangage.getLangages()) {
						if(l != null) {
							System.out.println(l.getId() + " --> Pour " + l.getName().toUpperCase());
						}
					}	
					
					System.out.print("Entrez votre choix de Langage : ");
					langID = scanner.nextInt();
					
					Langage chosenLangage = baseLangage.getLangages().get(langID);
					
					/***************** SELECTION DU CONCEPTION DU LANGAGE CHOISI *****************/
					System.out.println(
							"Choisissez le concept du langage "
							+ chosenLangage.getName()
							+ " pour lequel vous souhaitez créer un QCM");
					
					for(ConceptQuiz cq : chosenLangage.getConceptQuiz()) {
						if(cq != null) {
							System.out.println(cq.getId() + " --> Pour " + cq.getTitle());
						}
					}
					
					System.out.print("Entrez votre choix de Concept : ");
					langConceptID = scanner.nextInt();
					
					Iterator <ConceptQuiz> iterator = chosenLangage.getConceptQuiz().iterator();
					ConceptQuiz chosenConceptQuiz = null;
										
					for(ConceptQuiz conceptQuiz : chosenLangage.getConceptQuiz()) {
						if(conceptQuiz.getId() == langConceptID) {
							chosenConceptQuiz = conceptQuiz;
						}
					}
					
					
					/*** CREER UNE QUESTION */
					System.out.println("\n======================================\n"
							+ "1. Créer une question à réponse multiple \n\n"
							+ "2. Créer une question à réponse VRAI/FAUX \n\n"
							+ "======================================\n\n"
							+ "Faire une action : ");
					
					questionType = scanner.nextInt();
					
					while (questionType == 1 || questionType == 2) {
						switch (questionType) {
							case 1:
								/***************** SAISIE DES QUESTIONS À RÉPONSES MULTIPLE*****************/
								scanner.nextLine();
								System.out.println("Entrez la question : ");
								String questionTitle = scanner.nextLine();
								
								System.out.println("Entrez le code : ");
								String questionCode = scanner.nextLine();
								
								MultipleChoice mChoice = new MultipleChoice();
								
								mChoice.setTitle(questionTitle);
								mChoice.setCode(questionCode);
								
								/***************** ENTRÉE DES BONNES RÉPONSES *****************/
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
								
								break;
							case 2: break;
	
							default: break;
						}
						
						System.out.println("\n======================================\n"
								+ "1. Créer une question à réponse multiple \n\n"
								+ "2. Créer une question à réponse VRAI/FAUX \n\n"
								+ "======================================\n\n"
								+ "Faire une action : ");
						
						questionType = scanner.nextInt();
					}	
					break;
				default: break;
			}
			
			System.out.println("\n======================================\n"
					+ "1. Ajouter un langage \n\n"
					+ "2. Créer une question\n\n"
					+ "N'importe quel chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
	}
    
	/**
	 * Permettre à un étudiant de répondre à des QCM
	 */
	public static void studentActions() {};
	
	/**
     * 
     */
    public static void main(String[] argStrings) {
    	int userType = userType();
    	
    	switch (userType) {
			case 1: adminActions(); break;
			case 2: studentActions(); break;
			default: break;
		}
    	
    	/*Langage java= new Langage("Java");
    	Langage php = new Langage("PHP");
    	Langage html= new Langage("HTML");
    	
    	ConceptQuiz heritage= new ConceptQuiz("Heritage");
    	ConceptQuiz polymorphisme= new ConceptQuiz("Polymorphisme");
    	ConceptQuiz interfaces= new ConceptQuiz("Interfaces");
    	
    	java.addConceptQuiz(heritage);
    	java.addConceptQuiz(polymorphisme);
    	java.addConceptQuiz(interfaces);
    	
    	Set<ConceptQuiz> javaConceptQuiz= java.getConceptQuiz();
    	for(ConceptQuiz c: javaConceptQuiz) {
    		System.out.println(c);
    	}
    	
    	ArrayList<String> correctAnswers= new ArrayList<>();
    	correctAnswers.add(new String("Syntaxe simplifi�e"));
    	correctAnswers.add(new String("Concevoir en assignant des r�les et des responsabilit�s propres � chaque objet"));
    	correctAnswers.add(new String("Existence du � ramasse-miettes �"));
    	
    	ArrayList<String> incorrectAnswers= new ArrayList<>();
    	incorrectAnswers.add(new String("Simplification des concepts th�oriques."));
    	incorrectAnswers.add(new String("Une approche fonctionnelle plut�t que structurelle"));
    	
    	MultipleChoice multiplechoiceQuestion= new MultipleChoice("Quelle proposition repr�sente le mieux l�esprit du paradigme OO?","public class Test { \r\n"
    			+ "    public static void main(String[] args) { \r\n"
    			+ "        Foo.x = 20; \r\n"
    			+ "        System.out.println(Foo.x); \r\n"
    			+ "    }\r\n"
    			+ "}\r\n"
    			 ,correctAnswers,incorrectAnswers);
    	
    	heritage.addQuestion(multiplechoiceQuestion);
    	
    	System.out.println("\n");
    	
    	for(ConceptQuiz c: javaConceptQuiz) {
    		for(Question q : c.getQuestions()) {
    			System.out.println(q.getTitle());
        		System.out.println(q.getCode());
        		for(String s : q.getAnswers()) {
        			System.out.println(s);
        		}
    		}
    	}*/
    }
}