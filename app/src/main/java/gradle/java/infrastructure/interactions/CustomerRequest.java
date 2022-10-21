package gradle.java.infrastructure.interactions;

import gradle.java.infrastructure.presentation.CataloguePresentation;
import gradle.java.infrastructure.repositories.StringRepository;
import java.util.Scanner;

public class CustomerRequest {

  private final CataloguePresentation cataloguePresentation;

  public CustomerRequest(CataloguePresentation cataloguePresentation) {
    this.cataloguePresentation = cataloguePresentation;
  }

  public String productsToChooseExplore() {
    System.out.println(StringRepository.PRODUCT_ELECTION);
    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();
    return inputOption;
  }


  public String decideWhatToDoNext() {
    System.out.println("\n" + StringRepository.NEXT_STEP);
    String nextOption1 = StringRepository.ADD_PRODUCT;
    String nextOption2 = StringRepository.SHOW_PRODUCTS;
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    return inputOption;
  }

  public void addToCartOrShowCatalogue(String inputOption) {
    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      cataloguePresentation.outputFormattedCatalogue();
    } else {
      System.out.println(StringRepository.INVALID_OPTION);
    }
  }

  public void displayChosenProductByReference(String inputOption) {
    cataloguePresentation.outputFormattedProduct(inputOption);
  }
}
