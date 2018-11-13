package org.juneday.time;

public class Time {

  
  private TimeUnit hours;
  private TimeUnit minutes;
  private TimeUnit seconds;

  public Time(int hour, int minute, int second) {
    this.hours = new Hour(hour);
    this.minutes = new Minute(minute, hours);
    this.seconds = new Second(second, minutes);
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
