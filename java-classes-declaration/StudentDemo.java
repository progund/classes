import java.time.LocalDate;

public class StudentDemo {
  public static void main(String[] args) {
    Student me = new Student("Rikard Fröberg", LocalDate.of(1971, 11, 24));
    System.out.println(me);
  }
}
