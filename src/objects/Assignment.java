package objects;

import java.time.LocalDate;

/**
 * Created by joenguyen on 9/23/16.
 */
public class Assignment {

  private int id;
  private String name;
  private LocalDate deadLine;
  private Subject subject;
  private String description;

  public Assignment(int id, String name, LocalDate deadLine, Subject subject, String description) {
    this.id = id;
    this.name = name;
    this.deadLine = deadLine;
    this.subject = subject;
    this.description = description;
  }

  public Assignment(String name, LocalDate deadLine, Subject subject, String description) {
    this(-1, name, deadLine, subject, description);
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setDeadLine(LocalDate deadLine) {
    this.deadLine = deadLine;
  }

  public LocalDate getDeadLine() {
    return deadLine;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }
}
