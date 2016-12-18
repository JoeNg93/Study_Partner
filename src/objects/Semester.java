package objects;

/**
 * Created by joenguyen on 9/18/16.
 */
public class Semester {

  private int id;
  private String name;

  public Semester(String name) {
    this.name = name;
  }

  public Semester(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
