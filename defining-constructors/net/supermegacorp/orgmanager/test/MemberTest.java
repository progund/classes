package net.supermegacorp.orgmanager.test;

import net.supermegacorp.orgmanager.Member;

public class MemberTest {

  public static void main(String[] args) {

    Member ada = new Member("Ada", "ada@lovelace.edu");
    System.out.println(ada);

    Member charles = new Member("Charles", "charles __AT__ babbage.net");
    System.out.println(charles);
      
  }
    
}
