package gradle.java.domain;

import gradle.java.infrastructure.repositories.StringRepository;
import java.util.ArrayList;

public class OnlineShop {
  
  private final ProductRepository productRepository;

  private final Formatter formatter;

  private final UserInterface userInterface;


  public OnlineShop(ProductRepository productRepository, Formatter formatter, UserInterface userInterface) {
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
    customerChoice(StringRepository.PRODUCT_ELECTION);
    String inputOption = userInterface.demand();
    Product chosenProduct = productRepository.findByReference(inputOption);
    String formattedChosenProduct = formatter.productDetailsFormat(chosenProduct);
    userInterface.sendMessage(formattedChosenProduct);
  }

  public void keepShopping() {
    customerChoice(Menu.addToCartOrKeepBrowsing());
    String inputOption = userInterface.demand();

    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      showProducts();
      chooseProductByReference();
    } else {
      userInterface.sendMessage(StringRepository.INVALID_OPTION);
    }
  }

  private void customerChoice(String message) {
    userInterface.sendMessage(message);
  }
}

