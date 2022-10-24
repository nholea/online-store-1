package gradle.java.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
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
    ArgumentCaptor<ArrayList<Product>> catalogueCaptor = ArgumentCaptor.forClass(ArrayList.class);
    ArrayList<Product> expectedCatalogue = CatalogueResource.PRODUCTS;
    when(productRepository.findAll()).thenReturn(CATALOGUE);

    onlineShop.showProducts();
    InOrder inOrder = inOrder(productRepository, presentation);
    verify(presentation).showProducts(catalogueCaptor.capture());

    inOrder.verify(productRepository).findAll();
    inOrder.verify(presentation).showProducts(CATALOGUE);
    ArrayList<Product> catalogue = catalogueCaptor.getValue();
    assertThat(catalogue).usingRecursiveComparison().isEqualTo(expectedCatalogue);

  }

  @Test
  void showProductDetailsWhenFindAnExistingReference() {
    ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);
    Product expectedProduct = CatalogueResource.PRODUCTS.get(0);
    String productReference = "W2C";
    when(requester.demand()).thenReturn(productReference);
    when(productRepository.findByReference(productReference)).thenReturn(CATALOGUE.get(0));

    onlineShop.chooseProductByReference();
    verify(presentation).showProductDetails(productCaptor.capture());
    Product product = (productCaptor.getValue());

    assertThat(product).usingRecursiveComparison().isEqualTo(expectedProduct);
  }

  @Test
  void throwAnExceptionWhenTheProductReferenceDoesNotExist() {
    String productReference = "P5L";
    when(requester.demand()).thenReturn(productReference);
    when(productRepository.findByReference(productReference))
      .thenThrow(new RuntimeException("Product with this reference does not exist in our storage"));

    assertThatThrownBy(() -> onlineShop.chooseProductByReference())
      .isInstanceOf(RuntimeException.class)
      .hasMessageContaining("Product with this reference does not exist in our storage");
    verify(presentation, never()).showProductDetails(any(Product.class));
  }

  @Test
  void whenCustomerChoosesOptionToContinueShopping() {
    String customerChoice = "2";
    when(requester.demand()).thenReturn(customerChoice);

    onlineShop.keepShopping();

    verify(presentation, atLeastOnce()).showProducts(any());
    verify(presentation, atLeastOnce()).showProductDetails(any());

  }
}