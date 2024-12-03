package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	public List<String> authors = new ArrayList<String>();
	
	// Constructors
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Author: " + authorName + " already exists!");
		}
		else {
			authors.add(authorName);
			System.out.println("Added author: " + authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Author: " + authorName + " not found!");
		}
		else {
			authors.remove(authorName);
			System.out.println("Removed author: " + authorName);
		}
	}
	
	@Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() +
               " - " + getCost() + " - " + authors;
    }

}
