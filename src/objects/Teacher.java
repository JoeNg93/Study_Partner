package objects;

/**
 * Created by joenguyen on 9/18/16.
 */
public class Teacher {

  private int id;
  private String name;
  private String phoneNumber;

  public Teacher() {

  }

  public Teacher(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public Teacher(int id, String name, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
