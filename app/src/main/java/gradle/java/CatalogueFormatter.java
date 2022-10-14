package gradle.java;

import java.util.ArrayList;


public class CatalogueFormatter {

  public String outputFormat(ArrayList<Product> catalogue) {

    StringBuilder productFormat = new StringBuilder();
    for (Product product : catalogue) {
      productFormat.append(product.getImage());
      productFormat.append(product.getDescription());
      productFormat.append(product.getFeaturedAttribute());
      productFormat.append(product.getPrice());
      productFormat.append(product.getReference());
      productFormat.append("\n");
    }
    return productFormat.toString();
  }


}
