import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorSelectorApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ColorSelectorController controller = new ColorSelectorController();
        Scene scene = new Scene(controller.getUI(), 300, 200);
        primaryStage.setTitle("Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
