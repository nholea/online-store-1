package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import gradle.java.infrastructure.interactions.Presentation;
import java.util.ArrayList;


public class CataloguePresentation implements Presentation {

  private final CatalogueFormatter catalogueFormatter;

  public CataloguePresentation(CatalogueFormatter catalogueFormatter) {
    this.catalogueFormatter = catalogueFormatter;
  }

  @Override
  public void showProducts(ArrayList<Product> catalogue) {
    String formattedCatalogue = catalogueFormatter.productFormat(catalogue);
    System.out.println(formattedCatalogue);
  }

  @Override
  public void showProductDetails(Product product) {
    String formattedProduct = catalogueFormatter.productDetailsFormat(product);
    System.out.println(formattedProduct);
  }

}
