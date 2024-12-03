package hust.soict.dsai.test.cd;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class CdTest {
	public static void main(String[] args) {
		// Create some tracks
        Track track1 = new Track("Song A", 4);
        Track track2 = new Track("Song B", 5);
        Track track3 = new Track("Song C", 6);

        // Create a list of tracks
        List<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);

        // Create a CD
        CompactDisc cd = new CompactDisc(1, "Hits Collection", "Pop", "Various Artists", "John Doe", tracks, 14.99f);

        // Print CD details
        System.out.println(cd);
        System.out.println();

        // Add a new track
        cd.addTrack(track3);

        // Try to add a duplicate track
        cd.addTrack(track1);

        // Remove a track
        cd.removeTrack(track2);

        // Try to remove a track that doesn't exist
        Track track4 = new Track("Song D", 3);
        cd.removeTrack(track4);

        // Print updated CD details
        System.out.println("\nUpdated CD Details:");
        System.out.println(cd);
    }
}
