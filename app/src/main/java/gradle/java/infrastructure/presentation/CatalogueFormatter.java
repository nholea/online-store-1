package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;


public class CatalogueFormatter {

  public String productFormat(ArrayList<Product> catalogue) {
    StringBuilder productFormat = new StringBuilder();
    for (Product product : catalogue) {
      productAspectsFormat(productFormat, product.showImage());

      productSummaryDetails(productFormat, product.showShortDescription(), product.showHighlightedAttribute());

      productAspectsFormat(productFormat, product.showLongDescription());

      productDetailsFormat(productFormat, String.valueOf(product.showPrice()), "\uD83D\uDCB0 Price: %s €");

      productDetailsFormat(productFormat, product.showReference(), "Reference: %s\n");

    }
    return productFormat.toString();

  }


  public String productDetailsFormat(Product product) {
    StringBuilder productFormat = new StringBuilder();

    productAspectsFormat(productFormat, product.showImage());

    productDetailsFormat(productFormat, String.valueOf(product.showPrice()), "\uD83D\uDCB0 Price: %s €");

    productDetailsFormat(productFormat, product.showReference(), "Reference: %s");

    addExplanatoryTitle(productFormat, "\nSUMMARY:");

    productSummaryDetails(productFormat, product.showShortDescription(), product.showHighlightedAttribute());

    addExplanatoryTitle(productFormat, "\nDESCRIPTION:");

    productAspectsFormat(productFormat, product.showLongDescription());

    return productFormat.toString();


  }

  private static void productSummaryDetails(StringBuilder productBuilder, String productShortDescription,
    String productHighlightedAttribute) {
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
