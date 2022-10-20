package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;


public class FormattedCatalogue {

  private final ProductRepository productRepository;

  private final CatalogueFormatter catalogueFormatter;

  public FormattedCatalogue(ProductRepository productRepository, CatalogueFormatter catalogueFormatter) {
    this.productRepository = productRepository;
    this.catalogueFormatter = catalogueFormatter;
  }

  public void outputFormattedCatalogue() {
    ArrayList<Product> catalogue = productRepository.findAll();
    String formattedCatalogue = catalogueFormatter.productFormat(catalogue);
    System.out.println(formattedCatalogue);
  }

  public void outputFormattedProduct(String inputOption) {
    Product chosenProduct = productRepository.findByReference(inputOption);
    System.out.println(catalogueFormatter.productDetailsFormat(chosenProduct));
  }


}
