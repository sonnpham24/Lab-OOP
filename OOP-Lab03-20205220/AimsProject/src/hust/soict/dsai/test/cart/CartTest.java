package hust.soict.dsai.test.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		
		//Add dvds
		Media dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		Media dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
		
		cart.addMedia(dvd1);
		cart.addMedia(dvd2);
		cart.addMedia(dvd3);
		
		//Add a book
		List<String> authors = new ArrayList<>();
        authors.add("J.K. Rowling");
        Media book = new Book(4, "Harry Potter", "Fantasy", 39.99f, authors);
        
        cart.addMedia(book);
		
        //Add a CD
        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("Song 1", 3));
        tracks.add(new Track("Song 2", 4));
        Media cd = new CompactDisc(5, "Greatest Hits", "Music", "Various Artists", "John Doe", tracks, 15.99f);
        
        cart.addMedia(cd);
        
		//Print cart
		cart.print();
		
		//To-do: Test the search methods here
		Scanner scanner = new Scanner(System.in);

        // Search by Title
        System.out.println("Enter the title to search for a DVD:");
        String searchTitle = scanner.nextLine();
        DigitalVideoDisc resultByTitle = cart.searchByTitle(searchTitle);
        if (resultByTitle != null) {
            System.out.println("Search result: " + resultByTitle.toString());
        } else {
            System.out.println("No DVD found with title: \"" + searchTitle + "\"");
        }
        
        // Test removing items
        System.out.println("\nRemoving 'The Lion King' from the cart:");
        cart.removeMedia(dvd1);
        cart.print();

        scanner.close();
	}

}
