
import java.util.*;

/**
 * 
 */
public class Profesor extends User {
	private BaseLangage baseLangage = null;
	Scanner scanner = new Scanner(System.in);

    /**
     * Default constructor
     */
    public Profesor() {
    	this.baseLangage = new BaseLangage();
    }
    
    public Profesor(BaseLangage baseLangage) {
    	this.baseLangage = baseLangage;
    }
    
    
    /**
     * Permet à un admin (professeur) de créer un QCM
     */
	public void adminActions() {		
		System.out.println("\n======================================\n"
				+ "1. Ajouter un langage \n\n"
				+ "2. Créer une question\n\n"
				+ "3. Revenir au Menu \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3) {
			switch (choice) {
				case 1: createLangageAndConcepts(); break;
				case 2: createQuestionForLangageConcept();break;
				//case 3: menu(); break;
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
    
    
    private void createLangageAndConcepts() {
    	System.out.print("Entrez le nom d'un langage : ");
		scanner.nextLine();
		String newLangage = scanner.nextLine();
		
		Langage langage = null;
		
		if(!newLangage.equals("")) {
			langage = new Langage(newLangage);
			baseLangage.AddLangage(langage);
			
			/** vérifier que notre langage à bien été ajouté à notre collection de langage*/
			if(baseLangage.getLangages().get(langage.getId()) != null) {
				System.out.println("Entrer un concept de " + langage.getName() + "ou clique sur 'Entrez' pour finir");
				
				String langageConcept = scanner.nextLine();
				
				while (!langageConcept.equals("")) {
					ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
					langage.addConceptQuiz(newConceptQuiz);
					
					System.out.println("Entrer un concept de " + langage.getName() + "ou cliquz sur 'Entrer' pour finir");
					
					langageConcept = scanner.nextLine();
				}
			}
		}
    }
    
    private void createQuestionForLangageConcept() {
		/***************** SELECTION DU LANGAGE POUR LE QCM  *****************/
		System.out.println("Choisissez un langage pour lequel vous souhaitez créer un QCM");
		
		for(Langage l : baseLangage.getLangages()) {
			if(l != null) {
				System.out.println(l.getId() + " --> Pour " + l.getName().toUpperCase());
			}
		}	
		
		System.out.print("Entrez votre choix de Langage : ");
		int langID = scanner.nextInt();
		
		Langage chosenLangage = baseLangage.getLangages().get(langID);
		
		/***************** SELECTION DU CONCEPTION DU LANGAGE CHOISI *****************/
		System.out.println("Choisissez le concept du langage "+chosenLangage.getName()+" pour lequel vous souhaitez créer un QCM");
		
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