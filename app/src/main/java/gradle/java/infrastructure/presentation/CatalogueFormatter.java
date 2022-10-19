package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;


public class CatalogueFormatter {

  public String outputFormat(ArrayList<Product> catalogue) {
    StringBuilder productFormat = new StringBuilder();
    for (Product product : catalogue) {
      productAspectsFormat(productFormat, product.image);

      productSummaryDetails(productFormat, product.shortDescription, product.highlightedAttribute);

      productAspectsFormat(productFormat, product.longDescription);

      productDetailsFormat(productFormat, String.valueOf(product.price), "\uD83D\uDCB0 Price: %s €");

      productDetailsFormat(productFormat, product.reference, "Reference: %s");

    }
    return productFormat.toString();

  }


  public String outputProductDetailsFormat(Product product) {
    StringBuilder productFormat = new StringBuilder();

    productAspectsFormat(productFormat, product.image);

    productDetailsFormat(productFormat, String.valueOf(product.price), "\uD83D\uDCB0 Price: %s €");

    productDetailsFormat(productFormat, product.reference, "Reference: %s");

    addExplanatoryTitle(productFormat, "\nSUMMARY:");

    productSummaryDetails(productFormat, product.shortDescription, product.highlightedAttribute);

    addExplanatoryTitle(productFormat, "\nDESCRIPTION:");

    productAspectsFormat(productFormat, product.longDescription);

    return productFormat.toString();


  }

  private static void productSummaryDetails(StringBuilder productBuilder, String productShortDescription, String productHighlightedAttribute) {
    productBuilder.append(productShortDescription).append(productHighlightedAttribute);
    productBuilder.append("\n");
  }

  private static void productAspectsFormat(StringBuilder productBuilder, String product) {
    productBuilder.append(product);
    productBuilder.append("\n");
  }

  private static void productDetailsFormat(StringBuilder productFormat, String product, String fieldProductFormat) {
    productFormat.append(String.format(fieldProductFormat, product));
    productFormat.append("\n");
  }

  private static void addExplanatoryTitle(StringBuilder productFormat, String title) {
    productFormat.append(title);
    productFormat.append("\n");
  }


}
