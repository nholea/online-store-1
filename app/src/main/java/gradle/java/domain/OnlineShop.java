package gradle.java.domain;

import gradle.java.infrastructure.repositories.StringRepository;
import java.util.ArrayList;

public class OnlineShop {

  private final Presentation presentation;
  private final ProductRepository productRepository;

  private final Formatter formatter;

  private final UserInterface userInterface;


  public OnlineShop(Presentation presentation, ProductRepository productRepository, Formatter formatter, UserInterface userInterface) {
    this.presentation = presentation;
    this.productRepository = productRepository;
    this.formatter = formatter;
    this.userInterface = userInterface;
  }

  public void showProducts() {
    ArrayList<Product> catalogue = productRepository.findAll();
    String formattedCatalogue = formatter.productFormat(catalogue);
    userInterface.sendMessage(formattedCatalogue);
  }

  public void chooseProductByReference() {
    System.out.println(StringRepository.PRODUCT_ELECTION);
    String inputOption = userInterface.demand();
    Product chosenProduct = productRepository.findByReference(inputOption);
    presentation.showProductDetails(chosenProduct);
  }

  public void keepShopping() {
    presentation.nextStepsMessage();
    String inputOption = userInterface.demand();

    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      showProducts();
      chooseProductByReference();
    } else {
      System.out.println(StringRepository.INVALID_OPTION);
    }
  }
}

