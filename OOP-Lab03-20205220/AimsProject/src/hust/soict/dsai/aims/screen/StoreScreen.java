package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"))
				.addActionListener(e -> new AddBookToStoreScreen().setVisible(true));
		smUpdateStore.add(new JMenuItem("Add CD"))
				.addActionListener(e -> new AddCDToStoreScreen().setVisible(true));
		smUpdateStore.add(new JMenuItem("Add DVD"))
				.addActionListener(e -> new AddDVDToStoreScreen().setVisible(true));

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		// View Cart menu item
		JMenuItem viewCartItem = new JMenuItem("View Cart");
		viewCartItem.addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				setVisible(false);
				new CartScreen(this, cart);
			});
		});
		menu.add(viewCartItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.cyan);
		
		JButton cartButton = new JButton("View cart");
		cartButton.setPreferredSize(new Dimension(100, 50));
		cartButton.setMaximumSize(new Dimension(100, 50));

		// Add ActionListener to navigate to CartScreen
		cartButton.addActionListener(e -> {
			SwingUtilities.invokeLater(() -> {
				setVisible(false);
				new CartScreen(this, cart);
			});
		});

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		int itemsToShow = Math.min(9, mediaInStore.size());
		for (int i = 0; i < itemsToShow; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), store, cart);
			center.add(cell);
		}

		for (int i = itemsToShow; i < 9; i++) {
			center.add(new JPanel()); // Fill remaining cells with empty panels
		}

		return center;
	}
	
	public StoreScreen(Store store) {
		this.store = store;
		this.cart = new Cart();
		new JFXPanel();
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	// Method to show the StoreScreen
	public void showStoreScreen() {
		setVisible(true);
	}

	public void refreshCenterPanel() {
		Container cp = getContentPane();
		cp.remove(1); // Assuming the center panel is the second component
		cp.add(createCenter(), BorderLayout.CENTER);
		revalidate();
		repaint();
	}


	public static void main(String[] args) {
		Store store = new Store();

		store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
		store.addMedia(new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f));
		List<String> authors = new ArrayList<>();
		authors.add("J.K. Rowling");
		Media book4 = new Book(4, "Harry Potter", "Fantasy", 39.99f, authors);
		store.addMedia(book4);
		List<Track> tracks = new ArrayList<>();
		tracks.add(new Track("Song 1", 3));
		tracks.add(new Track("Song 2", 4));
		Media cd5 = new CompactDisc(5, "Greatest Hits", "Music", "Various Artists", "John Doe", tracks, 15.99f);
		store.addMedia(cd5);
		store.addMedia(new DigitalVideoDisc(6, "Inception", "Science Fiction", "Christopher Nolan", 148, 29.99f));
		List<String> authors2 = new ArrayList<>();
		authors2.add("George Orwell");
		Media book7 = new Book(7, "1984", "Dystopian", 15.99f, authors2);
		store.addMedia(book7);
		List<Track> tracks2 = new ArrayList<>();
		tracks2.add(new Track("Song A", 5));
		tracks2.add(new Track("Song B", 3));
		Media cd8 = new CompactDisc(8, "The Best of Rock", "Rock", "Various Artists", "Jane Smith", tracks2, 19.99f);
		store.addMedia(cd8);
		store.addMedia(new DigitalVideoDisc(9, "The Matrix", "Action", "Wachowski Brothers", 136, 22.95f));

		new StoreScreen(store);
	}
}
