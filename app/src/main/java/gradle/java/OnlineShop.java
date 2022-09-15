package gradle.java;

import java.util.ArrayList;

public class OnlineShop {
    private CatalogueFormater catalogueFormater;
    private final ProductWarehouse productWarehouse = new ProductWarehouse();

    public void showProducts() {

        ArrayList<Product> catalogue = productWarehouse.findAll();
        //ListOfProducts listOfProducts = productWarehouse.findAll();

        String formattedCatalogue = catalogueFormater.format(catalogue);
        System.out.println(formattedCatalogue);
    }
}
