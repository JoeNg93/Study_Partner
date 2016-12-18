package objects;

/**
 * Created by joenguyen on 9/18/16.
 */
public class Subject {

  private int id;
  private String name;
  private int credits;
  private Semester semester;
  private Teacher teacher;

  public Subject() {

  }

  public Subject(String name, int credits, Semester semester, Teacher teacher) {
    this.name = name;
    this.credits = credits;
    this.semester = semester;
    this.teacher = teacher;
  }

  public Subject(int id, String name, int credits, Semester semester, Teacher teacher) {
    this.id = id;
    this.name = name;
    this.credits = credits;
    this.semester = semester;
    this.teacher = teacher;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public int getCredits() {
    return credits;
  }

  public void setSemester(Semester semester) {
    this.semester = semester;
  }

  public Semester getSemester() {
    return semester;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
