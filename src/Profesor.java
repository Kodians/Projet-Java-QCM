
import java.util.*;

/**
 * 
 */
public class Profesor extends User {
	private BaseLangage baseLangage = null;
	private Scanner scanner = new Scanner(System.in);
	private Langage langage = null;
	private Menu menu = new Menu();

    /**
     * Constructor Par défaut de la classe Profesor
     */
    public Profesor() {
    	this.baseLangage = new BaseLangage();
    }
    
    /**
     * Constructeur avec paramètre de la classe Profesor
     * @param baseLangage
     */
    public Profesor(BaseLangage baseLangage) {
    	this.baseLangage = baseLangage;
    }
    
    public Profesor(String firstName, String lastName, String userName,  char password, String role, BaseLangage baseLangage) {
    	super(firstName,lastName,userName,password,role);
    	this.baseLangage = baseLangage;
    }
    
    /**
     * Affiche la liste des langages créés par le Professeur
     * @return void
     */
    public void displayLangageList() {
    	 ArrayList<Langage> langages = baseLangage.getLangages(); 
    	 for (Langage langage : langages) {
			if (langage != null) {
				System.out.println(langages.indexOf(langage) + ". Pour ---> " + langage);
			}
		}
    }
    
    
    /**
     * Permet au Professeur de créer des langages et leurs concepts
     * @return void
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
				case 0: editLangage(langage);break;
				case 3: menu.setMenu(); break;
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
	

	/**
	 * Permet d'éditer un langage en changeant son nom ou en y ajoutant des concepts après sa création
	 * @param langage
	 */
	private void editLangage(Langage langage) {
		System.out.println("\n=============="+ langage +"========================\n"
				+ "1. Modifier le nom du langage \n\n"
				+ "2. Ajouter des concepts \n\n"
				+ "3. Supprimer le langage \n\n"
				+ "4. RETOURNER AU MENU \n\n"
				+ "N'importe quel chiffre POUR QUITTER \n"
				+ "======================================\n\n"
				+ "Faire une action : ");
		
		int choice = scanner.nextInt();
		
		while (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
			System.out.println("Choix " + choice);
			switch (choice) {
				case 1: 
					scanner.nextLine();
					System.out.print("Entrez le nouveau le nom du langage : ");
					String name = scanner.nextLine();
					langage.setName(name);
					break;
				case 2: addConcept(langage); System.out.println("Add concept");break;
				case 3: baseLangage.deletLangage(langage);break;
				case 4: menu.setMenu(); break;
				default: break;
			}
			
			System.out.println("\n======================================\n"
					+ "1. Modifier le nom du langage \n\n"
					+ "2. Ajouter des concpets \n\n"
					+ "3. Supprimer le langage \n\n"
					+ "4. RETOURNER AU MENU \n\n"
					+ "N'importe quel chiffre POUR QUITTER \n"
					+ "======================================\n\n"
					+ "Faire une action : ");
			choice = scanner.nextInt();
		}
		
		System.out.println("\n\n************OPÉRATION TERMINÉ*************\n\n");
	}
    
    /**
     * Permet de créer un langage et ses concepts
     * @return void
     */
    private void createLangageAndConcepts() {
    	System.out.print("Entrez le nom d'un langage : ");
		scanner.nextLine();
		String newLangage = scanner.nextLine();
				
		if(!newLangage.equals("")) {
			langage = new Langage(newLangage);
			baseLangage.AddLangage(langage);
			
			/** vérifier que notre langage à bien été ajouté à notre collection de langage*/
			if(baseLangage.getLangages().get(langage.getId()) != null) {
				addConcept(langage);
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
    
    /**
     * Ajouter un concept à un langage donné
     * @param langage
     * @return void
     */
    private void addConcept(Langage langage) {
		scanner.nextLine();
    	System.out.println("Entrer un concept de " + langage.getName() + "ou clique sur 'Entrez' pour finir");
		String langageConcept = scanner.nextLine();
		
		while (!langageConcept.equals("")) {
			ConceptQuiz newConceptQuiz = new ConceptQuiz(langageConcept);
			langage.addConceptQuiz(newConceptQuiz);
			
			System.out.println("Entrer un concept de " + langage.getName() + "ou cliquz sur 'Entrer' pour finir");
			
			langageConcept = scanner.nextLine();
		}
    }
    
    /**
     * Permet de créer des questions pour les concepts des langages
     * @return void
     */
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

    /**
     * Retourne le menu 
     * @return
     */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * Met à jour le menu
	 * @param menu
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}