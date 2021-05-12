package models;

import java.util.*;

/**
 * 
 */
public class MultipleChoice extends Question {

	private ArrayList<String> correctAnswers;
	private ArrayList<String> incorrectAnswers;
	private ArrayList<String> randomizedAnswer;

	/**
	 * Default constructor
	 */
	public MultipleChoice() {   
		this.correctAnswers = new ArrayList<String>();
		this.incorrectAnswers = new ArrayList<String>();
		this.randomizedAnswer = new ArrayList<String>();
	}

	public MultipleChoice(String titre, String code, ArrayList<String> correctAnswers,ArrayList<String> incorrectAnswers) {
		super(titre, code);
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
	}
	

	/**
	 * @return
	 */
	public ArrayList<String> getAnswers() {
		randomizedAnswer = new ArrayList<String>();
		randomizedAnswer.addAll(correctAnswers);
		randomizedAnswer.addAll(incorrectAnswers);
		
		Collections.shuffle(randomizedAnswer);
		
		return randomizedAnswer;
	}
	
	public ArrayList<String> getRandomizedAnswers() {
		return this.randomizedAnswer;
	}

	/**
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
	 * @return
	 */
	public boolean isCorrect() {
		// TODO implement here
		return false;
	}

	public ArrayList<String> getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(ArrayList<String> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public ArrayList<String> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(ArrayList<String> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}
	
	public Boolean isCorrect(String answer) {
		return correctAnswers.contains(answer);
	}
	
	public void addCorrectAnswers(String answ) {
		correctAnswers.add(answ);
	}
	public void addIncorrectAnswers(String answ) {
		incorrectAnswers.add(answ);
	}
}