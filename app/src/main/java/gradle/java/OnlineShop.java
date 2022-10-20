package gradle.java;

import gradle.java.infrastructure.presentation.CataloguePresentation;

public class OnlineShop {

  private final CataloguePresentation cataloguePresentation;


  public OnlineShop(CataloguePresentation cataloguePresentation) {
    this.cataloguePresentation = cataloguePresentation;

  }

  public void showProducts() {
    cataloguePresentation.outputFormattedCatalogue();
  }


}
