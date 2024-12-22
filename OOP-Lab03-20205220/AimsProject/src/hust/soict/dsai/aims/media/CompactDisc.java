package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.IllegalMediaLengthException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.exception.TrackNotFoundException;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	// Getter for only artist
	public String getArtist() {
		return artist;
	} 
	
	// Constructors
	public CompactDisc(int id, String title, String category, String artist, String director, List<Track> tracks, float cost) {
		super(id, title, category, director, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track: " + track.getTitle() + " already exists!");
		}
		else {
			tracks.add(track);
			System.out.println("Added track: " + track.getTitle());
		}
	}
	
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Track: " + track.getTitle() + " not found!");
		}
		else {
			tracks.remove(track);
			System.out.println("Removed track: " + track.getTitle());
		}
	}
	
	// Method to get total length of the CD
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	// Updated play method with PlayerException
	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new IllegalMediaLengthException("Error: CD Length is non-positive for " + this.getTitle());
		}

		if (tracks.isEmpty()) {
			throw new TrackNotFoundException("Error: No tracks found for CD: " + this.getTitle());
		}

		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.artist);
		System.out.println("Director: " + this.getDirector());
		System.out.println("Total Length: " + this.getLength() + " min");
		System.out.println("Tracks:");
		for (Track track : tracks) {
			track.play();
		}
	}
    
    // toString method for displaying CD details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD - ").append(getTitle()).append(" - ").append(getCategory()).append(" - ").append(getArtist())
          .append(" - ").append(getDirector()).append(": ").append(getCost()).append(" $\n");
        sb.append("Tracks:\n");
        for (Track track : tracks) {
            sb.append("- ").append(track.getTitle()).append(" (").append(track.getLength()).append(" min)\n");
        }
        sb.append("Total Length: ").append(getLength()).append(" min");
        return sb.toString();
    }
}
