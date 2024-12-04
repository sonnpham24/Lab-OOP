package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	// Static comparator attributes
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
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

    // Method to filter by ID
    public void filterById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found media with ID " + id + ": " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }
    
    // Method to filter by Title
    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found media with title \"" + title + "\": " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }
    
    // Method to sort by title, then cost
    public void sortByTitle() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title, then Cost:");
        print();
    }

    // Method to sort items in the cart by cost
    public void sortByCost() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost, then Title:");
        print();
    }
    
    // Method to clear the cart
    public void clear() {
        itemsOrdered.clear();
    }
    
}
