package gradle.java.domain;

import gradle.java.infrastructure.interactions.Requester;
import gradle.java.infrastructure.presentation.Presentation;
import gradle.java.infrastructure.repositories.StringRepository;
import java.util.ArrayList;

public class OnlineShop {

  private final Presentation presentation;
  private final ProductRepository productRepository;

  private final Requester requester;


  public OnlineShop(Presentation presentation, ProductRepository productRepository, Requester requester) {
    this.presentation = presentation;
    this.productRepository = productRepository;
    this.requester = requester;
  }

  public void showProducts() {
    ArrayList<Product> catalogue = productRepository.findAll();
    presentation.showProducts(catalogue);
  }

  public void chooseProductByReference() {
    System.out.println(StringRepository.PRODUCT_ELECTION);
    String inputOption = requester.demand();
    Product chosenProduct = productRepository.findByReference(inputOption);
    presentation.showProductDetails(chosenProduct);
  }

  public void keepShopping() {
    presentation.nextStepsMessage();
    String inputOption = requester.demand();

    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      showProducts();
    } else {
      System.out.println(StringRepository.INVALID_OPTION);
    }
  }
}

