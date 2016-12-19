package objects;

import java.time.LocalTime;

/**
 * Created by joenguyen on 9/18/16.
 */
public class TimeTable {

  private int id;
  private Subject subject;
  private int day;
  private String roomNumber;
  private LocalTime startTime;
  private LocalTime endTime;
  private Teacher teacher;
  private Semester semester;

  public TimeTable() {

  }

  public TimeTable(int id, Subject subject, int day, String roomNumber, LocalTime startTime, LocalTime endTime, Teacher teacher, Semester semester) {
    this.id = id;
    this.subject = subject;
    this.day = day;
    this.roomNumber = roomNumber;
    this.startTime = startTime;
    this.endTime = endTime;
    this.teacher = teacher;
    this.semester = semester;

  }

  public TimeTable(Subject subject, int day, String roomNumber, LocalTime startTime, LocalTime endTime, Teacher teacher, Semester semester) {
    this(-1, subject, day, roomNumber, startTime, endTime, teacher, semester);
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public Semester getSemester() {
    return semester;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getDay() {
    return day;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public int getId() {
    return id;
  }
}
