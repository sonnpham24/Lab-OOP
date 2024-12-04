package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class MediaTest {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		//Add dvds
		Media dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		Media dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		Media dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
				
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(dvd3);
		
		//Add a book
		List<String> authors = new ArrayList<>();
		authors.add("J.K. Rowling");
		Media book = new Book(4, "Harry Potter", "Fantasy", 39.99f, authors);
		        
		mediae.add(book);
				
		//Add a CD
		List<Track> tracks = new ArrayList<>();
		tracks.add(new Track("Song 1", 3));
		tracks.add(new Track("Song 2", 4));
		Media cd = new CompactDisc(5, "Greatest Hits", "Music", "Various Artists", "John Doe", tracks, 15.99f);
		        
		mediae.add(cd);
		
		System.out.println("Before sorting:");
		for (Media m : mediae) {
			System.out.println(m.toString());
		}
		
		// Sort by title, then cost
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
        System.out.println("\nSorted by Title, then Cost:");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        // Sort by cost, then title
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
        System.out.println("\nSorted by Cost, then Title:");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
	}

}
