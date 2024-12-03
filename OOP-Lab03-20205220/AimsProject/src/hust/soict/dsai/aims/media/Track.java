package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
	private String title;
	private int length;
	
	// Public getters
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	// Contructors
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	// Method play()
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	// Override equals and hashCode for proper comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && Objects.equals(title, track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }
}
