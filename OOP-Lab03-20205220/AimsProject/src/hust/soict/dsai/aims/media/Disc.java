package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private String director;
	private int length;
	
	// Getter methods
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	// Constructors
	public Disc(int id, String title, String category, String director, float cost) {
		super(id, title, category, cost);
		this.director = director;
	}
	
	public Disc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}
	
}
