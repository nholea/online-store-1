package gradle.java.infrastructure.interactions;

import java.util.Scanner;

public class CustomerRequest {

  public CustomerRequest() {

  }

  public String scanner() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }


}
