package net.supermegacorp.orgmanager.ui;

import net.supermegacorp.orgmanager.Member;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;

public class CLI{

    /*
     * Private variables used when reading/writing from/to user
     *
     * We're using *Stream to make it easier to replace stdout/stdin
     * with other streams in the future
     *
     */
    private PrintStream out      = System.out;
    private InputStream in       = System.in;
    private Scanner     scanner  = new Scanner(in);

    /*
     * 
     * Simply outputs the String phrase - without a trailing newline
     *
     */
    public void msg(String phrase){
        out.print(phrase);
    }
    

    /*
     * 
     * Simply outputs the String phrase - with a trailing newline
     *
     */
    public void msgln(String phrase){
        out.println(phrase);
    }
    

    /*
     * Outputs the String phrase (without a trailing newline)
     * and reads a line from user. The line is returned.
     *
     */
    public String askUser(String phrase){
        msg(phrase);
        return scanner.nextLine();
    }
    
    /*
     * Reads a line from user. The line is returned.
     *
     */
    public String askUser() {
        return scanner.nextLine();
    }

    /*
     * Asks the user to enter the required fields, creates a new
     * Member instance and returns that member instance.
     *
     */
    public Member readNewMember() {
        msgln("Enter values for new Member");
        String name  = askUser("* name: "); 
        String email = askUser("* email: "); 
        Member m     = new Member(name, email);
        return m;
    }

    /*
     * Outputs a Member instance 
     *
     */
    public void outputMember(Member m) {
        msgln("Member: " + m);
    }
    

    
    
}
