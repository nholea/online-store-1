package gradle.java.domain;

import gradle.java.infrastructure.repositories.StringRepository;

public class Menu {

  public static String addToCartOrKeepBrowsing() {
    StringBuilder menuMessage = new StringBuilder();
    menuMessage.append(StringRepository.NEXT_STEP + "\n");
    menuMessage.append(StringRepository.ADD_PRODUCT + "\n");
    menuMessage.append(StringRepository.SHOW_PRODUCTS);

    return menuMessage.toString();
  }

}
