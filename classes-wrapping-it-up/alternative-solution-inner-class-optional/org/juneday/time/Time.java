package org.juneday.time;

import java.util.Optional;

public class Time {

  private static class TimeUnit {
  
    private int limit;
    private int value;
    private Optional<TimeUnit> nextUnit;
  
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
      this.nextUnit = Optional.empty();
    }

    public TimeUnit(int limit, int value, TimeUnit nextUnit) {
      this(limit, value);
      this.nextUnit = Optional.of(nextUnit);
    }

    public int intValue() {
      return value;
    }
  
    public void increment() {
      if (value + 1 == limit) {
        if (nextUnit.isPresent()) {
          nextUnit.get().increment();
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
  
  private TimeUnit hours;
  private TimeUnit minutes;
  private TimeUnit seconds;

  public Time(int hour, int minute, int second) {
    this.hours = new TimeUnit(24, hour);
    this.minutes = new TimeUnit(60, minute, hours);
    this.seconds = new TimeUnit(60, second, minutes);
  }

  public void tick() {
    seconds.increment();
  }

  public int seconds() {
    return seconds.intValue();
  }

  public int minutes() {
    return minutes.intValue();
  }
  
  public int hours() {
    return hours.intValue();
  }
  
  public String toString() {
    return new StringBuilder(hours.toString())
      .append(":")
      .append(minutes.toString())
      .append(":")
      .append(seconds.toString())
      .toString();
  }

}
