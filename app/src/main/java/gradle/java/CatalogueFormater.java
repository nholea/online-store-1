package gradle.java;

import java.util.ArrayList;

public class CatalogueFormater {

    private ProductWarehouse productWarehouse = new ProductWarehouse();
    private Product product;

    public String format(ArrayList<Product> catalogue){
            for (int i = 0; i < catalogue.size(); i++){
                System.out.println(product.showImage());
                System.out.println(product.showDescription());
                System.out.println(product.showFeaturedAttribute());
                System.out.println(product.showPrice());
                System.out.println(product.showReference());
            }

            return "";
        }
}
