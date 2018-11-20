package org.police.passportsystem.test;

import org.police.passportsystem.Passport;

public class PassportTest {

  public static void main(String [] args) {

    Passport p = new Passport("Adam", "2000-11-21");
    System.out.println(p);
    System.out.println(p.hasAdultHolder());
        
  }
    
}
