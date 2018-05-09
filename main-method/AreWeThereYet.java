import java.util.Scanner;

public class AreWeThereYet {
  static Scanner stdin = new Scanner(System.in);
  public static void main(String[] args) {
    while (true) {
      System.out.println("Are we there yet?");
      try {
        String answer = stdin.nextLine();
        if ("yes".equals(answer)) {
          break;
        }
      } catch (Exception e) {
        System.err.println("Problem: " + e.getMessage());
        System.exit(1);
      }
    }
    System.out.println("There.");
  }
}
