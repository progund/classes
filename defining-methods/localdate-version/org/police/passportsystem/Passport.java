package org.police.passportsystem;

import java.time.LocalDate;
import java.time.Period;

public class Passport {

  private String name;
  private LocalDate birth;

  public Passport(String name, String birth) {
    this.name  = name;
    this.birth = LocalDate.parse(birth);
  }

  public String toString() {
    return name + " " + birth +
      " (" + (hasAdultHolder() ? "adult)" : "child)");
  }

  public String name() {
    return name;
  }

  public boolean hasAdultHolder() {
    return Period.between(birth, LocalDate.now()).getYears() > 17;
  }
  
  public String birth() {
    return birth.toString();
  }

}
