package models;
import java.util.*;

/**
 * 
 */
public class Langage {
	
	 private static int count;
	 
	 private String name;
	 
	 private Set<ConceptQuiz> conceptQuiz=new HashSet<>();
	 private int id;

    /**
     * Default constructor
     */
    public Langage() {
    	this.name = "";
    }

   public Langage( String name) {
	   this.name=name;
	   this.id= ++count;
	   this.id -= 1;
   }
  


    /**
     * Permet de d'ajouter des nouveaux conceptes  
     * @param String title 
     * @return
     */
    public void addConceptQuiz( ConceptQuiz c) {
        // TODO implement here
    	this.conceptQuiz.add(c);
    	
    }

    /**
     * Permet de modifier le tritre d'une concepte 
     * @param String title 
     * @return
     */
    public void editConceptQuiz(String title) {
       
    	Iterator iterator = this.conceptQuiz.iterator();
    	while(iterator.hasNext()) {
    		
    		if(((ConceptQuiz)iterator.next()).getId() == id) {
    			  ((ConceptQuiz)iterator.next()).setTitle(title);
    		}
    	}
    }

    /**
     * Permet de supprimer des conceptes
     * @param String title 
     * @return
     */
    public void removeConceptQuiz( ConceptQuiz conceptQuiz) {
    	this.conceptQuiz.remove(conceptQuiz);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ConceptQuiz> getConceptQuiz() {
		return conceptQuiz;
	}

	public void setConceptQuiz(Set<ConceptQuiz> conceptQuiz) {
		this.conceptQuiz = conceptQuiz;
	}
	
	public String toString() {
		return this.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    

}