package gradle.java.domain;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductRepository {

  ArrayList<Product> findAll();

  Product findByReference(String reference);

  HashMap<String, Integer> setProductUnitsByReference();

  int getProductUnitsInStock(String reference);

}
