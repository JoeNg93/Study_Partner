package objects;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by joenguyen on 12/5/16.
 */
public class Exam {
  private int id;
  private Subject subject;
  private LocalTime startTime;
  private LocalDate date;
  private String description;

  public Exam(int id, Subject subject, LocalTime startTime, LocalDate date, String description) {
    this.id = id;
    this.subject = subject;
    this.startTime = startTime;
    this.date = date;
    this.description = description;
  }

  public Exam(Subject subject, LocalTime startTime, LocalDate date, String description) {
    this(0, subject, startTime, date, description);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }
}
