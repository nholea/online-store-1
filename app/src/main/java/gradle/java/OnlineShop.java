package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.presentation.CatalogueFormatter;
import java.util.ArrayList;

public class OnlineShop {

  private final CatalogueFormatter catalogueFormatter;

  private final ProductRepository productRepository;

  public OnlineShop(CatalogueFormatter catalogueFormatter, ProductRepository productRepository) {
    this.catalogueFormatter = catalogueFormatter;
    this.productRepository = productRepository;
  }

  public void showProducts() {
    ArrayList<Product> catalogue = productRepository.findAll();
    String formattedCatalogue = catalogueFormatter.outputFormat(catalogue);
    System.out.println(formattedCatalogue);
  }
}
