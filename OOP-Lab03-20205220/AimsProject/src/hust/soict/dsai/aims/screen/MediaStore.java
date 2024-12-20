package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class MediaStore extends JPanel {
	private Media media;
	private Store store;
	public MediaStore(Media media, Store store) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(e -> {
			store.addMediaToCart(media);
			JOptionPane.showMessageDialog(this, "Added " + media.getTitle() + " to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
		});
		container.add(addToCartButton);
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(e -> {
				// Show the dialog when the media is playable
				JDialog playDialog = new JDialog();
				playDialog.setTitle("Playing Media");
				playDialog.setSize(300, 100);
				playDialog.setLocationRelativeTo(null); // Center the dialog
				JLabel playingMessage = new JLabel("Now playing: " + media.getTitle(), JLabel.CENTER);
				playDialog.add(playingMessage);
				playDialog.setModal(true);
				playDialog.setVisible(true);
			});
			container.add(playButton);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
}

