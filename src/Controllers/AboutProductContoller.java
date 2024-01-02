package Controllers;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class AboutProductContoller {

    @FXML
    private ImageView Product_Img;

    @FXML
    private Label Product_Name;

    @FXML
    private Label Product_Price;

    @FXML
    private HBox Target;

    @FXML
    private HBox backbtn;

    private Main2Controller x;

    public void setMainSceneController(Main2Controller main2Controller) {
        this.x = main2Controller;
    }

    @FXML
    void back(MouseEvent event) {
        Main2Controller v = x;
        // CardModel model1 = new CardModel();
        // model1.setProduct_Name(cardModel.getProduct_Name());
        // model1.setProduct_Img(cardModel.getProduct_Img());
        // model1.setProduct_Price(cardModel.getProduct_Price());
        v.back();

    }

    public void setProd(CardModel cardModel){
        
        Image pImage= new Image(getClass().getResourceAsStream(cardModel.getProduct_Img()));
        Product_Img.setImage(pImage);
        Product_Name.setText(cardModel.getProduct_Name());
        Product_Price.setText(cardModel.getProduct_Price());
          
    }


}
