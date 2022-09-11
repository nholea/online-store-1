package gradle.java;
import java.util.ArrayList;

public class SowProducts {

    public ArrayList<Product> showProducts(){
        DetailOfProduct detailOfProduct = new DetailOfProduct();
        return  detailOfProduct.listOfProducts();
    }
}
