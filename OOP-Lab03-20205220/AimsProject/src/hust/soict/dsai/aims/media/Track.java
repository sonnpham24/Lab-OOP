package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.TrackNotFoundException;

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

	public void play() throws TrackNotFoundException {
		if (this.length <= 0) {
			throw new TrackNotFoundException("Error: Track length is non-positive for track: " + this.title);
		}
		System.out.println("Playing Track: " + this.title);
		System.out.println("Track length: " + this.length + " min");
	}
	
	// Override equals to check equality based on title and length
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title != null && title.equals(track.title); // Check title and length
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }
}
