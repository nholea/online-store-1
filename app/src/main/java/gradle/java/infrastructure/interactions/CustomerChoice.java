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
    System.out.println(Messages.PRODUCT_ELECTION);
    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();
    Product chosenProduct = productRepository.findByReference(inputOption);
    System.out.println(catalogueFormatter.outputProductDetailsFormat(chosenProduct));
  }

  public void decideWhatToDoNext() {
    System.out.println("\n" + Messages.NEXT_STEP);
    String nextOption1 = Messages.ADD_PRODUCT;
    String nextOption2 = Messages.SHOW_PRODUCTS;
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    if (inputOption.equals("1")) {
      System.out.println();
    } else if (inputOption.equals("2")) {
      formattedCatalogue.outputFormattedCatalogue();
    } else {
      System.out.println(Messages.INVALID_OPTION);
    }
  }
}
