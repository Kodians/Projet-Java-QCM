package models;

import java.util.*;

/**
 * 
 */
public class BaseLangage {

    /**
     * 
     */
    public ArrayList<Langage> langages;

    /**
     * Default constructor
     */
    public BaseLangage() {
    	this.langages = new ArrayList<>();
    }

    /**
     * @param String nom 
     * @return
     */
    public void AddLangage(Langage langage) {
        this.langages.add(langage);
    }

    /**
     * @param String nom 
     * @return
     */
    public void editLanagage(String nom) {
        // TODO implement here
        
    }

    /**
     * @param String nom 
     * @return
     */
    public void deletLangage(Langage langage) {
        this.langages.remove(langage);       
    }

	public ArrayList<Langage> getLangages() {
		return langages;
	}

	public void setLangages(ArrayList<Langage> langages) {
		this.langages = langages;
	}

}