import java.util.*;

public class Backup {
	static Scanner scanner = new Scanner(System.in);
	static BaseLangage baseLangage = new BaseLangage();
	static int choice;
	static String newLangage = "";
	static String langageConcept = "";
	static int langID;
	static int langConceptID;
	static int questionType;
	
	/**
	 * Retourne le type d'utilisateur
	 * @return
	 */
	public static void menu() {				
		System.out.println("======== Menu ========\n");

		System.out.println("1. Vous êtes Professeur");
		System.out.println("2. Vous êtes Étudiant");
		
		System.out.print("Choisissez votre type : ");
		
		int userType = scanner.nextInt();
				
		while (userType == 1 || userType == 2 ) {
			switch (userType) {
				case 1: adminActions(); break;
				case 2: studentActions(); break;
				default: break;
			}
			userType = scanner.nextInt();
		}
	}
	
	/**
	 * Permet à un admin (professeur) de créer un QCM
	 */
	public static void adminActions() {		
		System.out.println("\n======================================\n"
				+ "1. Ajouter un langage \n\n"
				+ "2. Créer une question\n\n"
				+ "3. Revenir au Menu \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3) {
			switch (choice) {
				case 1: createLangageAndConcepts(); break;
				case 2: createQuestionForLangageConcept();break;
				case 3: menu(); break;
				default: break;
			}
			
			System.out.println("\n======================================\n"
					+ "1. Ajouter un langage \n\n"
					+ "2. Créer une question\n\n"
					+ "3. Revenir au Menu\n\n"
					+ "N'importe quel autre chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
		
		System.out.println("\n\n************OPÉRATION TERMINÉ*************\n\n");
	}
    
	// Permettre à un étudiant de répondre à des QCM
	public static void studentActions() {
		System.out.println("\n***************************** BON QUIZ *****************************\n");
		
		// affichage de la liste des langage
		ArrayList<Langage> langages = baseLangage.getLangages();
		
		if(!(langages.size() < 1)) {
			System.out.println("\nChoissez le langage pour lequel vous souhaitez faire le QCM \n");
			for(Langage l : langages) {
				if(l != null) {
					System.out.println(l.getId() + " -- Pour --> " + l.getName());
				}
			}
			
			System.out.print("Saisissez le nom du Langage de votre choix : ");
			langID = scanner.nextInt();
			
			Langage chosenLangage = langages.get(langID);
			
			// afficher la liste des concepts d'un langage choisi
			if(!(chosenLangage.getConceptQuiz().size() < 1)) {
				System.out.println("--------------- " + chosenLangage + "---------------------");
				for (ConceptQuiz c : chosenLangage.getConceptQuiz()) {
					if(c != null) {
						System.out.println(c.getId() + " -- Pour --> " + c.getTitle());
					}
				}
				
				System.out.print("Saisissez le nom du concept de votre choix : ");
				langConceptID = scanner.nextInt();
				
				ConceptQuiz chosenQuiz = null;
								
				for(ConceptQuiz conceptQuiz : chosenLangage.getConceptQuiz()) {
					if(conceptQuiz.getId() == langConceptID) {
						chosenQuiz = conceptQuiz;
					}
				}
				
				if(!(chosenQuiz.getQuestions().size() < 1)) {
					
					ArrayList<String> userMultipleAnswers = new ArrayList<>();
					ArrayList<String> userTrueFalseAnswers= new ArrayList<>();
					ArrayList<String> userNumericAnswers  = new ArrayList<>(); 
					
					for (Question question : chosenQuiz.getQuestions()) {
						if(question != null) {
							System.out.println(question);
							String answer = "";						
							switch (question.getClass().getName()) {
								case "MultipleChoice":
									System.out.print("Saisir le N° d'une réponse ou cliquez sur 'Entrez' pour continuer : ");
									answer = scanner.nextLine();
									while (!answer.equals("")) {
										int index = Integer.parseInt(answer);
										if(userMultipleAnswers.get(index) != null) {
											userMultipleAnswers.add(question.getAnswers().get(Integer.parseInt(answer)));
										} else {
											System.out.println("\n**ATTENTION!!! Vous avez déjà choisi cette réponse**\n");
										}
										System.out.print("Saisir le N° d'une réponse ou cliquez sur 'Entrez' pour continuer : ");
										answer = scanner.nextLine();
									}
									break;
								case "TrueFalse":
									System.out.print("Saisir OUI ou NON: ");
									answer = scanner.nextLine();
									while(!(answer.equals("oui") || answer.equals("non"))) {
										System.out.print("\nDésolé vous devez répondre par OUI ou NON pour continuer\n");
										System.out.print("Saisir OUI ou NON: ");
										answer = scanner.nextLine();
									}
									userNumericAnswers.add(answer);
									break;
								case "Numeric": 
									System.out.print("Saisir votre réponse : ");
									answer = scanner.nextLine();
									while(answer.equals("")) {
										System.out.print("\nDésolé vous ne pouvez pas laisser la question sans réponse\n");
										System.out.print("Saisir votre réponse: ");
										answer = scanner.nextLine();
									}
									userTrueFalseAnswers.add(answer);
									break;
								default: break;
							}
						}
					}
				} else {
					System.out.println("\n\nDésolé aucune question n'existe pour "+chosenQuiz+", veillez ressayer ultérieurement\n\n");	
				}
				
			} else {
				System.out.println("\n\nDésolé aucun concept n'existe pour "+chosenLangage+", veillez ressayer ultérieurement\n\n");	
			}
			
		} else {
			System.out.println("\n\nDésolé aucun langage n'existe, veillez ressayer ultérieurement\n\n");	
		}
	};
	
	/**
     * 
     */
    public static void main(String[] argStrings) {
    	menu();
    }
    
    public static void createLangageAndConcepts() {
    	System.out.print("Entrez le nom d'un langage : ");
		scanner.nextLine();
		newLangage = scanner.nextLine();
		
		Langage langage = null;
		
		if(!newLangage.equals("")) {
			langage = new Langage(newLangage);
			baseLangage.AddLangage(langage);
			
			/** vérifier que notre langage à bien été ajouté à notre collection de langage*/
			if(baseLangage.getLangages().get(langage.getId()) != null) {
				System.out.println("Entrer un concept de " + langage.getName() + "ou clique sur 'Entrez' pour finir");
				
				langageConcept = scanner.nextLine();
				
				while (!langageConcept.equals("")) {
					ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
					langage.addConceptQuiz(newConceptQuiz);
					
					System.out.println("Entrer un concept de " + langage.getName() + "ou cliquz sur 'Entrer' pour finir");
					
					langageConcept = scanner.nextLine();
				}
			}
		}
    }
    
    public static void createQuestionForLangageConcept() {
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
		System.out.println("Choisissez le concept du langage "+chosenLangage.getName()+" pour lequel vous souhaitez créer un QCM");
		
		for(ConceptQuiz cq : chosenLangage.getConceptQuiz()) {
			if(cq != null) {
				System.out.println(cq.getId() + " --> Pour " + cq.getTitle());
			}
		}
		
		System.out.print("Entrez votre choix de Concept : ");
		langConceptID = scanner.nextInt();
		
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
				+ "3. Créer une question à réponse Numérique \n\n"
				+ "N'importe quel autre chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		questionType = scanner.nextInt();
		
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