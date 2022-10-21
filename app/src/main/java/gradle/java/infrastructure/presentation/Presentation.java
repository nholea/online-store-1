package gradle.java.infrastructure.presentation;

import gradle.java.domain.Product;
import java.util.ArrayList;

public interface Presentation {

  void showProducts(ArrayList<Product> catalogue);

  void showProductDetails(Product product);

  void nextStepsMessage();
}


