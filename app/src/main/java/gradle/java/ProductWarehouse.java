package gradle.java;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductWarehouse {

    private final ArrayList<Product> products = (ArrayList<Product>) Arrays.asList(new Product(
            "\uD83D\uDCFA",
            "Glamorous panoramic television, 13 inches",
            "With this panoramic television, your friday nights will be boring no more.",
            300.99,
            "W2C"));

    public ArrayList<Product> findAll() {
        return products;
    }


}
