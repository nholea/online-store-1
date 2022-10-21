package gradle.java.infrastructure.repositories;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductWareHouse implements ProductRepository {

  private final ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television,",
      "With this panoramic television, your friday nights will be boring no more.",
      " 13 inches",
      300.99,
      "W2C"),
    new Product(
      "\uD83C\uDFB9",
      "Untuned musical keyboard,",
      "Tired of your noisy neighbourgh? Play this untuned musical keyboard for two hours at home and your neighbour " +
        "will be ready to move to a building far away from you.",
      " 4 octaves",
      1003.00,
      "X4A"),
    new Product(
      "\uD83D\uDCFA",
      "Glamorous panoramic television,",
      "With this panoramic television, your friday nights will be boring no more.",
      " 13 inches",
      300.99,
      "W2C")));


  @Override
  public ArrayList<Product> findAll() {
    return products;
  }

  @Override
  public Product findByReference(String reference) {
    for (Product product : products) {
      if (product.showReference().equals(reference)) {
        return product;
      }
    }
    throw new RuntimeException(StringRepository.PRODUCT_REFERENCE_NOT_FOUND);
  }

  @Override
  public HashMap<String, Integer> setProductUnitsByReference() {
    HashMap<String, Integer> productStock = new HashMap<>();
    ArrayList<Product> catalogue = findAll();

    for (Product product : catalogue) {
      if (!productStock.containsKey(product.showReference())) {
        productStock.put(product.showReference(), 1);
      } else {
        productStock.put(product.showReference(), productStock.get(product.showReference()) + 1);
      }
    }
    return productStock;
  }

  @Override
  public int getProductUnitsInStock(String reference) {
    HashMap<String, Integer> productStock = setProductUnitsByReference();
    for (String productReference : productStock.keySet()) {
      if (productStock.containsKey(reference)) {
        return productStock.get(reference);
      }
    }
    throw new RuntimeException(StringRepository.PRODUCT_REFERENCE_NOT_FOUND);
  }

}
