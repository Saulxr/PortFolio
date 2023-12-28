package Controllers;

import java.util.ArrayList;

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

    private MainSceneController mainSceneController;

    public void setMainSceneController(MainSceneController mainSceneController) {
        this.mainSceneController = mainSceneController;
    }

    @FXML
    void click(MouseEvent event) {
        MainSceneController v = mainSceneController;
        
        CardModel model1 = new CardModel();
        model1.setProduct_Name(cardModel.getProduct_Name());
        model1.setProduct_Img(cardModel.getProduct_Img());
        model1.setProduct_Price(cardModel.getProduct_Price());
    
        v.setChosenProd(model1);
    }
    

    // @FXML
    // void click(MouseEvent event) {
        
    //     // System.out.println(cardModel.getProduct_Name());
    //     // System.out.println(cardModel.getProduct_Img());
    //     // System.out.println("Yip");

    //     // Prodpath= cardModel.getProduct_Img();
    //     // Prodname = cardModel.getProduct_Name();
    //     // Prodprice =cardModel.getProduct_Price();

            
    //     // System.out.println(Prodname);
    //     // System.out.println(Prodpath);
    //     // System.out.println(Prodprice);

    //     CardModel model1 = new CardModel();
    //     model1.setProduct_Name(cardModel.getProduct_Name());
    //     model1.setProduct_Img(cardModel.getProduct_Img());
    //     model1.setProduct_Price(cardModel.getProduct_Price());

    //     //System.out.println(model1);


    //     MainSceneController v  = new MainSceneController();
        
    //     v.recentlyViewed = new ArrayList<>(v.recentlyViewed()); // Initialize the list first

    //     v.recentlyViewed.add(model1);
    //     //System.out.println(v.recentlyViewed);
    //     //v.setChosenProd();


    // }
  

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
