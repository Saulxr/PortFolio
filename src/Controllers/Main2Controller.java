package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Module.CardModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main2Controller implements Initializable {

    @FXML
    private GridPane ProdContainer;

    @FXML
    private ScrollPane Scroll_P;

    @FXML
    private ScrollPane Scrollp;

    @FXML
    private HBox cardLayout;

    //
    @FXML
    void setFocusOnScrollP(MouseEvent event) {
        Scroll_P.requestFocus();
    }

    @FXML
    void setFocusOnScrollp(MouseEvent event) {
        Scrollp.requestFocus();
    }

    @FXML
    void clearFocusOnScrollP(MouseEvent event) {
        Scroll_P.getParent().requestFocus();
    }

    @FXML
    void clearFocusOnScrollp(MouseEvent event) {
        Scrollp.getParent().requestFocus();
    }

   
     public List<CardModel> recentlyViewed;
    private List<CardModel> recommandedCardModels;

    private MainSceneController x;

    public void setMainSceneController(MainSceneController mainSceneController) {
        this.x = mainSceneController;
    }


public void setChosenProd(CardModel clickedModel) {
        recentlyViewed.add(0, clickedModel); // Add the new element to the beginning
    
        if (recentlyViewed.size() > 4) {
            recentlyViewed.remove(recentlyViewed.size() - 1); // Remove the last element if the list exceeds 5 items
        }
    
        loadRecentlyViewed();
    }

   

    private void loadRecentlyViewed() {
                 
          cardLayout.getChildren().clear(); // Clear existing UI elements
        for (CardModel model : recentlyViewed) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/ProductGrid.fxml"));
            VBox cardBox;
            try {
                cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setMainSceneController(this); // Pass reference to MainSceneController
                cardController.setProd(model);
                 cardLayout.getChildren().add(cardBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    public void naG(CardModel clickedModel) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/AboutProduct.fxml"));
        try {
            MainSceneController v = x;
            Parent root = (HBox) loader.load();   
            AboutProductContoller cardController = loader.getController();
            cardController.setProd(clickedModel); 
            AboutProductContoller abouController = loader.getController();
            abouController.setMainSceneController(this); // Pass reference to MainSceneController
            v.mainBorderPane.setCenter(root);
            } 
         catch (IOException e) {
            e.printStackTrace();
        }           
}

    
    public void back() {
      
        MainSceneController t = x;
        t.initialize(null, null);
        Scroll_P.requestFocus();

    }

    


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        

       
       recentlyViewed = new ArrayList<>(recentlyViewed()); // Initialize the list first
       recommandedCardModels = new ArrayList<>(recommandedCardModels()); // Initialize the list first
       int column =0;
       int row =1;
   
      loadRecentlyViewed();

        try {

            for (CardModel recommanded : recommandedCardModels) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/ProductGridVertical.fxml"));
                VBox prodBox = fxmlLoader.load();
                prodBox.getStyleClass().add("card-box");
                CardVerticalController cardVController = fxmlLoader.getController();
                cardVController.setMainSceneController(this); // Pass reference to MainSceneController
                cardVController.setProd(recommanded);
    
                if (column == 7) {
                    column = 0;
                    row++;
                }
    
                ProdContainer.add(prodBox, column++, row);
                GridPane.setMargin(prodBox, new Insets(10));
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
 

    public List<CardModel> recentlyViewed() {
        List<CardModel> ls = new ArrayList<>();
        return ls;
        
    }

       private List<CardModel> recommandedCardModels(){

        List<CardModel> ls = new ArrayList<>();
        CardModel model1 = new CardModel();
        model1.setProduct_Name("Doc Martins");
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
        model1.setProduct_Price("N$5000");
        ls.add(model1);

        model1 = new CardModel();
        model1.setProduct_Name("Keyboard");
        model1.setProduct_Img("/Views/Img/Keyboard.png");
        model1.setProduct_Price("N$300");
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
        model1.setProduct_Price("N$1000");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Monitor");
        model1.setProduct_Img("/Views/Img/Monitor.png");
        model1.setProduct_Price("N$6000");
        ls.add(model1);   
        
        model1 = new CardModel();
        model1.setProduct_Name("AIR BUDS");
        model1.setProduct_Img("/Views/Img/earbuds.png");
        model1.setProduct_Price("N$1000");
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
        model1.setProduct_Name("Lightning Cable");
        model1.setProduct_Img("/Views/Img/iphonecable.png");
        model1.setProduct_Price("N$300");
        ls.add(model1);
         
        model1 = new CardModel();
        model1.setProduct_Name("Phone Cases");
        model1.setProduct_Img("/Views/Img/Phone.png");
        model1.setProduct_Price("N$150");
        ls.add(model1);   

        return ls;
       }

    
}

