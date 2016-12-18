import utilities.Database;

import java.sql.*;

public class Test {

  public static void main(String[] args){
    Connection conn = Database.connectStudyPartnerDB();

    if (conn != null) {
      try {
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT subjects.name AS subject, teachers.name AS teacher, " +
            "semesters.name AS semester FROM subjects INNER JOIN teachers ON subjects.teacher_id = teachers.id " +
            "INNER JOIN semesters ON subjects.semester_id = semesters.id");

        while (result.next()) {
          String subject = result.getString("subject");
          String teacher = result.getString("teacher");
          String semester = result.getString("semester");
          System.out.printf("%s - %s - %s\n", subject, teacher, semester);
        }
      } catch (SQLException exc) {
        exc.printStackTrace();
      } finally {
        try {
          conn.close();
        } catch (SQLException exc) {
          exc.printStackTrace();
        }
      }
    } else {
      System.out.println("Cannot connect to the database");
    }

  }

}

