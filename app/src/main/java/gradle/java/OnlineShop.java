package gradle.java;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.interactions.CustomerRequest;
import gradle.java.infrastructure.interactions.Presentation;
import gradle.java.infrastructure.repositories.StringRepository;
import java.util.ArrayList;

public class OnlineShop {

  private final Presentation presentation;
  private final ProductRepository productRepository;

  private final CustomerRequest customerRequest;


  public OnlineShop(Presentation presentation, ProductRepository productRepository, CustomerRequest customerRequest) {
    this.presentation = presentation;
    this.productRepository = productRepository;
    this.customerRequest = customerRequest;
  }

  public void showProducts() {
    ArrayList<Product> catalogue = productRepository.findAll();
    presentation.showProducts(catalogue);
  }

  public void chooseProductByReference() {
    System.out.println(StringRepository.PRODUCT_ELECTION);
    String inputOption = customerRequest.scanner();
    Product chosenProduct = productRepository.findByReference(inputOption);
    presentation.showProductDetails(chosenProduct);

  }


}
