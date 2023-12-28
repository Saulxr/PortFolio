package Controllers;

import java.io.IOException;
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
    public HBox cardLayout;
    public List<CardModel> recentlyViewed;
    private List<CardModel> recommandedCardModels;

    private MyListener myListener;


    @FXML
    private TextField textField;
    //Setting Up Chosen Product
    public void setChosenProd(CardModel clickedModel) {
        recentlyViewed.add(clickedModel); // Simply add the clicked item to the list
        loadRecentlyViewed(); // Update the UI
    }

    private void loadRecentlyViewed() {
        cardLayout.getChildren().clear(); // Clear existing UI elements
        for (CardModel model : recentlyViewed) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/ProductGrid.fxml"));
            VBox cardBox;
            try {
                cardBox = fxmlLoader.load();
                cardBox.getStyleClass().add("card-box");
                CardController cardController = fxmlLoader.getController();
                cardController.setProd(model);
                cardLayout.getChildren().add(cardBox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //     public void setChosenProd2(CardModel cardModel)  {
    //             FXMLLoader fxmlLoader = new FXMLLoader();
    //             fxmlLoader.setLocation(getClass().getResource("/Views/ProductGrid.fxml"));
    //             VBox cardBox;
    //             try {
    //                 cardBox = fxmlLoader.load();
    //                 cardBox.getStyleClass().add("card-box");
    //                 CardController cardController = fxmlLoader.getController();
    //                 cardController.setProd(cardModel);
    //                 cardLayout.getChildren().add(cardBox);
    //             } catch (IOException e) {
    //                 // TODO Auto-generated catch block
    //                 e.printStackTrace();
    //             }
      
    // };
    //End Of Setting Up Product

          //Setting Up Dynamic Prod
       
    //    public void addToRecentlyViewed(CardModel item) {
    //      recentlyViewed.add(item);
   
    //        // Optionally, you can limit the size of the list to keep only the last N items
    //        int maxSize = 5; // Adjust the size as needed
    //        if (recentlyViewed.size() > maxSize) {
    //            recentlyViewed = recentlyViewed.subList(0, 2);
    //        }
   
    //        // Call a method to update the UI with the new recentlyViewed list
    //    }
       
    //    //End Of Setting Up Dynamic Prod


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
       
       recentlyViewed = new ArrayList<>(recentlyViewed()); // Initialize the list first
       recommandedCardModels = new ArrayList<>(recommandedCardModels()); // Initialize the list first
       int column =0;
       int row =1;


        //  myListener = new MyListener() {
        //            @Override
        //            public void onClickListener(CardModel cardModel) {
        //                setChosenFruit();
        //            }

              
        //        };

    //    //Setting Up Dynamic Prod
       
    //    @Override
    //    public void initialize(URL location, ResourceBundle resources) {
    //            setChosenFruit(fruits.get(0));
    //            myListener = new MyListener() {
    //                @Override
    //                public void onClickListener(Fruit fruit) {
    //                    setChosenFruit(fruit);
    //                }
    //            };
    //        }
    //    //End Of Setting Up Dynamic Prod



        try {
            for (CardModel cardModel : recommandedCardModels) {
                System.out.println("Product Name: " + cardModel.getProduct_Name());
                System.out.println("Product Image: " + cardModel.getProduct_Img());
                System.out.println("Product Price: " + cardModel.getProduct_Price());
                System.out.println("------------------------------");
            }
      

            //TESTING
           // setChosenProd();
            //END TESTING
      

            for (CardModel recommanded : recommandedCardModels) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Views/ProductGridVertical.fxml"));
                VBox prodBox = fxmlLoader.load();
                prodBox.getStyleClass().add("card-box");
                CardVerticalController cardVController = fxmlLoader.getController();
                cardVController.setMainSceneController(this); // Pass reference to MainSceneController
                System.out.println(recommanded);
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
        // CardModel model1 = new CardModel();
        // model1.setProduct_Name("SHOES");
        // model1.setProduct_Img("/Views/Img/shoes.png");
        // model1.setProduct_Price("N$800");
        // ls.add(model1);

        // model1 = new CardModel();
        // model1.setProduct_Name("Jeans");
        // model1.setProduct_Img("/Views/Img/jeans.png");
        // model1.setProduct_Price("N$200");
        // ls.add(model1);


        // model1 = new CardModel();
        // model1.setProduct_Name("Socks");
        // model1.setProduct_Img("/Views/Img/socks.png");
        // model1.setProduct_Price("N$30");
        // ls.add(model1);


        // model1 = new CardModel();
        // model1.setProduct_Name("Blazer");
        // model1.setProduct_Img("/Views/Img/Blazer.png");
        // model1.setProduct_Price("N$900");
        // ls.add(model1);
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
