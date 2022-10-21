package gradle.java.domain;

import java.util.ArrayList;

public interface Presentation {

  void showProducts(ArrayList<Product> catalogue);

  void showProductDetails(Product product);

  void nextStepsMessage();
}


