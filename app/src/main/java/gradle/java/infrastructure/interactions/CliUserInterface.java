package gradle.java.infrastructure.interactions;

import gradle.java.domain.UserInterface;
import java.util.Scanner;

public class CliUserInterface implements UserInterface {

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
