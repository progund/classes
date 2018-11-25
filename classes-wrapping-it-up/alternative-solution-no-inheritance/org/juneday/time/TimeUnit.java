package org.juneday.time;

public class TimeUnit {
  
  private int limit;
  private int value;
  private TimeUnit nextUnit;
  
  public TimeUnit(int limit, int value) {
    this.limit = limit;
    if (value >= limit) {
      throw new IllegalArgumentException(this.getClass().getName() +
                                " cannot exceed " + limit);
    }
    if (value < 0) {
      throw new IllegalArgumentException(this.getClass().getName() +
                                         " value cannot be negative: " +
                                         value);
    }
    this.value = value;
  }

  public TimeUnit(int limit, int value, TimeUnit nextUnit) {
    this(limit, value);
    this.nextUnit = nextUnit;
  }

  public int intValue() {
    return value;
  }
  
  public void increment() {
    if (value + 1 == limit) {
      if (nextUnit != null) {
        nextUnit.increment();
      }
      value = 0;
    } else {
      value += 1;
    }
  }

  @Override
  public String toString() {
    return String.format("%02d", value);
  }  
  
}
