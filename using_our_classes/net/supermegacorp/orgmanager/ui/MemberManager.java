package net.supermegacorp.orgmanager.ui;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import net.supermegacorp.orgmanager.domain.Member;

public class MemberManager {

  private CLI cli;
  private List<Member> members;
  private String membersFile = "members.data";

  public MemberManager() {
    cli = new CLI();
    members = new ArrayList<Member>();
    readFromFile();
  }

  public void welcome() {
    cli.msgln("Starting Member manager");
  }

  public void goodbye() {
    cli.msgln("Good bye");
  }

  public void menuLoop() {
    /*
     * Add some kind of loop here - hint, use while.
     *
     * Put the loop around all code in this method,
     * so that everything will be repeated for ever
     * until the user chooses menu option "3 - to quit."
     */

    /*
     * Present options to the user
     */
    cli.msgln("Menu");
    cli.msgln(" 1 - to add member");
    cli.msgln(" 2 - to list members");
    cli.msgln(" 3 - to quit");

    /*
     * Read command from user
     */
    String command = cli.askUser("Enter your choice");

    /*
     * Based on command, take different actions
     */
    if (command.equals("1")) {
      Member m = cli.readNewMember();
      cli.msgln("Created member: " + m);
      /*
       * add the member to the ArrayList
       */
    } else if (command.equals("2")) {
      cli.msgln("No members - you need to add code to add member");
      cli.msgln("and then code to print 'em out");
      /* loop through the ArrayList and print the members,
         hint: the CLI class has an (instance) method called outputMember
      */

      for (Member m : members) {
        cli.outputMember(m);
      }
    } else if (command.equals("3")) {
      cli.msgln("Good bye...");
      saveToFile();
      /* break out of the loop */
      /* Three ways (chose one):
         1. use the keyword break
         2. use the keyword return (you can return from a void method!)
         3. loop (above) over a boolean variable which you (here) se to false
      */
    } else {
      cli.msgln("Invalid choice?");
    }
  }

  //
  // Below you'll find methods dealing with storing and reading back
  // users from a file (members.data)
  //

  private void saveToFile() {
    try {
      FileOutputStream fos = new FileOutputStream(membersFile);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(members);
      oos.close();
      oos.flush();
      fos.flush();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings({"unchecked"})
  private void readFromFile() {
    try {
      FileInputStream fis = new FileInputStream(membersFile);
      ObjectInputStream ois = new ObjectInputStream(fis);
      Object readObject = ois.readObject();
      members = (ArrayList) readObject;
      ois.close();
      fis.close();
    } catch (java.io.FileNotFoundException c) {
      cli.msgln("File not found");
      return;
    } catch (IOException ioe) {
      ioe.printStackTrace();
      return;
    } catch (ClassNotFoundException c) {
      cli.msgln("Class not found");
      c.printStackTrace();
      return;
    }
  }
}
