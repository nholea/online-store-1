package gradle.java;

import java.util.ArrayList;


public class CatalogueFormatter {

  private final ProductsToChooseExplore productsToChooseExplore;

  public CatalogueFormatter(ProductsToChooseExplore productsToChooseExplore) {
    this.productsToChooseExplore = productsToChooseExplore;
  }

  public String outputFormat(ArrayList<Product> catalogue) {
    for (Product product : catalogue) {
      System.out.println(product.getImage());
      System.out.println(product.getDescription());
      System.out.println(product.getFeaturedAttribute());
      System.out.println(product.getPrice());
      System.out.println(product.getReference());
      System.out.println("\n");
    }
    productsToChooseExplore.productsToChooseExplore();
    productsToChooseExplore.decideWhatToDoNext();
    return "";
  }

}
