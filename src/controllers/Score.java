package controllers;

import models.ConceptQuiz;

public class Score {
	
	private ConceptQuiz conceptScore;
	

	
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
