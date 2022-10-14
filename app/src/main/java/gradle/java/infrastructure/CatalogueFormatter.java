package gradle.java.infrastructure;

import gradle.java.domain.Product;
import java.util.ArrayList;


public class CatalogueFormatter {

  public String outputFormat(ArrayList<Product> catalogue) {

    StringBuilder productFormat = new StringBuilder();
    for (Product product : catalogue) {
      productFormat.append(product.showImage());
      productFormat.append(product.showDescription());
      productFormat.append(product.showFeaturedAttribute());
      productFormat.append(product.showPrice());
      productFormat.append(product.showReference());
      productFormat.append("\n");
    }
    return productFormat.toString();
  }


}
