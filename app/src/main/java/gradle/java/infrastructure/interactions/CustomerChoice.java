package gradle.java.infrastructure.interactions;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.presentation.CatalogueFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerChoice {

  private final ProductRepository productRepository;

  private final CatalogueFormatter catalogueFormatter;

  public CustomerChoice(ProductRepository productRepository, CatalogueFormatter catalogueFormatter) {
    this.productRepository = productRepository;
    this.catalogueFormatter = catalogueFormatter;
  }

  public void productsToChooseExplore() {
    System.out.println(Options.PRODUCT_ELECTION);
    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();
    Product chosenProduct = productRepository.findByReference(inputOption);
    System.out.println(catalogueFormatter.outputProductDetailsFormat(chosenProduct));
  }

  public void decideWhatToDoNext() {
    System.out.println("\n");
    System.out.println("¿What would you like to do next?");
    String nextOption1 = "1 - Add product to cart";
    String nextOption2 = "2 - Keep browsing products";
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    if (inputOption.equals("1")) {
      System.out.println();
    } else if (inputOption.equals("2")) {
      ArrayList<Product> catalogue = productRepository.findAll();
      String formattedCatalogue = catalogueFormatter.outputFormat(catalogue);
      System.out.println(formattedCatalogue);
    } else {
      System.out.println("Sorry, you have to choose one valid option");
    }
  }
}
