package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.interactions.Presentation;
import java.util.ArrayList;


public class CataloguePresentation implements Presentation {

  private final ProductRepository productRepository;

  private final CatalogueFormatter catalogueFormatter;

  public CataloguePresentation(ProductRepository productRepository, CatalogueFormatter catalogueFormatter) {
    this.productRepository = productRepository;
    this.catalogueFormatter = catalogueFormatter;
  }


  public void outputFormattedProduct(Product chosenProduct) {
    System.out.println(catalogueFormatter.productDetailsFormat(chosenProduct));
  }

  @Override
  public void showProducts(ArrayList<Product> catalogue) {
    String formattedCatalogue = catalogueFormatter.productFormat(catalogue);
    System.out.println(formattedCatalogue);
  }
}
