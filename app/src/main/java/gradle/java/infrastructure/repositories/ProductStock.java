package gradle.java.infrastructure.repositories;

import gradle.java.domain.Product;
import gradle.java.domain.ProductRepository;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductStock {

  private final ProductRepository productRepository;


  private HashMap<String, Integer> productUnitsInStock = new HashMap<>();

  public ProductStock(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  private void setProductUnitsInStock() {
    ArrayList<Product> catalogue = productRepository.findAll();

    for (Product product : catalogue) {
      if (!productUnitsInStock.containsKey(product.showReference())) {
        productUnitsInStock.put(product.showReference(), 1);
      } else {
        productUnitsInStock.put(product.showReference(), productUnitsInStock.get(product.showReference()) + 1);
      }
    }

  }

  public int getProductUnitsInStock(String reference) {
    setProductUnitsInStock();
    for (String productReference : productUnitsInStock.keySet()) {
      if (productUnitsInStock.containsKey(reference)) {
        return productUnitsInStock.get(reference);
      }
    }
    throw new RuntimeException(StringRepository.PRODUCT_REFERENCE_NOT_FOUND);
  }

  public static void main(String[] args) {

    ProductStock stock = new ProductStock(new ProductWareHouse());
    System.out.println(stock.getProductUnitsInStock("W2C"));

  }

}
