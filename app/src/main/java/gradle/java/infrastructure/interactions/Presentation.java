package gradle.java.infrastructure.interactions;

import gradle.java.domain.Product;
import java.util.ArrayList;

public interface Presentation {

  void showProducts(ArrayList<Product> catalogue);
}
