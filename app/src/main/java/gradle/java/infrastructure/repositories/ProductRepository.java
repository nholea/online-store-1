package gradle.java.infrastructure.repositories;

import gradle.java.domain.Product;
import java.util.ArrayList;

public interface ProductRepository {

  ArrayList<Product> findAll();

}
