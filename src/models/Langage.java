package models;
import java.util.*;

/**
 * Classe representant un lanage
 * @author Mamadou Niakaté
 * @author Danko Konaté
 */
public class Langage {
	
	/** Attributs de la classe Langage */
	
	/**
	 * Attribut static permettant d'avoir un identifiant unique pour chaque instance de la classe
	 */
	private static int count;
 
	/**
	 * Nom du lanage
	 */
	private String name;
 
	/**
	 * Liste des concepts du langage sous forme d'un ensemble
	 */
	private Set<ConceptQuiz> conceptQuiz=new HashSet<>();
	
	/**
	 * L'identifiant de l'instance de la classe
	 */
	private int id;

    /**
     * Constructeur par défaut
     */
    public Langage() {
    	this.name = "";
    }

    /**
     * Constructeur avec paramètre initialisant le nom du langage
     * @param name
     */
    public Langage( String name) {
    	this.name=name;
    	this.id= ++count;
    	this.id -= 1;
    }
  
    /**
     * Ajoute des nouveaux conceptes
     * @param c
     */
    public void addConceptQuiz( ConceptQuiz c) {
    	this.conceptQuiz.add(c);
    }

    /**
     * Modifie le titre d'une concept
     * @param title
     */
    public void editConceptQuiz(String title) {
       
    	Iterator<ConceptQuiz> iterator = this.conceptQuiz.iterator();
    	while(iterator.hasNext()) {
    		
    		if(((ConceptQuiz)iterator.next()).getId() == id) {
    			  ((ConceptQuiz)iterator.next()).setTitle(title);
    		}
    	}
    }

    /**
     * Permet de supprimer des concept
     * @param conceptQuiz
     */
    public void removeConceptQuiz( ConceptQuiz conceptQuiz) {
    	this.conceptQuiz.remove(conceptQuiz);
    }

    /**
     * Retourne le nom du langage
     * @return String
     */
	public String getName() {
		return name;
	}

	/**
	 * Fixe le nom du langage
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retourne la liste de concepts du langage
	 * @return HashSet
	 */
	public Set<ConceptQuiz> getConceptQuiz() {
		return conceptQuiz;
	}

	/**
	 * Fixe la liste de concepts du langage
	 * @param conceptQuiz
	 */
	public void setConceptQuiz(Set<ConceptQuiz> conceptQuiz) {
		this.conceptQuiz = conceptQuiz;
	}
	
	/**
	 * Retourne l'identifiant du langage
	 * @return int
	 */
	public int getId() {
		return id;
	}

	/**
	 * Fixe l'identifiant du langage
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retourne le langage à travers son nom
	 */
	public String toString() {
		return this.getName();
	}

	
    

}