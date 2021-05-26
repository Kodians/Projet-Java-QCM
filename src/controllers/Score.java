package controllers;

import models.ConceptQuiz;

/**
 *  @author Danko Konate
 *  @author Mamadou Niakaté
 */


public class Score {
	
	private ConceptQuiz conceptScore;
	private int scoreResult;
	

	/**
	 * Constructeur de la classe Score 
	 */
	public Score(ConceptQuiz conceptQuiz) {
		this.conceptScore = conceptQuiz;
	}
	/**
	 * L'accés à l'attribut conceptScore 
	 */
	public ConceptQuiz getConceptScore() {
		return conceptScore;
	}
	/**
	 * change le contenu de l'attribut conceptScore 
	 */
	public void setConceptScore(ConceptQuiz conceptScore) {
		this.conceptScore = conceptScore;
	}
	
	
	

}
