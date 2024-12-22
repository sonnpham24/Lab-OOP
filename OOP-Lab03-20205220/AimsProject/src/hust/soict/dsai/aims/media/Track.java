package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.PlayerException;

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

	public void play() throws PlayerException {
		// Check if the track has a valid length (or any other conditions)
		if (this.length <= 0) {
			throw new PlayerException("The track " + this.getTitle() + " has an invalid length and cannot be played.");
		}

		// If the track has a valid length, proceed with playing the track
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
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
