package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class CartScreenController {
    private Cart cart;
    private Store store;
    private float totalCost;
    private CartScreen cartScreen;

    @FXML
    private Label totalCostLabel;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private MenuItem viewStoreItem;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart, CartScreen cartScreen) {
        super();
        this.cart = cart;
        this.cartScreen = cartScreen;
    }

    @FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        updateTotalCost();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    void updateTotalCost() {
        totalCost = cart.totalCost();
        totalCostLabel.setText(String.format("%.2f $", totalCost));
    }

    @FXML
    void btnRemovePressed (ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        updateTotalCost();
    }

    @FXML
    void viewStorePressed(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            cartScreen.close();  // Close the current CartScreen
        });
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Get the selected media item from the table
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        // Ensure that the selected item is a Playable media
        if (selectedMedia != null && selectedMedia instanceof Playable) {
            // Get the title directly from the selectedMedia
            String mediaTitle = selectedMedia.getTitle();

            // Create a new JavaFX Stage (equivalent of JDialog in Swing)
            Stage playDialog = new Stage();
            playDialog.setTitle("Playing Media");
            playDialog.setWidth(300);
            playDialog.setHeight(100);

            // Center the dialog on the screen
            playDialog.centerOnScreen();

            // Create a label to display the "Now Playing" message
            Label playingMessage = new Label("Now playing: " + mediaTitle);
            playingMessage.setStyle("-fx-text-alignment: center; -fx-font-size: 14px;");

            // Create a layout for the dialog and add the label
            VBox dialogLayout = new VBox(10, playingMessage);
            dialogLayout.setStyle("-fx-padding: 20px;");

            // Set the dialog scene
            Scene dialogScene = new Scene(dialogLayout);
            playDialog.setScene(dialogScene);

            // Make the dialog modal (it blocks interaction with the main window)
            playDialog.initModality(Modality.APPLICATION_MODAL);

            // Show the dialog
            playDialog.showAndWait();
        } else {
            // If the media is not playable, show a warning (optional)
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Not Playable");
            alert.setHeaderText("This media cannot be played");
            alert.setContentText("The selected media is not playable.");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Check if the cart is empty
        if (cart.getItemsOrdered().isEmpty()) {
            // Show a warning if the cart is empty
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Cart");
            alert.setHeaderText("No Items in the Cart");
            alert.setContentText("Please add some items to your cart before placing an order.");
            alert.showAndWait();
            return;
        }

        // Ask the user for confirmation before placing the order
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Place Order");
        confirmationAlert.setHeaderText("Confirm Order");
        confirmationAlert.setContentText("Are you sure you want to place the order for the selected items?");

        // Show the confirmation dialog and wait for the response
        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Proceed with placing the order
                // In a real-world scenario, you could send the order to a server or database here
                // For now, we will just show a success message and clear the cart
                cart.clear();  // Clear the cart after placing the order

                // Show a success message
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Order Placed");
                successAlert.setHeaderText("Order Successfully Placed");
                successAlert.setContentText("Your order has been successfully placed. Thank you for shopping with us!");
                successAlert.showAndWait();

                // Update the total cost and the TableView
                updateTotalCost();
                tblMedia.getItems().clear(); // Optionally clear the table if the order is complete
            }
        });
    }

}