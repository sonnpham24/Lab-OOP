package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JFrame {
    protected JMenuBar menuBar;
    protected JPanel inputPanel;

    public AddItemToStoreScreen(String title) {
        setTitle(title);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add Menu Bar
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(e -> goToViewStore());
        menu.add(viewStore);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Add Input Panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout with 2 columns
        add(inputPanel, BorderLayout.CENTER);

        // Add Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> handleSubmit());
        add(submitButton, BorderLayout.SOUTH);
    }

    protected void goToViewStore() {
        // Logic to go back to View Store Screen
        this.dispose();
        Store store = new Store();
        new StoreScreen(store).setVisible(true);
    }

    protected void handleSubmit() {
        // Override in subclasses to handle submission
    }
}

