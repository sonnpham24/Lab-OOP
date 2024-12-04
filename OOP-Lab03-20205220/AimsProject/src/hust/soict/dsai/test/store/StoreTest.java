package hust.soict.dsai.test.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		Store store = new Store();

        // Create DVDs
        Media dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        Media dvd3 = new DigitalVideoDisc(3, "Aladdin", "Animation", 18.99f);
        Media dvd4 = new DigitalVideoDisc(4, "Inception", "Science Fiction", "Christopher Nolan", 148, 15.50f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        //Add a book
        List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Media book = new Book(5, "Harry Potter", "Fantasy", 39.99f, authors);
              
        store.addMedia(book);
      		
        //Add a CD
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        Media cd = new CompactDisc(6, "Greatest Hits", "Music", "Various Artists", "John Doe", tracks, 15.99f);
              
        store.addMedia(cd);
        
        store.printStore();
        
        // Remove a DVD from the store
        store.removeMedia(dvd2);
        store.printStore();

        // Try removing a DVD that doesn't exist
        store.removeMedia(dvd4);
        store.printStore();
    }
}