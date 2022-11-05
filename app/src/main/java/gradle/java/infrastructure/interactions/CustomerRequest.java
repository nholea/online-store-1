package gradle.java.infrastructure.interactions;

import gradle.java.domain.Requester;
import java.util.Scanner;

public class CustomerRequest implements Requester {

  @Override
  public void sendMessage(String message) {
    System.out.println(message);
  }

  @Override
  public String demand() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
