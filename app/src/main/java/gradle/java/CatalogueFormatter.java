package gradle.java;

import java.util.ArrayList;


public class CatalogueFormatter {

  DecideStepToContinue decideStepToContinue = new DecideStepToContinue();
  ProductRepository productRepository;
  CatalogueFormatter catalogueFormatter = new CatalogueFormatter();
  ProductsToChooseExplore productsToChooseExplore = new ProductsToChooseExplore(productRepository, catalogueFormatter);

  public String format(ArrayList<Product> catalogue) {
    for (Product product : catalogue) {
      System.out.println(product.getImage());
      System.out.println(product.getDescription());
      System.out.println(product.getFeaturedAttribute());
      System.out.println(product.getPrice());
      System.out.println(product.getReference());
      System.out.println("\n");
    }
    productsToChooseExplore.productsToChooseExplore();
    //decideWhatToDoNext();
    return "";
  }


}
