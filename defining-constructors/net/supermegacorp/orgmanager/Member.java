package net.supermegacorp.orgmanager;

public class Member {

  private String name;
  private String email;

  public Member(String name, String email) {
    this(name);
    if (email.contains("@")) {
      this.email = email;
    }
  }

 
  public Member(String name) {
    this.name = name;
  }

  public String toString() {
    return name + " " + email;
  }
    

}
