package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField, titleField, genreField, priceField, authorsField;

    public AddBookToStoreScreen() {
        super("Add Book to Store");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Authors (comma-separated):"));
        authorsField = new JTextField();
        inputPanel.add(authorsField);
    }

    @Override
    protected void handleSubmit() {
        try {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String genre = genreField.getText();
            float price = Float.parseFloat(priceField.getText());
            String[] authorsArray = authorsField.getText().split(",");
            List<String> authors = Arrays.asList(authorsArray);

            // Add new Book to the store
            Store.getInstance().addMedia(new Book(id, title, genre, price, authors));
            JOptionPane.showMessageDialog(this, "Book added successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: Invalid input. Please try again.");
        }
    }
}

