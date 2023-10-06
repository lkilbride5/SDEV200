package application;
import javafx.application.CircleColorChange;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColorSelectorController {
    private Label colorLabel;
    private ScrollBar redScrollBar;
    private ScrollBar greenScrollBar;
    private ScrollBar blueScrollBar;
    private ScrollBar opacityScrollBar;

    public ColorSelectorController() {
        colorLabel = new Label("Color Me!");
        redScrollBar = createScrollBar("Red");
        greenScrollBar = createScrollBar("Green");
        blueScrollBar = createScrollBar("Blue");
        opacityScrollBar = createScrollBar("Opacity");
        updateTextColor();
        addEventHandlers();
    }

    public VBox getUI() {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20px;");
        root.getChildren().addAll(colorLabel, redScrollBar, greenScrollBar, blueScrollBar, opacityScrollBar);
        return root;
    }

    private ScrollBar createScrollBar(String label) {
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setMin(0);
        scrollBar.setMax(100);
        scrollBar.setValue(0);
        scrollBar.setPrefWidth(200);

        Label nameLabel = new Label(label + ":");
        nameLabel.setPrefWidth(80);

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(nameLabel, scrollBar);

        return scrollBar;
    }

    private void addEventHandlers() {
        redScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        greenScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        blueScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
        opacityScrollBar.valueProperty().addListener((observable, oldValue, newValue) -> updateTextColor());
    }

    private void updateTextColor() {
        double red = redScrollBar.getValue() / 100.0;
        double green = greenScrollBar.getValue() / 100.0;
        double blue = blueScrollBar.getValue() / 100.0;
        double opacity = opacityScrollBar.getValue() / 100.0;

        Color textColor = new Color(red, green, blue, opacity);
        colorLabel.setTextFill(textColor);
    }
}
