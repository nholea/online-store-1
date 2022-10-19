package gradle.java.infrastructure.interactions;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.presentation.CatalogueFormatter;
import gradle.java.infrastructure.presentation.FormattedCatalogue;
import java.util.Scanner;

public class CustomerChoice {

  private final ProductRepository productRepository;

  private final CatalogueFormatter catalogueFormatter;
  private final FormattedCatalogue formattedCatalogue;

  public CustomerChoice(ProductRepository productRepository, CatalogueFormatter catalogueFormatter, FormattedCatalogue formattedCatalogue) {
    this.productRepository = productRepository;
    this.catalogueFormatter = catalogueFormatter;
    this.formattedCatalogue = formattedCatalogue;
  }

  public void productsToChooseExplore() {
    System.out.println(StringStorage.PRODUCT_ELECTION);
    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();
    Product chosenProduct = productRepository.findByReference(inputOption);
    System.out.println(catalogueFormatter.outputProductDetailsFormat(chosenProduct));
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
      formattedCatalogue.outputFormattedCatalogue();
    } else {
      System.out.println(StringStorage.INVALID_OPTION);
    }
  }
}
