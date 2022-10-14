package gradle.java;

import java.util.ArrayList;
import java.util.Scanner;


public class CatalogueFormater {

  ProductsToChooseExplore productsToChooseExplore = new ProductsToChooseExplore();
  DecideStepToContinue decideStepToContinue = new DecideStepToContinue();
  ProductWarehouse productWarehouse = new ProductWarehouse();
  CatalogueFormater catalogueFormater = new CatalogueFormater();

  public String format(ArrayList<Product> catalogue) {
    for (Product product : catalogue) {
      System.out.println(product.getImage());
      System.out.println(product.getDescription());
      System.out.println(product.getFeaturedAttribute());
      System.out.println(product.getPrice());
      System.out.println(product.getReference());
      System.out.println("\n");
    }
    productsToChooseExplore.productsToChooseExplore();
    decideWhatToDoNext();
    return "";
  }

  public void decideWhatToDoNext() {
    System.out.println("\n");
    System.out.println("¿What would you like to do next?");
    String nextOption1 = "1 - Add product to cart";
    String nextOption2 = "2 - Keep browsing products";
    System.out.println(nextOption1);
    System.out.println(nextOption2);

    Scanner myObj = new Scanner(System.in);
    String opcionChoosed = myObj.nextLine();

    if (opcionChoosed.equals("1")) {
      System.out.println();
    } else if (opcionChoosed.equals("2")) {
      ArrayList<Product> catalogue = productWarehouse.findAll();
      String formattedCatalogue = catalogueFormater.format(catalogue);
      System.out.println(formattedCatalogue);
    } else {
      System.out.println("Sorry, you have to choose one valid option");
    }
  }

}
