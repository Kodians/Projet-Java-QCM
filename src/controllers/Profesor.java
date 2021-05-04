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
	 * Constructeur d’objets de classe Profesor
	 * @param nom
	 */
	public Profesor(String nom)
	{
	    // initialisation des variables d’instance
	    this.setNom(nom);
	    langages = new ArrayList <>();
	}
	
	/**
	 * Constructeur d’objets de classe Profesor
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param role
	 * @param baseLangage
	 */
	public Profesor(String firstName, String lastName, String userName,  char password, String role) {
		super(firstName,lastName,userName,password,role);
	}
	
	
	/**
	 * Crée un langage puis l'ajouter à la fois à la liste de 
	 * langues du professeur et celle de l'application
	 * @param  la base des langage de l'application
	 * @param  le nouveau langage créé
	*/
	 public void createLangage(BaseLangage a,  Langage l ) {
		addHisLangage(l);
		addLang (a, l);
	 }
	 
	 /**
	  * Ajoute un langage à la liste des langages du professeur
	  * @param l
	  */
	 public void addHisLangage(Langage l) {
		 langages.add(l); // ajoute le langage a SA liste
	 }
	 
	 /**
	  * Ajoute le langage a liste de tous les langages disponibles dans l’application
	  * @param a
	  * @param l
	  */
	 public void addLang(BaseLangage a, Langage l) {
        a.addLangage(l);
	 }
	 
	/**
	 * Affiche la liste de langages d'un professeur
	 */
	public String toString() {
		return "mes langages  "+ langages.toString();
	}
	 
	/**
	 * Retourne la liste des langages du professeur
	 * @return
	 */
	public ArrayList<Langage> getLangagesList(){
		return langages;
	}
	
	/**
	 * Supprimer le concept d'un langage
	 * @param langage
	 * @param conceptQuiz
	 */
	public void deleteConceptFromLangage(Langage langage, ConceptQuiz conceptQuiz) {
		langage.removeConceptQuiz(conceptQuiz);
	}
	
	/**
	 * Supprimer un langage
	 * @param baseLangage
	 * @param langage
	 * @return
	 */
	public Boolean deleteLangage(BaseLangage baseLangage, Langage langage) {
		langages.remove(langage);
		baseLangage.deletLangage(langage);
		    	
		return (langages.indexOf(langage) >= 0 || baseLangage.getLangages().indexOf(langage) >= 0);
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}