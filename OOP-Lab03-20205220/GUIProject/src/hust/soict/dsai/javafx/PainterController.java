package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup identical;

    //Color for pen and eraser
    private Color penColor = Color.BLACK;
    private Color eraserColor = Color.WHITE;

    @FXML
    private void initialize() {
        penRadioButton.setSelected(true);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color currentColor = (penRadioButton.isSelected()) ? penColor : eraserColor;

        Circle newCircle = new Circle(event.getX(), event.getY() , 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
