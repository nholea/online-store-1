package gradle.java;

import java.util.ArrayList;

public class CatalogueFormater {
    public String format(ArrayList<Product> catalogue){
        for (Product product : catalogue){
            System.out.println(product.showImage());
            System.out.println(product.showDescription());
            System.out.println(product.showFeaturedAttribute());
            System.out.println(product.showPrice());
            System.out.println(product.showReference());
            System.out.println("\n");
        }
        return "";
    }
}
