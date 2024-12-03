package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Media {
	private static int nbDigitalVideoDiscs = 0;
	
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	// Constructor 1: Create a DVD object by title
    public DigitalVideoDisc(int id, String title) {
    	super(id, title, "Unknown", 0);
    }

    // Constructor 2: Create a DVD object by category, title, and cost
    public DigitalVideoDisc(int id, String title, String category, float cost) {
    	super(id, title, category, cost);
    }

    // Constructor 3: Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(int id, String director, String category, String title, float cost) {
    	super(id, title, category, cost);
        this.director = director;
    }

    // Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
    	super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    // toString method for displaying DVD details
    public String toString() {
    	return "DVD - " + getTitle() + " - " + getCategory() + " - " + (director != null ? director : "Unknown") + 
    			" - " + (length > 0 ? length + " min": "Unknown") + ": " + getCost() + " $";
    }
    
    // isMatch method to check if the DVD matches a given title
    public boolean isMatch(String title) {
    	return getTitle() != null && getTitle().toLowerCase().contains(title.toLowerCase().trim());
    }
}
