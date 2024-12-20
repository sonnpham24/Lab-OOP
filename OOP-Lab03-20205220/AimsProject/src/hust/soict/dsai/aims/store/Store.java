package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private Cart cart;
	private static final int MAX_ITEMS = 100; // Maximum DVDs the store can hold
    private ArrayList<Media> itemsInStore = new ArrayList<Media>(MAX_ITEMS); 
    
    // Method to add media
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS) {
            itemsInStore.add(media);
            System.out.println("Added Media: " + media.getTitle());
        } else {
            System.out.println("Cannot add DVD. The store is full!");
        }
    }
    
    // Method to remove media
    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
        	System.out.println("Media: " + media.getTitle() + " not found!");
        }
        else {
        	itemsInStore.remove(media);
        }
    }
    
    // Method to search media by title
 	public Media searchByTitle(String title) {
         for (Media media : itemsInStore) {
             if (media instanceof DigitalVideoDisc && ((DigitalVideoDisc) media).isMatch(title)) {
                 return (DigitalVideoDisc) media;
             }
         }
         return null; // Notify in TestCart instead of here
     }
    
    // Method to print the list of DVDs currently in the store
    public void printStore() {
        System.out.println("******************* STORE *******************");
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty.");
        } else {
            System.out.println("Available Medias:");
            for (Media media : itemsInStore) {
                System.out.println(media.toString());
            }
        }
        System.out.println("*********************************************");
    }

    // Method to get items in store
    public ArrayList<Media> getItemsInStore() {
    	return new ArrayList<Media>(itemsInStore);
    }
    
    // Constructor to initialize the cart
    public Store() {
        this.cart = new Cart(); // Initialize the cart object
    }
    
 // Method to add media to cart
    public void addMediaToCart(Media media) {
        if (cart != null) {
            cart.addMedia(media); // Add media to the cart
        } else {
            System.out.println("Cart is not initialized!");
        }
    }
    
    // Method to get the cart
    public Cart getCart() {
        return cart;
    }
}
