package gradle.java;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerChoice {

  private final ProductRepository productRepository;

  private final CatalogueFormatter catalogueFormatter;
  String DESCRIPTION_TV = "DESCRIPTION: With this panoramic television, your friday nights will be boring no more. "
    + "The screen is composed of 14 million pixels. Thanks to its low energy consumption design, "
    + "your bills will stay low.";
  String DESCRIPTION_PIANO = "DESCRIPTION: Tired of your noisy neighbourgh? "
    + "Play this untuned musical keyboard for two hours at home and your neighbour will be ready to move to a building far away from you.";

  public CustomerChoice(ProductRepository productRepository, CatalogueFormatter catalogueFormatter) {
    this.productRepository = productRepository;
    this.catalogueFormatter = catalogueFormatter;
  }

  public void productsToChooseExplore() {
    System.out.println("Which product would you like to explore?");
    String option1 = "1 - \uD83D\uDCFA";
    String option2 = "2 - \uD83C\uDFB9";
    System.out.println(option1);
    System.out.println(option2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    if (inputOption.equals("1")) {
      System.out.println(DESCRIPTION_TV);
    } else if (inputOption.equals("2")) {
      System.out.println(DESCRIPTION_PIANO);
    } else {
      System.out.println("Sorry, the product doesn't exist");
    }
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
