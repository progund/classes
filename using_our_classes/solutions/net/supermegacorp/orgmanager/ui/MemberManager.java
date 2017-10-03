package net.supermegacorp.orgmanager.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
     * Add some kind of loop here - hint, use while
     */
    while (true) {

      /*
       * Present options to the user
       */
      cli.msgln("Menu");
      cli.msgln(" 1 - to add member");
      cli.msgln(" 2 - to list members");
      cli.msgln(" 3 - to quit");
      cli.msgln(" 4 - to remove a member");

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

        members.add(m);

      } else if (command.equals("2")) {
        cli.msgln("No members?");
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
        /* Two ways (chose one):
           1. use the keyword break
           2. loop (above) over a boolean variable which you (here) se to false
        */
        break;
      } else if (command.equals("4")) {
        String name = cli.askUser("Name of member to remove?: ");
        if (name.equals("")) {
          cli.msgln("Invalid name");
        } else {
          /*Classic for loop - buggy */
          /*
            for (int i=0; i<members.size(); i++) {
            Member m = members.get(i);
            if (m.name().contains(name)) {
            cli.msg("Removing member: " + m);
            members.remove(m);
            }
            }
          */
          /*Classic for loop - buggy version with a crash*/
          /*
            int size = members.size();
            for (int i=0; i<size; i++) {
            Member m = members.get(i);
            if (m.name().contains(name)) {
            cli.msg("Removing member: " + m);
            members.remove(m);
            }
            }
          */
          /* 'New' for each loop */
          /*
            for (Member m : members) {
            if (m.name().contains(name)) {
            cli.msg("Removing member: " + m);
            members.remove(m);
            }
            }
          */
          /* Iterator */
          Iterator<Member> i = members.iterator();
          while (i.hasNext()) {
            Member m = i.next();
            if (m.name().contains(name)) {
              cli.msg("Removing member: " + m);
              i.remove();
            }
          }
          /* Alternative version - Using a lambda expression */
          members.removeIf(m -> m.name().contains(name));
        }
      } else {
        cli.msgln("Invalid choice?");
      }
    }
  }

  private void saveToFile() {
    try {
      // First time the application is run, create a file      
      File f = new File("first_run");
      if (!f.exists()) {
        f.createNewFile();
      }
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
      // If this is the first run, this file won't exist
      File f = new File("first_run");
      if (!f.exists()){
        System.out.println("Welcome! First run of this program!");
        return; // Don't read the members, the file
                // membersFile won't exist either!
      }
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
