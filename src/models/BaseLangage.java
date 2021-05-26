package models;

import java.util.*;


/**
 * Classes représentant la base des langages de l'application
 * elle définit la liste
 * @author Danko Konate
 * @author Mamadou Niakaté
 */
public class BaseLangage {

    /**
     * La liste des langages de l'application
     */
    public ArrayList<Langage> langages;

    /**
     * Constructer par défaut
     */
    public BaseLangage() {
    	this.langages = new ArrayList<>();
    }

    /**
     * Ajoute un langage à la liste des langages de l'application
     * @param langage
     */
    public void addLangage(Langage langage) {
        this.langages.add(langage);
    }


    /**
     * Supprime un langage de la liste des langages de l'application
     * @param langage
     */
    public void deletLangage(Langage langage) {
        this.langages.remove(langage);       
    }

    /**
     * Retourne la liste des langages de l'application
     * @return ArrayList
     */
	public ArrayList<Langage> getLangages() {
		return langages;
	}

	/**
	 * Fixer la liste des langages de l'application
	 * @param langages
	 */
	public void setLangages(ArrayList<Langage> langages) {
		this.langages = langages;
	}

}