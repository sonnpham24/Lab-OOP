package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField, titleField, genreField, artistField, directorField, priceField;

    public AddCDToStoreScreen() {
        super("Add CD to Store");

        // Add Input Fields
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Genre:"));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Artist:"));
        artistField = new JTextField();
        inputPanel.add(artistField);

        inputPanel.add(new JLabel("Director:"));
        directorField = new JTextField();
        inputPanel.add(directorField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);
    }

    @Override
    protected void handleSubmit() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String genre = genreField.getText();
            String artist = artistField.getText();
            String director = directorField.getText();
            float price = Float.parseFloat(priceField.getText());

            // Add new CD to the store
            Store.getInstance().addMedia(new CompactDisc(id, title, genre, artist, director, null, price));
            JOptionPane.showMessageDialog(this, "CD added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid input. Please try again.");
        }
    }
}

