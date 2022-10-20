package gradle.java.infrastructure.interactions;

import gradle.java.infrastructure.presentation.CataloguePresentation;
import gradle.java.infrastructure.repositories.StringStorage;
import java.util.Scanner;

public class CustomerChoice {

  private final CataloguePresentation cataloguePresentation;

  public CustomerChoice(CataloguePresentation cataloguePresentation) {
    this.cataloguePresentation = cataloguePresentation;
  }

  public void productsToChooseExplore() {
    System.out.println(StringStorage.PRODUCT_ELECTION);
    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();
    cataloguePresentation.outputFormattedProduct(inputOption);
  }


  public void decideWhatToDoNext() {
    System.out.println("\n" + StringStorage.NEXT_STEP);
    String nextOption1 = StringStorage.ADD_PRODUCT;
    String nextOption2 = StringStorage.SHOW_PRODUCTS;
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    if (inputOption.equals(StringStorage.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringStorage.TWO)) {
      cataloguePresentation.outputFormattedCatalogue();
    } else {
      System.out.println(StringStorage.INVALID_OPTION);
    }
  }
}
