package models;

import java.util.*;

/**
 * Classe représentation les questions à réponses multiples
 * @author Mamadou Niakate
 * @author Danko Konaté
 *
 */
public class MultipleChoice extends Question {

	/**
	 * Attributs de la classe
	 */
	
	/**
	 * Liste des bonnes réponses
	 */
	private ArrayList<String> correctAnswers;
	
	/**
	 * Liste des mauvaises réponses
	 */
	private ArrayList<String> incorrectAnswers;
	
	/**
	 * Liste du mélange des bonnes et mauvaises réponses
	 */
	private ArrayList<String> randomizedAnswer;

	/**
	 * Constructeur par défaut
	 */
	public MultipleChoice() {   
		this.correctAnswers = new ArrayList<String>();
		this.incorrectAnswers = new ArrayList<String>();
		this.randomizedAnswer = new ArrayList<String>();
	}
	
	/**
	 * Constructeur fixant le titre, le code et les bonnes réponses et les mauvaises réponses de la question
	 * @param titre
	 * @param code
	 * @param correctAnswers
	 * @param incorrectAnswers
	 */
	public MultipleChoice(String titre, String code, ArrayList<String> correctAnswers,ArrayList<String> incorrectAnswers) {
		super(titre, code);
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
	}	

	/**
	 * Mélange les bonnes et mauvaises réponses et retourne la liste de réponses
	 * @return ArrayList
	 */
	public ArrayList<String> getAnswers() {
		randomizedAnswer = new ArrayList<String>();
		randomizedAnswer.addAll(correctAnswers);
		randomizedAnswer.addAll(incorrectAnswers);
		
		Collections.shuffle(randomizedAnswer);
		
		return randomizedAnswer;
	}
	
	/**
	 * Retourne la liste de réponses mélangée
	 * @return ArrayList
	 */
	public ArrayList<String> getRandomizedAnswers() {
		return this.randomizedAnswer;
	}

	/**
	 * Retourne le langage à travers ses attributs
	 * @return
	 */
	public String toString() {

		String output = "\n\t" + this.title + "\n\t" + this.code + "\n";
				
		ArrayList<String> answers = getAnswers(); 
		
		for(int index=0; index<answers.size(); index++) {
			output += "\n" + index + " - Pour --> " + answers.get(index) + "\n";
		}
		
		return output ;
	}

	/**
	 * Retourne la liste des bonnes réponses
	 * @return ArrayList
	 */
	public ArrayList<String> getCorrectAnswers() {
		return correctAnswers;
	}

	/**
	 * Fixe la liste des bonnes réponses
	 * @param correctAnswers
	 */
	public void setCorrectAnswers(ArrayList<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	/**
	 * Retourne la liste des mauvaises réponses
	 * @return
	 */
	public ArrayList<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	/**
	 * Fixe la liste des mauvaises réponses
	 * @param incorrectAnswers
	 */
	public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}
	
	/**
	 * Méthode hériter de la classe parent Question véfiant si la réponse passée en paramètre est corrécte
	 * @return Boolean
	 */
	public Boolean isCorrect(String answer) {
		return correctAnswers.contains(answer);
	}
	
	/**
	 * Ajouter une réponse à la liste des bonnes réponses
	 * @param answ
	 */
	public void addCorrectAnswers(String answ) {
		correctAnswers.add(answ);
	}
	
	/**
	 * Ajouter une réponse à la liste des mauvaises réponses
	 * @param answ
	 */
	public void addIncorrectAnswers(String answ) {
		incorrectAnswers.add(answ);
	}
}