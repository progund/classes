package org.police.passportsystem.test;

import java.util.Date;
import org.police.passportsystem.Passport;

public class PassportTest {

  public static void main(String [] args) {

    Passport p = new Passport();

    p.name  = "Adam";
    p.birth = new Date("1994-01-01");
        
  }
    
}
