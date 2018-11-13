package org.juneday.time;

public class Second extends TimeUnit {
  public Second(int value, TimeUnit nextUnit) {
    super(60, value, nextUnit);
  }
}
