package Controllers;

import java.net.URL;
import java.util.*;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class MainSceneController implements Initializable {
    @FXML
    private HBox cardLayout;
    private List<CardModel> recentlyViewed;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        recentlyViewed = new ArrayList<>(recentlyViewed()); // Initialize the list first

        try {
            for (CardModel cardModel : recentlyViewed) {
                System.out.println("Product Name: " + cardModel.getProduct_Name());
                System.out.println("Product Image: " + cardModel.getProduct_Img());
                System.out.println("Product Price: " + cardModel.getProduct_Price());
                System.out.println("------------------------------");
            }

            for (int i = 0; i < recentlyViewed.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/ProductGrid.fxml"));
                VBox cardBox = fxmlLoader.load();
                cardBox.getStyleClass().add("card-box");
                CardController cardController = fxmlLoader.getController();
                cardController.setProd(recentlyViewed.get(i));
                cardLayout.getChildren().add(cardBox);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<CardModel> recentlyViewed() {
        List<CardModel> ls = new ArrayList<>();
        CardModel model1 = new CardModel();
        model1.setProduct_Name("SHOES");
        model1.setProduct_Img("/Views/Img/shoes.png");
        model1.setProduct_Price("N$800");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Jeans");
        model1.setProduct_Img("/Views/Img/jeans.png");
        model1.setProduct_Price("N$200");
        ls.add(model1);


        model1 = new CardModel();
        model1.setProduct_Name("Socks");
        model1.setProduct_Img("/Views/Img/socks.png");
        model1.setProduct_Price("N$30");
        ls.add(model1);


        model1 = new CardModel();
        model1.setProduct_Name("Blazer");
        model1.setProduct_Img("/Views/Img/Blazer.png");
        model1.setProduct_Price("N$900");
        ls.add(model1);
        return ls;

        
    }

    
}
