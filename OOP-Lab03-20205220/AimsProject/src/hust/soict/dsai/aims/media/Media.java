package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	
	// Static comparator attributes
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
	// Public accessor methods
	public int getId() {
		return id;
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

	public float getCost() {
		return cost;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
	}
	
	// Overriding equals() to check equality based on title
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true; // Check if the same reference
		if (obj == null) return false; // Check if the object is null
		if (!(obj instanceof Media)) return false; // Check if the object is an instance of Media

		Media media = (Media) obj; // Safely cast the object to Media

		// Now we can safely compare the title of both media objects
		return title != null && title.equals(media.title); // Check if titles are equal
	}


	@Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0; // Hash code based on title
    }

}
