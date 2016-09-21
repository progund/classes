package net.supermegacorp.orgmanager.main;

import net.supermegacorp.orgmanager.Member;
import net.supermegacorp.orgmanager.ui.CLI;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        /*
         * Create a CLI object to use when communicating with user
         */
        CLI    cli = new CLI();

        /*
         * Create an ArrayList to store Members
         */

        /*
         * Give some starting message to the user
         */
        cli.msgln("Starting Member manager");


        /* 
         * Add some kind of loop here - hint, use while 
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
            Member m   = cli.readNewMember();
            /*
             * add the member to the ArrayList
             */
        } else if (command.equals("2")) {
            cli.msgln("No members");
            /* loop through the ArrayList and print the members, 
               hint: the CLI class has an (instance) method called outputMember */
        } else if (command.equals("3")) {
            cli.msgln("Good bye...");
            System.exit(0);
        } else {
            cli.msgln("What do you want with your life?");
        }

    }

}
