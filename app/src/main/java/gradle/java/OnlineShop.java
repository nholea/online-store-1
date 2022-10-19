package gradle.java;

import gradle.java.domain.ProductRepository;
import gradle.java.infrastructure.presentation.CatalogueFormatter;
import gradle.java.infrastructure.presentation.FormattedCatalogue;

public class OnlineShop {

  private final FormattedCatalogue formattedCatalogue;



  public OnlineShop(FormattedCatalogue formattedCatalogue) {
    this.formattedCatalogue = formattedCatalogue;

  }

  public void showProducts() {
    formattedCatalogue.outputFormattedCatalogue();
  }


}
