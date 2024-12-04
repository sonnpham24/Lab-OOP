package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	// Method to add media
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
		}
		else {
			System.out.println("Cannot add media. The cart is full!");
		}
	}
	
	// Method to remove media
	public void removeMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			System.out.println("Media :" + media.getTitle() + " not found!");
		}
		else {
			itemsOrdered.remove(media);
		}
	}
	
	// Method to calculate the total cost of items in the cart
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    
    //Method to print cart
    public void print() {
    	System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Search for a DVD by title
    public DigitalVideoDisc searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc && ((DigitalVideoDisc) media).isMatch(title)) {
                return (DigitalVideoDisc) media;
            }
        }
        return null; // Notify in TestCart instead of here
    }

}
