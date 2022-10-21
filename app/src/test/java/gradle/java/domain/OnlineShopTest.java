package gradle.java.domain;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import gradle.java.CatalogueResource;
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

    ArrayList<Product> catalogue = CatalogueResource.products;

    when(productRepository.findAll()).thenReturn(catalogue);

    onlineShop.showProducts();

    InOrder inOrder = inOrder(productRepository, presentation);

    inOrder.verify(productRepository).findAll();
    inOrder.verify(presentation).showProducts(catalogue);
  }
}