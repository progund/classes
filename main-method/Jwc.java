import java.io.*;
import java.nio.file.*;

// Counts the lines of stdin or files given as args
public class Jwc {
  public static void main(String[] args) {
    long lines = 0;
    if (args.length > 0) {
      countFile(args);
    } else {
      lines = readStdIn();
      System.out.println("Lines: " + lines);
    }
  }

  static long readStdIn() {
    return new BufferedReader(new InputStreamReader(System.in))
        .lines()
        .count();
  }
  
  static void countFile(String[] args) {
    for (String file : args) {
      try {
        long lines = Files.lines(Paths.get(file)).count();
        System.out.println(file + " Lines: " + lines);
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }
  }
}
