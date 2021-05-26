package models;

/**
 * 
 * @author Mamadou Niakate
 * @author Danko Konaté
 */
public abstract class Question {
	
	/** Attributs de la classes Question */
	
	/**
	 * Attribut static permettant d'avoir un identifiant unique pour chaque instance de la classe
	 */
	private static int count;
	
	/**
	 * Titre de la question
	 */
    protected String title;
    
    /**
     * Code de la question
     */
    protected String code;
    
    /**
     * L'identifiant de l'instance de la classe
     */
    protected int id;

    /**
     * Constructeur par défaut
     */
    public Question() {
        this.title = "";
        this.code = "";
        this.id= ++count;
    }
    

    /**
     * Constructeur avec paramètre
     * @param title
     * @param code
     */
    public Question( String title,  String code) {
        this.title = title;
        this.code = code;
        this.id= ++count;
    }

    /**
     * @param titre 
     * @param code 
     * @return void
     */
    public void setQuestion( String title, String code) {
        this.title = title;
        this.code = code;
    }
    
    /******************** SETTERS & GETTERS *******************/
    
    /**
     * Retourne le titre de la question
     * @return String
     */
	public String getTitle() {
		return title;
	}

	/**
	 * Fixe le titre de la question
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retourne le code de la question
	 * @return String
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Fixe le code de la question
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Retourne l'identifiant de la question
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Fixe l'identifiant de la question
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retourne le langage à travers son title
	 */
	public String toString() {
		return this.title;
		
	}
	
	/******************** MÉTHODES ABSTRAITES *******************/
	
	/**
	 * Méthode abstraite devrant vérifier si une réponse à la question est vraie ou fausse
	 * @param answer
	 * @return
	 */
	public abstract Boolean isCorrect(String answer);
}