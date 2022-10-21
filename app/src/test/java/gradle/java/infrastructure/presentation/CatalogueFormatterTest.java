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
    String expectedFormattedCatalogue = "\uD83D\uDCFA\n"
      + "Glamorous panoramic television, 13 inches\n"
      + "With this panoramic television, your friday nights will be boring no more.\n"
      + "The screen is composed of 14 million pixels.\n"
      + "Thanks to its low energy consumption design, your bills will stay low.\n"
      + "\uD83D\uDCB0 Price: 300.99 €\n"
      + "Reference: W2C\n"
      + "\n"
      + "\uD83C\uDFB9\n"
      + "Untuned musical keyboard, 4 octaves\n"
      + "Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour \n"
      + "will be ready to move to a building far away from you.\n"
      + "\uD83D\uDCB0 Price: 1003.0 €\n"
      + "Reference: X4A\n"
      + "\n"
      + "\uD83D\uDCFA\n"
      + "Glamorous panoramic television, 13 inches\n"
      + "With this panoramic television, your friday nights will be boring no more.\n"
      + "The screen is composed of 14 million pixels.\n"
      + "Thanks to its low energy consumption design, your bills will stay low.\n"
      + "\uD83D\uDCB0 Price: 300.99 €\n"
      + "Reference: W2C\n"
      + "\n";
    ArrayList<Product> catalogue = CatalogueResource.products;

    String formattedCatalogue = catalogueFormatter.productFormat(catalogue);

    assertThat(formattedCatalogue).isEqualTo(expectedFormattedCatalogue);
  }

}