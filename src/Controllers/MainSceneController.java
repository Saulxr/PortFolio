package Controllers;

import java.net.URL;
import java.util.*;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class MainSceneController implements Initializable {

    @FXML
    private GridPane ProdContainer;

    @FXML
    private HBox cardLayout;
    private List<CardModel> recentlyViewed;
    private List<CardModel> recommandedCardModels;


    @FXML
    private TextField textField;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        recentlyViewed = new ArrayList<>(recentlyViewed()); // Initialize the list first
        recommandedCardModels = new ArrayList<>(recommandedCardModels()); // Initialize the list first
       int column =0;
       int row =1;

        try {
            for (CardModel cardModel : recommandedCardModels) {
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

            for (CardModel recommanded: recommandedCardModels) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/ProductGridVertical.fxml"));
                VBox prodBox = fxmlLoader.load();
                prodBox.getStyleClass().add("card-box");
                CardVerticalController cardVController = fxmlLoader.getController();
                System.out.println(recommanded);
                cardVController.setProd(recommanded);

                if(column == 7) {
                    column =0;
                    row++;
                }

                ProdContainer.add(prodBox, column++, row);
                GridPane.setMargin(prodBox, new Insets(10));
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

       private List<CardModel> recommandedCardModels(){

        List<CardModel> ls = new ArrayList<>();
        CardModel model1 = new CardModel();
        model1.setProduct_Name("Dr Martins");
        model1.setProduct_Img("/Views/Img/n.png");
        model1.setProduct_Price("N$1300");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Hats");
        model1.setProduct_Img("/Views/Img/hats.png");
        model1.setProduct_Price("N$200");
        ls.add(model1);

        
        model1 = new CardModel();
        model1.setProduct_Name("SHOES");
        model1.setProduct_Img("/Views/Img/shoes.png");
        model1.setProduct_Price("N$800");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Hoodies");
        model1.setProduct_Img("/Views/Img/Hoodie.png");
        model1.setProduct_Price("N$300");
        ls.add(model1);
        
                
        model1 = new CardModel();
        model1.setProduct_Name("Desk");
        model1.setProduct_Img("/Views/Img/desk.png");
        model1.setProduct_Price("N$800");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Gaming PC");
        model1.setProduct_Img("/Views/Img/GamingHub.png");
        model1.setProduct_Price("N$300");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Keyboard");
        model1.setProduct_Img("/Views/Img/Keyboard.png");
        model1.setProduct_Price("N$5000");
        ls.add(model1);

        
        model1 = new CardModel();
        model1.setProduct_Name("Laptop");
        model1.setProduct_Img("/Views/Img/Laptop.png");
        model1.setProduct_Price("N$8000");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Phone Cases");
        model1.setProduct_Img("/Views/Img/Phone.png");
        model1.setProduct_Price("N$150");
        ls.add(model1);   

        model1 = new CardModel();
        model1.setProduct_Name("Tv");
        model1.setProduct_Img("/Views/Img/Tv.png");
        model1.setProduct_Price("N$5000");
        ls.add(model1);

             
        model1 = new CardModel();
        model1.setProduct_Name("Laptop Stand");
        model1.setProduct_Img("/Views/Img/LaptopStand.png");
        model1.setProduct_Price("N$8000");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Monitor");
        model1.setProduct_Img("/Views/Img/Monitor.png");
        model1.setProduct_Price("N$150");
        ls.add(model1);   
        
        model1 = new CardModel();
        model1.setProduct_Name("Laptop");
        model1.setProduct_Img("/Views/Img/Laptop.png");
        model1.setProduct_Price("N$8000");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Phone Cases");
        model1.setProduct_Img("/Views/Img/Phone.png");
        model1.setProduct_Price("N$150");
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
        model1.setProduct_Name("Whatches");
        model1.setProduct_Img("/Views/Img/Watches.png");
        model1.setProduct_Price("N$2000");
        ls.add(model1);

        
        model1 = new CardModel();
        model1.setProduct_Name("School Bag");
        model1.setProduct_Img("/Views/Img/SchoolPumabag.png");
        model1.setProduct_Price("N$250");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Laptop");
        model1.setProduct_Img("/Views/Img/Laptop.png");
        model1.setProduct_Price("N$8000");
        ls.add(model1);
         

        model1 = new CardModel();
        model1.setProduct_Name("Laptop");
        model1.setProduct_Img("/Views/Img/Laptop.png");
        model1.setProduct_Price("N$8000");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Phone Cases");
        model1.setProduct_Img("/Views/Img/Phone.png");
        model1.setProduct_Price("N$150");
        ls.add(model1);   

        return ls;
       }

    
}
