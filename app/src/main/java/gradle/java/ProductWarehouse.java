package gradle.java;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductWarehouse {

    private final ArrayList<Product> products = Arrays.asList(new Product(1), new Product(2), new Product(3));

    public ArrayList<Product> findAll() {
        return products;
    }


}
