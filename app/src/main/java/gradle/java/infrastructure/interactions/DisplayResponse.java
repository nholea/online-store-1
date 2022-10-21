package gradle.java.infrastructure.interactions;

import gradle.java.infrastructure.presentation.CataloguePresentation;
import gradle.java.infrastructure.repositories.StringRepository;

public class DisplayResponse {

  private final CustomerRequest customerRequest;
  private final CataloguePresentation cataloguePresentation;


  public DisplayResponse(CustomerRequest customerRequest, CataloguePresentation cataloguePresentation) {
    this.customerRequest = customerRequest;
    this.cataloguePresentation = cataloguePresentation;
  }

  public void displayChosenProductByReference() {
    System.out.println(StringRepository.PRODUCT_ELECTION);
    String inputOption = customerRequest.scanner();
    cataloguePresentation.outputFormattedProduct(inputOption);
  }


  public void displayDecideWhatToDoNext() {
    System.out.println("\n" + StringRepository.NEXT_STEP);
    System.out.println(StringRepository.ADD_PRODUCT);
    System.out.println(StringRepository.SHOW_PRODUCTS);

  }

  public void addToCartOrShowCatalogue() {
    String inputOption = customerRequest.scanner();

    if (inputOption.equals(StringRepository.ONE)) {
      System.out.println();
    } else if (inputOption.equals(StringRepository.TWO)) {
      cataloguePresentation.outputFormattedCatalogue();
    } else {
      System.out.println(StringRepository.INVALID_OPTION);
    }
  }

}
