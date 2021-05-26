package models;

/**
 * 
 * @author niakate
 *@author danko
 */
public abstract class Question {
	private static int count;
    protected String title;
    protected String code;
    protected int id;

    /**
     * Constructor
     */
    public Question() {
        this.title = "";
        this.code = "";
        this.id= ++count;
    }
    
    /**
     * Constructor
     * @param String title 
     */
    public Question( String title,  String code) {
        this.title = title;
        this.code = code;
        this.id= ++count;
    }

    /**
     * @param titre 
     * @param code 
     * @return
     */
    public void setQuestion( String title, String code) {
        this.title = title;
        this.code = code;
    }
    
    /******************** SETTERS & GETTERS *******************/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return this.title;
		
	}
	
	/******************** MÉTHODES ABSTRAITES *******************/
	
	public abstract Boolean isCorrect(String answer);
}