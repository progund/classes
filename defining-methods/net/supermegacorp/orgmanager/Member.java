package net.supermegacorp.orgmanager;

public class Member {

  private String name;
  private String email;

  public Member(String name, String email) {
    this(name);
    setEmail(email);
  }

 
  public Member(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    if (email.contains("@")) {
      this.email = email;
    }
  }
  
  public String toString() {
    return name + " " + email;
  }
    
  public String name() {
    return name;
  }
  
  public String email() {
    return email;
  }

}
