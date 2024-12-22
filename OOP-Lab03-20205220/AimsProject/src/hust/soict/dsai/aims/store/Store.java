package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;

public class Store {
    private Cart cart;
    private static final int MAX_ITEMS = 100; // Maximum DVDs the store can hold
    private ArrayList<Media> itemsInStore = new ArrayList<Media>(MAX_ITEMS);

    // Singleton instance
    private static Store instance;

    // Private constructor for Singleton
    public Store() {
        this.cart = new Cart(); // Initialize the cart object
    }

    // Method to get the Singleton instance
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

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
        } else {
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

    // Method to add media to cart
    public void addMediaToCart(Media media) throws LimitExceededException {
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

    public static void main(String[] args) {
        Store store = Store.getInstance(); // Use Singleton method to get instance
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f));
        List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Media book4 = new Book(4, "Harry Potter", "Fantasy", 39.99f, authors);
        store.addMedia(book4);
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        Media cd5 = new CompactDisc(5, "Greatest Hits", "Music", "Various Artists", "John Doe", tracks, 15.99f);
        store.addMedia(cd5);
        store.addMedia(new DigitalVideoDisc(6, "Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f));
        List<String> authors2 = new ArrayList<>();
        authors2.add("George Orwell");
        Media book7 = new Book(7, "1984", "Dystopian", 15.99f, authors2);
        store.addMedia(book7);
        List<Track> tracks2 = new ArrayList<>();
        tracks2.add(new Track("Song A", 5));
        tracks2.add(new Track("Song B", 3));
        Media cd8 = new CompactDisc(8, "The Best of Rock", "Rock", "Various Artists", "Jane Smith", tracks2, 19.99f);
        store.addMedia(cd8);
        store.addMedia(new DigitalVideoDisc(9, "The Matrix", "Action", "Wachowski Brothers", 136, 22.95f));
    }
}
