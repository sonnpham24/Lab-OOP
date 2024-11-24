package aimsprojectPackage;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	// Constructor 1: Create a DVD object by title
    public DigitalVideoDisc(String title) {
    	super();
        this.title = title;
        assignId();
    }

    // Constructor 2: Create a DVD object by category, title, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
    	super();
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId();
    }

    // Constructor 3: Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(String director, String category, String title, float cost) {
    	super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        assignId();
    }

    // Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        assignId();
    }
    
    // Private method to assign a unique ID and update nbDigitalVideoDiscs
    private void assignId() {
        nbDigitalVideoDiscs++; // Increment the class-level counter
        this.id = nbDigitalVideoDiscs; // Assign the current count as the ID
    }
    
    // toString method for displaying DVD details
    public String toString() {
    	return "DVD - " + title + " - " + category + " - " + (director != null ? director : "Unknown") + 
    			" - " + (length > 0 ? length + " min": "Unknown") + ": " + cost + " $";
    }
    
    // isMatch method to check if the DVD matches a given title
    public boolean isMatch(String title) {
    	return this.title != null && this.title.toLowerCase().contains(title.toLowerCase().trim());
    }
}
