package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;


public class CatalogueFormatter {

  public String outputFormat(ArrayList<Product> catalogue) {

    StringBuilder productFormat = new StringBuilder();
    for (Product product : catalogue) {
      productFormat.append(product.image);
      productFormat.append(product.description);
      productFormat.append(product.featuredAttribute);
      productFormat.append(product.price);
      productFormat.append(product.reference);
      productFormat.append("\n");
    }
    return productFormat.toString();
  }


}
