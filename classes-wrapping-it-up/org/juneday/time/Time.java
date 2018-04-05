package org.juneday.time;

/**
 * <p>Represents a time between 00:00:00 and 23:59:59.</p>
 * <p>Serves as an example of information hiding
 * (time is internally stored as seconds) and encapsulation
 * (a time has both data and behavior, like tick())</p>
 */
public class Time {
  
  private int secs;

  /* Checks that the values of hour, minute and second
   * are valid:
   * 0 <= hour < 24
   * 0 <= minute < 60 
   * 0 <= second < 60
   */
  private void checkTime(int hour, int minute, int second) {
    if (hour > 23 || hour < 0 ||
        minute > 59 || minute < 0 ||
        second > 59 || second < 0) {
      throw new IllegalArgumentException
        (new StringBuilder("Bad time: ")
         .append(hour)
         .append(":")
         .append(minute)
         .append(":")
         .append(second)
         .toString());      
    }
  }

  /** Constructs a new time
   * @param hour An int representing the hours of the time
   * @param minute An int representing the minutes of the time
   * @param second An int representing the seconds of the time
   * @throws IllegalArgumentException if any of the folowing isn't true:
   * <ul>
   * <li>0 <= hour < 24</li>
   * <li>0 <= minute < 60</li>
   * <li>0 <= second < 60</li>
   * </ul>
   */
  public Time(int hour, int minute, int second) {
    setTime(hour, minute, second);
  }

  /**
   * Sets this time to a new time
   * @param hour An int representing the hours of the time
   * @param minute An int representing the minutes of the time
   * @param second An int representing the seconds of the time
   * @throws IllegalArgumentException if any of the folowing isn't true:
   * <ul>
   * <li>0 <= hour < 24</li>
   * <li>0 <= minute < 60</li>
   * <li>0 <= second < 60</li>
   * </ul>
   */
  public void setTime(int hour, int minute, int second) {
    checkTime(hour, minute, second);
    secs = hour * 60 * 60 + minute * 60 + second;    
  }

  /**
   * Ticks this Time one second forward.
   */
  public void tick() {
    secs = (secs + 1) % (60 * 60 * 24);
  }

  /**
   * Returns the hours of this Time
   * @return The hours of this Time
   */
  public int hours() {
    return secs / 60 / 60;
  }

  /**
   * Returns the minutes of this Time
   * @return The minutes of this Time
   */
  public int minutes() {
    return secs / 60 % 60;
  }

  /**
   * Returns the seconds of this Time
   * @return The seconds of this Time
   */
  public int seconds() {
    return secs % 60;
  }

  /**
   * Returns this Time as a String on the format HH:mm:ss (in 24h time)
   * @return This Time as a String on the format HH:mm:ss (in 24h time)
   * for instance <code>23:59:59</code>
   */
  @Override
  public String toString() {
    return String
      .format("%02d:%02d:%02d",
              hours(),
              minutes(),
              seconds());
  }
  
}
