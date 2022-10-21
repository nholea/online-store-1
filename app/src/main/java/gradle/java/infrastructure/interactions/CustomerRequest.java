package gradle.java.infrastructure.interactions;

import java.util.Scanner;

public class CustomerRequest implements Requester {
  
  @Override
  public String demand() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
