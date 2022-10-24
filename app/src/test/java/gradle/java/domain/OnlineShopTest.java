package gradle.java.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import gradle.java.CatalogueResource;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OnlineShopTest {

  @Mock
  ProductRepository productRepository;

  @Mock
  Presentation presentation;

  @Mock
  Requester requester;

  @InjectMocks
  OnlineShop onlineShop;

  ArrayList<Product> CATALOGUE = new ArrayList<>(Arrays.asList(new Product(
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


  @Test
  void showProductsTest() {
    ArgumentCaptor<ArrayList<Product>> productCaptor = ArgumentCaptor.forClass(ArrayList.class);
    ArrayList<Product> expectedCatalogue = CatalogueResource.PRODUCTS;
    when(productRepository.findAll()).thenReturn(CATALOGUE);

    onlineShop.showProducts();

    InOrder inOrder = inOrder(productRepository, presentation);

    inOrder.verify(productRepository).findAll();
    inOrder.verify(presentation).showProducts(CATALOGUE);
    verify(presentation).showProducts(productCaptor.capture());
    ArrayList<Product> catalogue = (productCaptor.getValue());

    assertThat(catalogue).usingRecursiveComparison().isEqualTo(expectedCatalogue);

  }

  @Test
  void showProductDetailsWhenFindAnExistingReference() {
    ArrayList<Product> catalogue = CatalogueResource.PRODUCTS;
    String productReference = "W2C";
    when(requester.demand()).thenReturn(productReference);
    when(productRepository.findByReference(productReference)).thenReturn(catalogue.get(0));

    onlineShop.chooseProductByReference();


  }
}