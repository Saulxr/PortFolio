package Controllers;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/Views/MainScene.fxml"));
            Scene scene = new Scene(root);

            // Apply style class to text field
            TextField textField = (TextField) scene.lookup("#textField"); // Replace with your actual ID
            ScrollPane scrollPane = (ScrollPane) scene.lookup("#Scroll_P"); // Replace with your actual ID
            ScrollPane scrollPane2 = (ScrollPane) scene.lookup("#Scrollp"); // Replace with your actual ID

            // Handle focus based on mouse events
            textField.setOnMouseEntered(event -> textField.requestFocus());
            textField.setOnMouseExited(event -> textField.getParent().requestFocus());
            scrollPane.setOnMouseEntered(event -> scrollPane.requestFocus());
            scrollPane.setOnMouseExited(event -> scrollPane.getParent().requestFocus());
            scrollPane2.setOnMouseEntered(event -> scrollPane2.requestFocus());
            scrollPane2.setOnMouseExited(event -> scrollPane2.getParent().requestFocus());


            primaryStage.setTitle("DROP BUY!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
