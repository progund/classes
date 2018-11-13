package org.juneday.time;

public class Minute extends TimeUnit {
  public Minute(int value, TimeUnit nextUnit) {
    super(60, value, nextUnit);
  }
}
