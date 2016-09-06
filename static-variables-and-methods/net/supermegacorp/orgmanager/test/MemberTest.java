package net.supermegacorp.orgmanager.test;

import net.supermegacorp.orgmanager.Member;

public class MemberTest {

    public static void main(String[] args) {

      Member ada     = new Member("Ada", "ada@lovelace.edu");
      System.out.println(ada);

      Member charles = new Member("Charles", "charles __AT__ babbage.net");
      System.out.println(charles);

      /*
        Member noone = new Member("Dummy", null);
        System.out.println(noone);
      */
      
      System.out.println("Ada's name:     " + ada.name());
      System.out.println("Ada's email:    " + ada.email());
      System.out.println("Charle's name:  " + charles.name());
      System.out.println("Charle's email: " + charles.email());


      
    }
    
}
