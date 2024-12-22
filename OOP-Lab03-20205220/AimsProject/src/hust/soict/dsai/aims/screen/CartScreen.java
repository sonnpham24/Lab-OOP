package hust.soict.dsai.aims.screen;


import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;
    private JFXPanel fxPanel;
    private CartScreenController controller;
    private StoreScreen storeScreen;

    public CartScreen(StoreScreen storeScreen, Cart cart) {
        super();
        this.storeScreen = storeScreen;
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    controller = new CartScreenController(cart, CartScreen.this);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Method to close the current JavaFX window and return to the StoreScreen
    public void close() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // Close the Swing JFrame (CartScreen)
                CartScreen.this.dispose(); // Dispose of the JFrame properly
                storeScreen.showStoreScreen();
            }
        });
    }

}
