package gradle.java;

import gradle.java.domain.Product;
import java.util.ArrayList;
import java.util.Arrays;

public class CatalogueResource {

  public static ArrayList<Product> PRODUCTS = new ArrayList<>(Arrays.asList(new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television,",
      """
        With this panoramic television, your friday nights will be boring no more.
        The screen is composed of 14 million pixels.
        Thanks to its low energy consumption design, your bills will stay low.""",
      " 13 inches",
      300.99,
      "W2C"),
    new Product(
      "\uD83C\uDFB9",
      "Untuned musical keyboard,",
      "Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour \n" +
        "will be ready to move to a building far away from you.",
      " 4 octaves",
      1003.00,
      "X4A"),
    new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television,",
      """
        With this panoramic television, your friday nights will be boring no more.
        The screen is composed of 14 million pixels.
        Thanks to its low energy consumption design, your bills will stay low.""",
      " 13 inches",
      300.99,
      "W2C")));

  public static Product PRODUCT = new Product(
    "\uD83D\uDCFA",
    "Glamorous panoramic television,",
    "With this panoramic television, your friday nights will be boring no more.\n"
      + "The screen is composed of 14 million pixels.\n"
      + "Thanks to its low energy consumption design, your bills will stay low.",
    " 13 inches",
    300.99,
    "W2C");

}
