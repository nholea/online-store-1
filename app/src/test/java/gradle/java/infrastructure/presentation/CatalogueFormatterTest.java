package gradle.java.infrastructure.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import gradle.java.CatalogueResource;
import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CatalogueFormatterTest {

  @Mock
  ProductRepository productRepository;

  @InjectMocks
  CatalogueFormatter catalogueFormatter;

  @Test
  void productFormatTest() {
    String expectedFormattedCatalogue = """
      \uD83D\uDCFA
      Glamorous panoramic television, 13 inches
      With this panoramic television, your friday nights will be boring no more.
      The screen is composed of 14 million pixels.
      Thanks to its low energy consumption design, your bills will stay low.
      \uD83D\uDCB0 Price: 300.99 €
      Reference: W2C

      \uD83C\uDFB9
      Untuned musical keyboard, 4 octaves
      Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour\s
      will be ready to move to a building far away from you.
      \uD83D\uDCB0 Price: 1003.0 €
      Reference: X4A

      \uD83D\uDCFA
      Glamorous panoramic television, 13 inches
      With this panoramic television, your friday nights will be boring no more.
      The screen is composed of 14 million pixels.
      Thanks to its low energy consumption design, your bills will stay low.
      \uD83D\uDCB0 Price: 300.99 €
      Reference: W2C

      """;
    ArrayList<Product> catalogue = CatalogueResource.PRODUCTS;

    String formattedCatalogue = catalogueFormatter.productFormat(catalogue);

    assertThat(formattedCatalogue).isEqualTo(expectedFormattedCatalogue);
  }

  @Test
  void productDetailsFormatTest() {
    String expectedFormattedProduct = """
      \uD83D\uDCFA
      \uD83D\uDCB0 Price: 300.99 €
      Reference: W2C
      0 left

      SUMMARY:
      Glamorous panoramic television, 13 inches

      DESCRIPTION:
      With this panoramic television, your friday nights will be boring no more.
      The screen is composed of 14 million pixels.
      Thanks to its low energy consumption design, your bills will stay low.
      """;
    Product product = CatalogueResource.PRODUCT;

    String formattedProduct = catalogueFormatter.productDetailsFormat(product);

    assertThat(formattedProduct).isEqualTo(expectedFormattedProduct);
  }

}