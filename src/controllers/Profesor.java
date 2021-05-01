package controllers;

import java.util.*;

import models.BaseLangage;
import models.ConceptQuiz;
import models.Langage;

/**
 * Décrivez votre classe Prof ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Profesor extends User {
	    // variables d’instance - remplacez l’exemple qui suit par le vôtre
    private String nom;
    private ArrayList <Langage> langages;
    /**
     * Constructeur d’objets de classe Prof
     */
    public Profesor(String n)
    {
        // initialisation des variables d’instance
        this.nom = n;
        langages = new ArrayList <>();
    }
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
    */
   public void createLangage(BaseLangage a,  Langage l ) {
	addHisLangage(l);
	addLang (a, l);
   }
   public void addHisLangage(Langage l) {
        // Insérez votre code ici
        langages.add(l); // ajoute le langage a SA liste
   }
   
   public void addLang(BaseLangage a, Langage l) {
        a.addLangage(l);// ajoute le langage a laiste de tous les langages disponibles dans l’appli
   }
    public String toString() {
    return "mes langages  "+ langages.toString();
    }
    public ArrayList<Langage> getLangagesList(){
    	return langages;
    }
    /**
     * Constructor Par défaut de la classe Profesor
     */
    public Profesor() {
    	this.baseLangage = new BaseLangage();
    }
    
    public  BaseLangage getBaseLangange() {
    	return this.baseLangage;
    }
    

    public Profesor(String firstName, String lastName, String userName,  char password, String role, BaseLangage baseLangage) {
    	super(firstName,lastName,userName,password,role);
    	this.baseLangage = baseLangage;
    }
    
    
    
    
    public void deleteConceptFromLangage(Langage langage, ConceptQuiz conceptQuiz) {
    	langage.removeConceptQuiz(conceptQuiz);
	}
    
    public Boolean deleteLangage(BaseLangage baseLangage, Langage langage) {

    	langages.remove(langage);
    	baseLangage.deletLangage(langage);
    	    	
    	return (langages.indexOf(langage) >= 0 || baseLangage.getLangages().indexOf(langage) >= 0);
    	
    }

}