package org.juneday.main;

import org.juneday.time.Time;

public class TestTime {

  public static void main(String[] args) {
    Time t;
    t = new Time(23, 59, 59);
    assert t.toString().equals("23:59:59")
      : "Expected: 23:59:59. Got: " + t;
    System.out.println("Passed: 23:59:59 = " + t);
    t.tick();
    assert t.toString().equals("00:00:00")
      : "Expected: 00:00:00. Got: " + t;
    System.out.println("23:59:59 + 1 " + t);
    
    t = new Time(23, 49, 59);
    assert t.toString().equals("23:49:59")
      : "Expected: 23:49:59. Got: " + t;
    System.out.println("23:49:59 = " + t);
    t.tick();
    assert t.toString().equals("23:50:00")
      : "Expected: 23:50:00. Got: " + t;
    System.out.println("23:49:59 + 1 " + t);
    t = new Time(23, 49, 19);
    assert t.toString().equals("23:49:19")
      : "Expected: 23:49:19. Got: " + t;
    System.out.println("23:49:19 = " + t);
    t = new Time(13, 01, 02);
    assert t.toString().equals("13:01:02")
      : "Expected: 13:01:02. Got: " + t;
    assert t.hours() == 13
      : "Expected hours() to be 13, got: " + t.hours();
    assert t.minutes() == 1
      : "Expected minutes() to be 1, got: " + t.minutes();
    assert t.seconds() == 2
      : "Expected seconds() to be 2, got: " + t.seconds();
    System.out.println("13:01:02 = " + t);
    t = new Time(13, 59, 59);
    assert t.toString().equals("13:59:59")
      : "Expected: 13:59:59. Got: " + t;
    assert t.hours() == 13
      : "Expected hours() to be 13, got: " + t.hours();
    assert t.minutes() == 59
      : "Expected minutes() to be 59, got: " + t.minutes();
    assert t.seconds() == 59
      : "Expected seconds() to be 59, got: " + t.seconds();
    System.out.println("13:59:59 = " + t);
    t.tick();
    assert t.toString().equals("14:00:00")
      : "Expected: 14:00:00. Got: " + t;
    System.out.println("13:59:59 + 1 " + t);
    testIllegal(24, 1, 1);
    testIllegal(23, 60, 1);
    testIllegal(23, 59, 60);
    testIllegal(23, 59, -1);
    testIllegal(23, -1, 59);
    testIllegal(-1, 59, 59);

    testConstructorAndAccessors();
    System.out.println("Test of every legal time passed.");
    System.out.println("Showing visual clock at ultra speed");
    showAll();
  }

  static void showAll() {
    for (int h = 0; h < 24; h++) {
      for (int m = 0; m < 60; m++) {
        for (int s = 0; s < 60; s++) {
          System.out.print("\r" + new Time(h, m, s));
          if (m == 0 && s == 0 || m == 59 && s == 59) {
            try { Thread.currentThread().sleep(100); } catch (Exception i) {}
            System.out.println();
          }
          try { Thread.currentThread().sleep(1); } catch (Exception i) {}
        }
      }
    }
    System.out.println();
  }

  static void testConstructorAndAccessors() {
    for (int h = 0; h < 24; h++) {
      for (int m = 0; m < 60; m++) {
        for (int s = 0; s < 60; s++) {
          Time t = new Time(h, m, s);
          assert t.hours() == h &&
            t.minutes() == m &&
            t.seconds() == s :
          "Failed constructor and accessors for (" +
            h + ", " + m + ", " + s + ") Got: " +
            t.hours() + "hrs, " + t.minutes() + "mins, " +
            t.seconds() + "secs.";
        }
      }
    }
  }
  
  static void testIllegal(int hour, int minute, int second) {
    try {
      Time t = new Time(hour, minute, second);
      assert false : "Failed: " + hour + ", " + minute + ", " + second +
        " was accepted"; 
    } catch (IllegalArgumentException e) {
      System.err.println(e.getMessage() + " Passed!");
    }
  }
  
}
