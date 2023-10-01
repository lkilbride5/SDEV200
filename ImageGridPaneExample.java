import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ImageGridPaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane gridPane = new GridPane();

        // Load images
        Image image1 = new Image("C:\Users\Scyth\Downloads\image (1).zip\image\china"); // Replace with your image path
        Image image2 = new Image("C:\Users\Scyth\Downloads\image (1).zip\image\ca"); // Replace with your image path
        Image image3 = new Image("C:\Users\Scyth\Downloads\image (1).zip\image\us"); // Replace with your image path
        Image image4 = new Image("C:\Users\Scyth\Downloads\image (1).zip\image\uk"); // Replace with your image path

        // Create ImageView nodes and add images to them
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // Add ImageView nodes to the GridPane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);

        // Create a Scene with the GridPane
        Scene scene = new Scene(gridPane, 400, 300); // Set preferred window size

        // Set the stage title and scene
        primaryStage.setTitle("Image GridPane Example");
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
