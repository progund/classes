import java.time.LocalDate;
import java.time.Period;

/**
 * A class representing a Student.
 */
public class Student {

  private String name;
  private LocalDate birthDate;

  /**
   * Constructs a new Student.
   * @param name The name of the new Student
   * @param birthDate The birthDate of the new Student
   */
  public Student(String name, LocalDate birthDate) {
    this.name = name;
    this.birthDate = birthDate;
  }

  /**
   * Returns the name of this Student
   * @return The name of this Student
   */
  public String name() {
    return name;
  }

  /**
   * Returns the age of this Student
   * @return The age of this Student
   */
  public int age() {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  /**
   * Returns a String representing this Student on the form<br>
   * Peter Parker (46 years old)
   * @return This student as a String summary
   */
  @Override
  public String toString() {
    return new StringBuilder(name)
      .append(" (")
      .append(age())
      .append(" years old)")
      .toString();
  }
}
