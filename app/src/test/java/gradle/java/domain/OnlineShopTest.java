package gradle.java.domain;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

  @InjectMocks
  OnlineShop onlineShop;


  @Test
  void showProductsTest() {
    Product product = new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television,",
      "With this panoramic television, your friday nights will be boring no more.",
      " 13 inches",
      300.99,
      "W2C");
    ArrayList<Product> catalogue = new ArrayList<>();
    catalogue.add(product);
    when(productRepository.findAll()).thenReturn(catalogue);

    onlineShop.showProducts();

    InOrder inOrder = inOrder(productRepository, presentation);

    inOrder.verify(productRepository).findAll();
    inOrder.verify(presentation).showProducts(catalogue);
  }
}