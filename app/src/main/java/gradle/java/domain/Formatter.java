package gradle.java.domain;

import java.util.ArrayList;

public interface Formatter {

  String productFormat(ArrayList<Product> catalogue);

  String productDetailsFormat(Product product);

}
