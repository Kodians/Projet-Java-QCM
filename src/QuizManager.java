
import java.util.*;

/**
 * 
 */
public class QuizManager {

    /**
     * Default constructor
     */
    public QuizManager() {
    }

    /**
     * 
     */
    public static void main(String[] argStrings) {
        // TODO implement here
    	Langage java= new Langage("Java",1);
    	Langage php= new Langage("PHP",2);
    	Langage html= new Langage("HTML",3);
    	
    	ConceptQuiz heritage= new ConceptQuiz("Heritage",1);
    	ConceptQuiz polymorphisme= new ConceptQuiz("Polymorphisme",2);
    	ConceptQuiz interfaces= new ConceptQuiz("Interfaces",3);

    	
    	java.addConceptQuiz(heritage);
    	java.addConceptQuiz(polymorphisme);
    	java.addConceptQuiz(interfaces);
    	
    	
    	Set<ConceptQuiz> javaConceptQuiz= java.getConceptQuiz();
    	for(ConceptQuiz c: javaConceptQuiz) {
    		System.out.println(c);
    	}
    	
    	
    	ArrayList<String> correctAnswers= new ArrayList<>();
    	correctAnswers.add(new String("Syntaxe simplifiée"));
    	correctAnswers.add(new String("Concevoir en assignant des rôles et des responsabilités propres à chaque objet"));
    	correctAnswers.add(new String("Existence du « ramasse-miettes »"));
    	
    	ArrayList<String> incorrectAnswers= new ArrayList<>();
    	incorrectAnswers.add(new String("Simplification des concepts théoriques."));
    	incorrectAnswers.add(new String("Une approche fonctionnelle plutôt que structurelle"));
    	
    	
    	MultipleChoice multiplechoiceQuestion= new MultipleChoice("Quelle proposition représente le mieux l’esprit du paradigme OO?","public class Test { \r\n"
    			+ "    public static void main(String[] args) { \r\n"
    			+ "        Foo.x = 20; \r\n"
    			+ "        System.out.println(Foo.x); \r\n"
    			+ "    }\r\n"
    			+ "}\r\n"
    			 ,10,correctAnswers,incorrectAnswers);
    	
    	heritage.addQuestion(multiplechoiceQuestion);
    	
    	for(ConceptQuiz c: javaConceptQuiz) {
    		for(Question q : c.getQuestions()) {
    			System.out.println(q.getTitle());
        		System.out.println(q.getCode());
        		for(String s : q.getAnswers()) {
        			System.out.println(s);
        		}
    		}
    	}
    }

}