package controllers;

import models.ConceptQuiz;

public class Score {
	
	private ConceptQuiz conceptScore;
	private int scoreResult;
	

	/**
	 *  CONSTRUCTEUR DE SCORE 
	 */
	public Score(ConceptQuiz conceptQuiz) {
		this.conceptScore = conceptQuiz;
	}

	public ConceptQuiz getConceptScore() {
		return conceptScore;
	}

	public void setConceptScore(ConceptQuiz conceptScore) {
		this.conceptScore = conceptScore;
	}
	
}
