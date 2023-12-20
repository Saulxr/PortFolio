package Controllers;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        
  
  Parent root;
try {
    root = FXMLLoader.load(getClass().getResource("/Views/MainScene.fxml"));
    Scene scene = new Scene(root);

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