package hust.soict.dsai.aims.media;


import hust.soict.dsai.aims.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	// Constructor 1: Create a DVD object by title
    public DigitalVideoDisc(int id, String title) {
    	super(id, title, "Unknown", "Unknown", 0, 0);
    }

    // Constructor 2: Create a DVD object by category, title, and cost
    public DigitalVideoDisc(int id, String title, String category, float cost) {
    	super(id, title, category, "Unknown", 0, cost);
    }

    // Constructor 3: Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
    	super(id, title, category, director, 0, cost);
    }

    // Constructor 4: Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
    	super(id, title, category, director, length, cost);
    }

    public void play() throws PlayerException {
        // Check if the DVD has a valid length (or any other conditions)
        if (this.getLength() <= 0) {
            throw new PlayerException("The DVD " + this.getTitle() + " has invalid length and cannot be played.");
        }

        // If the DVD has a valid length, proceed with playing the DVD
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    
    // toString method for displaying DVD details
    public String toString() {
    	return "DVD - " + getTitle() + " - " + getCategory() + " - " + (getDirector() != null ? getDirector() : "Unknown") + 
    			" - " + (getLength() > 0 ? getLength() + " min": "Unknown") + ": " + getCost() + " $";
    }
    
    // isMatch method to check if the DVD matches a given title
    public boolean isMatch(String title) {
    	return getTitle() != null && getTitle().toLowerCase().contains(title.toLowerCase().trim());
    }
}
