package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
	private String title;
	private String category;
	private float cost;
	public List<String> authors = new ArrayList<String>();
	
	// Public accessor methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	// Constructors
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super();
		setId(id);
		setTitle(title);
		setCategory(category);
		setCost(cost);
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

}
