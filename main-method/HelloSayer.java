public class HelloSayer {

  private String name;

  public HelloSayer() {
    name = "user"; 
  }

  public HelloSayer(String name) {
    this.name = name;
  }

  public void greet() {
    System.out.printf("Hello world %s\n", name);
  }
}
