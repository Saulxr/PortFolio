package Module;

public class CardModel {

    private String Product_Img;
    private String Product_Name;
    private String Product_Price;

    public void setProduct_Img(String product_Img) {
        Product_Img = product_Img;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public void setProduct_Price(String product_Price_And_Rating) {
        Product_Price = product_Price_And_Rating;
    }

    public String getProduct_Img() {
        return Product_Img;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public String getProduct_Price() {
        return Product_Price;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "Product_Img='" + Product_Img + '\'' +
                ", Product_Name='" + Product_Name + '\'' +
                ", Product_Price='" + Product_Price + '\'' +
                '}';
    }
}
