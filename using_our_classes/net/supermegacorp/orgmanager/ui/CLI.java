package net.supermegacorp.orgmanager.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import net.supermegacorp.orgmanager.domain.Member;

/**
 * Represents an object for a command line interface with the user.
 *
 * This class can be used to create an object which lets you interface
 * with the user via a text-based interface, using Stdin and Stdout.
 *
 * The object has methods for promting the user with a question and
 * returning the user's input via the command line interactively.
 */
public class CLI {

  /*
   * Private variables used when reading/writing from/to user
   *
   * We're using *Stream to make it easier to replace stdout/stdin
   * with other streams in the future
   *
   */
  private PrintStream out = System.out;
  private InputStream in = System.in;
  private Scanner scanner = new Scanner(in);

  /**
   * Simply outputs a String without a trailing newline, effectively
   * wrapping System.out.print()
   *
   * @param phrase The String to output
   */
  public void msg(String phrase) {
    out.print(phrase);
  }

  /**
   * Simply outputs a String phrase with a trailing newline,
   * effectively wrapping System.out
   *
   * @param phrase The String to output with a trailing newline
   */
  public void msgln(String phrase) {
    out.println(phrase);
  }

  /**
   * Prompts the user with a String (without a trailing newline)
   * and reads a line from user.
   *
   * @param phrase The String to prompt the user with
   * @return The String read from the user (the user's reply)
   */
  public String askUser(String phrase) {
    msg(phrase);
    return scanner.nextLine();
  }

  /**
   * Reads a line from user. The line is returned.
   *
   * @return The String the user enters interactively
   */
  public String askUser() {
    return scanner.nextLine();
  }

  /**
   * Asks the user to enter the required fields, creates a new
   * Member instance and returns that member instance.
   *
   * @return A reference to a new Member, created with the user's input
   * as arguments to the Member constructor
   */
  public Member readNewMember() {
    msgln("Enter values for new Member");
    String name = askUser("* name: ");
    String email = askUser("* email: ");
    Member m = new Member(name, email);
    return m;
  }

  /**
   * Outputs a Member instance. This is equivalent to calling
   * System.out.println(m) where m is a reference to a Member instance.
   *
   * @param m The member to output (with a trailing newline).
   */
  public void outputMember(Member m) {
    msgln("Member: " + m);
  }
}
