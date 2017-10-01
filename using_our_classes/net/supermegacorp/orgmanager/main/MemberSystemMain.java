package net.supermegacorp.orgmanager.main;

import net.supermegacorp.orgmanager.Member;
import net.supermegacorp.orgmanager.ui.CLI;
import net.supermegacorp.orgmanager.ui.MemberManager;

public class Main{

    public static void main(String[] args) {

      MemberManager manager = new MemberManager();
      
      /*
       * Show a starting message to the user
       */
      manager.welcome();

      /*
       * Enter member managing loop
       */
      manager.menuLoop();
      
      /*
       * Show good bye message
       */
      manager.goodbye();


    }

}
