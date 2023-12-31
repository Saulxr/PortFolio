package Controllers;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    // private String Prodname;
    // private String  Prodpath;
    // private String Prodprice;

    private MainSceneController x;

    public void setMainSceneController(MainSceneController mainSceneController) {
        this.x = mainSceneController;
    }

    @FXML
    void click(MouseEvent event) {
        MainSceneController v = x;
        
        CardModel model1 = new CardModel();
        model1.setProduct_Name(cardModel.getProduct_Name());
        model1.setProduct_Img(cardModel.getProduct_Img());
        model1.setProduct_Price(cardModel.getProduct_Price());
        //If I were to cal it here no error
    //   v.naG();
       v.setChosenProd(model1);
    }
    

   

    private CardModel cardModel;


  //  private String [] colours = {"B9E5FF","BDB2FE","FB9AA8","FF5856"};


   public void setProd(CardModel cardModel){
        
        this.cardModel = cardModel;

        Image pImage= new Image(getClass().getResourceAsStream(cardModel.getProduct_Img()));
        Product_Img.setImage(pImage);
        Product_Name.setText(cardModel.getProduct_Name());
        Product_Price.setText(cardModel.getProduct_Price());
          
       //  box2.setStyle("-fx-background-color: #" + (colours[(int)(Math.random()*colours.length)]));

    }

}
