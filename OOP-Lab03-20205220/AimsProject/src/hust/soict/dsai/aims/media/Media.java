package hust.soict.dsai.aims.media;

public abstract class Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	
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

}
