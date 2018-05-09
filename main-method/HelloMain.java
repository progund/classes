public class HelloMain {
  
  public static void main(String[] args) {

    HelloSayer hello;
    if (args.length != 0) {
      hello = new HelloSayer(args[0]);
    } else {
      hello = new HelloSayer();
    }
    hello.greet();
  }
}
