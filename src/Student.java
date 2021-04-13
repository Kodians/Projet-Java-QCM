
import java.util.*;

/**
 * 
 */
public class Student extends User {
	private Scanner scanner = new Scanner(System.in);
	private BaseLangage baseLangage = null;
    private double score;
	
    /**
     * constructeur par défault
     */
    public Student() {
    	this.baseLangage = new BaseLangage();
    }
    
    /**
     * Constructeur avec paramètre
     * @param baseLangage
     */
    public Student(BaseLangage baseLangage) {
    	this.baseLangage = baseLangage;
    }

    /**
     * @param int correct int total 
     * @return
     */
    public double calculateScore( int correct, int  total) {
        // TODO implement here
        return 0.0d;
    }
    
    
    public void studentActions() {
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
			int langID = scanner.nextInt();
			
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
				int langConceptID = scanner.nextInt();
				
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
									scanner.nextLine();
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
	}

	/**
	 * retourne le score d'un étudiant
	 * @return the score
	 */
	public double getScore() {
		return score;
	}

	/**
	 * modifie le score d'un étudiant
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
	};

}