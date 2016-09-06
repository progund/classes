package org.police.passportsystem;

public class Passport {

  private String  name;
  private String  birth;
  
  public Passport(String name, String birth) {
    this.name  = name;
    this.birth = birth;
  }

  public String toString() {
    return name + " " + birth;
  }
}
