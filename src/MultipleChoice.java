
import java.util.*;

import javax.swing.JTextArea;

/**
 * 
 */
public class MultipleChoice extends Question {

	private ArrayList<String> correctAnswers;
	private ArrayList<String> incorrectAnswers;

	/**
	 * Default constructor
	 */
	public MultipleChoice() {

	}

	public MultipleChoice(String titre, String code, int id, ArrayList<String> correctAnswers,
			ArrayList<String> incorrectAnswers) {

		super(titre, code, id);
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;

	}

	/**
	 * 
	 */
	public void SingleMC(String titre, JTextArea code, ArrayList<Character> correctAnswers,
			ArrayList<Character> incorrectAnswers) {
		// TODO implement here
	}

	/**
	 * @return
	 */
	public ArrayList<String> getAnswers() {
		ArrayList<String> answers= new ArrayList<>();
		answers.addAll(correctAnswers);
		answers.addAll(incorrectAnswers);
		Collections.shuffle(answers);
		return answers;
	}

	/**
	 * @return
	 */
	public void setAnswers() {
		// TODO implement here

	}

	/**
	 * @return
	 */
	public String toString() {
		// TODO implement here
		return "";
	}

	/**
	 * @return
	 */
	public boolean isCorrect() {
		// TODO implement here
		return false;
	}

}