package Controllers;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CardVerticalController {

    @FXML
    private ImageView Product_Img;

    @FXML
    private Label Product_Name;

    @FXML
    private Label Product_Price;

    @FXML
    private VBox box2;

    private String [] colours = {"B9E5FF","BDB2FE","FB9AA8","FF5856"};

   public void setProd(CardModel cardModel){
          System.out.println("CCCC");
        Image pImage= new Image(getClass().getResourceAsStream(cardModel.getProduct_Img()));
         System.out.println(cardModel);
        Product_Img.setImage(pImage);
        Product_Name.setText(cardModel.getProduct_Name());
        Product_Price.setText(cardModel.getProduct_Price());
          
         box2.setStyle("-fx-background-color: #" + (colours[(int)(Math.random()*colours.length)]));

    }

}