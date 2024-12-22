package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField, titleField, genreField, directorField, lengthField, priceField;

    public AddDVDToStoreScreen() {
        super("Add DVD to Store");

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

        inputPanel.add(new JLabel("Director:"));
        directorField = new JTextField();
        inputPanel.add(directorField);

        inputPanel.add(new JLabel("Length (minutes):"));
        lengthField = new JTextField();
        inputPanel.add(lengthField);

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
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            float price = Float.parseFloat(priceField.getText());

            // Add new DVD to the store
            Store.getInstance().addMedia(new DigitalVideoDisc(id, title, genre, director, length, price));
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid input. Please try again.");
        }
    }
}

