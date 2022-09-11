package gradle.java;
import java.util.ArrayList;

public class ShowProducts {

    public ArrayList<Product> showProducts(){
        DetailOfProduct detailOfProduct = new DetailOfProduct();
        return  detailOfProduct.listOfProducts();
    }
}
