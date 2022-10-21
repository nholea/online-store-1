package gradle.java.infrastructure.interactions;

import gradle.java.infrastructure.repositories.StringRepository;
import java.util.Scanner;

public class DisplayResponse {

  public void productsToChooseExplore() {
    System.out.println(StringRepository.PRODUCT_ELECTION);

    cataloguePresentation.outputFormattedProduct(inputOption);
  }


  public void decideWhatToDoNext() {
    System.out.println("\n" + StringRepository.NEXT_STEP);
    String nextOption1 = StringRepository.ADD_PRODUCT;
    String nextOption2 = StringRepository.SHOW_PRODUCTS;
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner scanner = new Scanner(System.in);
    String inputOption = scanner.nextLine();

    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      cataloguePresentation.outputFormattedCatalogue();
    } else {
      System.out.println(StringRepository.INVALID_OPTION);
    }
  }

}
