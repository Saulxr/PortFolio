package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;




public class MainSceneController implements Initializable {

    @FXML
    private GridPane ProdContainer;

    @FXML
    public HBox cardLayout;
 
        
    @FXML
    private AnchorPane tert;

    @FXML
    private TextField textField;

    

    @FXML
    public BorderPane mainBorderPane;
 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

         
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Main2.fxml"));       

        try {
            Parent root =  loader.load(); 
              
               Main2Controller main2Controller = loader.getController();
               main2Controller.setMainSceneController(this); // Pass reference to MainSceneController
             

                mainBorderPane.setCenter(root);
           
               
                 } 
                 catch (IOException e) {
            e.printStackTrace();
        }

    }}
