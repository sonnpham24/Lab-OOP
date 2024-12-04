package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
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

}
