package utilities;

import objects.*;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {

  private static final String JDBC_USERNAME = "root";
  private static final String JDBC_PASSWORD = "root";

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException exc) {
      exc.printStackTrace();
    }
  }

  public static Connection connectStudyPartnerDB() {
    String JDBC_URL = "jdbc:mysql://localhost:3306/study_partner1";
    Connection conn = null;

    try {
      conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    } catch (Exception exc) {
      exc.printStackTrace();
    }

    return conn;
  }

  /* ---------- SEMESTERS TABLE ---------- */
  public static void addSemester(Semester semester) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO semesters(name) VALUES (?)");
      preparedStatement.setString(1, semester.getName());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<Semester> getSemesters() {
    ArrayList<Semester> semesters = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM semesters");
      while (result.next()) {
        Semester semester = getSingleSemesterFromDB(result);
        semesters.add(semester);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return semesters;
  }

  public static Semester getSemesterAccordingToId(int semesterId) {
    Semester semester = null;
    Connection conn = connectStudyPartnerDB();
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM semesters WHERE id = ?");
      preparedStatement.setInt(1, semesterId);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        semester = getSingleSemesterFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return semester;
  }

  public static Semester getSemesterAccordingToName(String semesterName) {
    Connection conn = connectStudyPartnerDB();
    Semester semester = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM semesters WHERE name = ?");
      preparedStatement.setString(1, semesterName);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        semester = getSingleSemesterFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return semester;
  }

  public static int getTotalCreditsOfSemester(int semesterId) {
    ArrayList<Subject> totalSubjectsInSemester = getSubjectsAccordingToSemesterId(semesterId);
    int totalCredits = 0;

    for (Subject eachSubject : totalSubjectsInSemester) {
      totalCredits += eachSubject.getCredits();
    }

    return totalCredits;
  }

  public static void deleteSemesterAccordingToId(int semesterId) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM semesters WHERE id = ?");
      preparedStatement.setInt(1, semesterId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteSemesterAccordingToName(String semesterName) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM semesters WHERE name = ?");
      preparedStatement.setString(1, semesterName);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void updateSemesterAccordingToId(Semester semester) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE semesters SET name = ? WHERE id = ?");
      preparedStatement.setString(1, semester.getName());
      preparedStatement.setInt(2, semester.getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- TEACHERS TABLE ---------- */
  public static void addTeacher(Teacher teacher) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO teachers(name, phone_number) " +
          "VALUES (?, ?)");
      preparedStatement.setString(1, teacher.getName());
      preparedStatement.setString(2, teacher.getPhoneNumber());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<Teacher> getTeachers() {
    ArrayList<Teacher> teachers = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM teachers");
      while (result.next()) {
        Teacher teacher = getSingleTeacherFromDB(result);
        teachers.add(teacher);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return teachers;
  }

  public static Teacher getTeacherAccordingToId(int teacherId) {
    Teacher teacher = null;
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM teachers WHERE id = ?");
      preparedStatement.setInt(1, teacherId);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        teacher = getSingleTeacherFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return teacher;
  }

  public static Teacher getTeacherAccordingToName(String teacherName) {
    Connection conn = connectStudyPartnerDB();
    Teacher teacher = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM teachers WHERE name = ?");
      preparedStatement.setString(1, teacherName);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        teacher = getSingleTeacherFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return teacher;
  }

  public static void deleteTeacherAccordingToId(int teacherId) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM teachers WHERE id = ?");
      preparedStatement.setInt(1, teacherId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteTeacherAccordingToName(String teacherName) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM teachers WHERE name = ?");
      preparedStatement.setString(1, teacherName);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void updateTeacherAccordingToId(Teacher teacher) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE teachers SET name = ?, phone_number = ? " +
          "WHERE id = ?");
      preparedStatement.setString(1, teacher.getName());
      preparedStatement.setString(2, teacher.getPhoneNumber());
      preparedStatement.setInt(3, teacher.getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- SUBJECTS TABLE ---------- */
  public static void addSubject(Subject subject) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO subjects(name,credits,semester_id,teacher_id) " +
          "VALUES (?, ?, ?, ?)");
      preparedStatement.setString(1, subject.getName());
      preparedStatement.setInt(2, subject.getCredits());
      preparedStatement.setInt(3, subject.getSemester().getId());
      preparedStatement.setInt(4, subject.getTeacher().getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<Subject> getSubjects() {
    ArrayList<Subject> subjects = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM subjects");
      while (result.next()) {
        Subject subject = getSingleSubjectFromDB(result);
        subjects.add(subject);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return subjects;
  }

  public static Subject getSubjectAccordingToId(int subjectId) {
    Subject subject = null;
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects WHERE id = ?");
      preparedStatement.setInt(1, subjectId);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        subject = getSingleSubjectFromDB(result);
      }

    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return subject;
  }

  public static ArrayList<Subject> getSubjectsAccordingToSemesterId(int semesterId) {
    ArrayList<Subject> subjects = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects WHERE semester_id = ?");
      preparedStatement.setInt(1, semesterId);

      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        Subject subject = getSingleSubjectFromDB(result);
        subjects.add(subject);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return subjects;
  }

  public static ArrayList<Subject> getSubjectsAccordingToSemesterName(String semesterName) {
    Semester semester = Database.getSemesterAccordingToName(semesterName);
    return Database.getSubjectsAccordingToSemesterId(semester.getId());
  }

  public static ArrayList<Subject> getSubjectsAccordingToTeacherId(int teacherId) {
    ArrayList<Subject> subjects = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects WHERE teacher_id = ?");
      preparedStatement.setInt(1, teacherId);
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        Subject subject = getSingleSubjectFromDB(result);
        subjects.add(subject);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return subjects;
  }

  public static Subject getSubjectAccordingToName(String subjectName) {
    Connection conn = connectStudyPartnerDB();
    Subject subject = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM subjects WHERE name = ?");
      preparedStatement.setString(1, subjectName);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        subject = getSingleSubjectFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return subject;
  }

  public static void deleteSubjectAccordingToId(int subjectId) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM subjects WHERE id = ?");
      preparedStatement.setInt(1, subjectId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteSubjectAccordingToName(String subjectName) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM subjects WHERE name = ?");
      preparedStatement.setString(1, subjectName);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void updateSubjectAccordingToId(Subject subject) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE subjects SET name = ?, credits = ?, " +
          "semester_id = ?, teacher_id = ? WHERE id = ?");
      preparedStatement.setString(1, subject.getName());
      preparedStatement.setInt(2, subject.getCredits());
      preparedStatement.setInt(3, subject.getSemester().getId());
      preparedStatement.setInt(4, subject.getTeacher().getId());
      preparedStatement.setInt(5, subject.getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- ASSIGNMENTS TABLE ---------- */
  public static void addAssignment(Assignment assignment) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO assignments(name,deadline,subject_id,description) " +
          "VALUES (?, ?, ?, ?)");
      preparedStatement.setString(1, assignment.getName());
      preparedStatement.setString(2, assignment.getDeadLine().toString());
      preparedStatement.setInt(3, assignment.getSubject().getId());
      preparedStatement.setString(4, assignment.getDescription());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<Assignment> getAssignments() {
    ArrayList<Assignment> assignments = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM assignments");
      while (result.next()) {
        Assignment assignment = getSingleAssignmentFromDB(result);
        assignments.add(assignment);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return assignments;
  }

  public static Assignment getAssignmentAccordingToId(int assignmentId) {
    Connection conn = connectStudyPartnerDB();
    Assignment assignment = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM assignments WHERE id = ?");
      preparedStatement.setInt(1, assignmentId);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        assignment = getSingleAssignmentFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return assignment;
  }

  public static ArrayList<Assignment> getAssignmentsAccordingToSubjectId(int subjectId) {
    ArrayList<Assignment> assignments = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM assignments WHERE subject_id = ?");
      preparedStatement.setInt(1, subjectId);
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        Assignment assignment = getSingleAssignmentFromDB(result);
        assignments.add(assignment);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return assignments;
  }

  public static void deleteAssignmentAccordingToId(int assignmentId) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM assignments WHERE id = ?");
      preparedStatement.setInt(1, assignmentId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteAssignmentAccordingToDeadline(String deadline) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM assignments WHERE deadline = ?");
      preparedStatement.setString(1, deadline);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- TIME_TABLE TABLE ---------- */
  public static void addTimeTable(TimeTable timeTable) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " +
          "time_table(subject_id, day, room_number, start_time, end_time, teacher_id, semester_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setInt(1, timeTable.getSubject().getId());
      preparedStatement.setInt(2, timeTable.getDay());
      preparedStatement.setString(3, timeTable.getRoomNumber());
      preparedStatement.setString(4, timeTable.getStartTime().toString());
      preparedStatement.setString(5, timeTable.getEndTime().toString());
      preparedStatement.setInt(6, timeTable.getTeacher().getId());
      preparedStatement.setInt(7, timeTable.getSemester().getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<TimeTable> getTimeTables() {
    ArrayList<TimeTable> timeTables = new ArrayList<>();
    Connection conn = connectStudyPartnerDB();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM time_table");
      while (result.next()) {
        TimeTable timeTable = getSingleTimeTableFromDB(result);
        timeTables.add(timeTable);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTables;
  }

  public static TimeTable getTimeTableAccordingToId(int timeTableId) {
    Connection conn = connectStudyPartnerDB();
    TimeTable timeTable = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE id = ?");
      preparedStatement.setInt(1, timeTableId);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        timeTable = getSingleTimeTableFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTable;
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToSubjectId(int subjectId) {
    Connection conn = connectStudyPartnerDB();
    ArrayList<TimeTable> timeTables = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE subject_id = ?");
      preparedStatement.setInt(1, subjectId);

      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        TimeTable timeTable = getSingleTimeTableFromDB(result);
        timeTables.add(timeTable);
      }

    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTables;
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToSemesterId(int semesterId) {
    Connection conn = connectStudyPartnerDB();
    ArrayList<TimeTable> timeTables = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE semester_id = ?");
      preparedStatement.setInt(1, semesterId);

      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        TimeTable timeTable = getSingleTimeTableFromDB(result);
        timeTables.add(timeTable);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTables;
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToSubjectName(String subjectName) {
    Subject subject = Database.getSubjectAccordingToName(subjectName);
    return getTimeTablesAccordingToSubjectId(subject.getId());
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToSemesterName(String semesterName) {
    Semester semester = Database.getSemesterAccordingToName(semesterName);
    return Database.getTimeTablesAccordingToSemesterId(semester.getId());
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToDay(String dayName) {
    int dayNumber = FormController.getDayNumber(dayName);
    Connection conn = connectStudyPartnerDB();
    ArrayList<TimeTable> timeTables = new ArrayList<>();
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE day = ?");
      preparedStatement.setInt(1, dayNumber);
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        TimeTable timeTable = getSingleTimeTableFromDB(result);
        timeTables.add(timeTable);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTables;
  }

  public static ArrayList<TimeTable> getTimeTablesAccordingToSemesterAndDay(String semesterName, String dayName) {
    int dayNumber = FormController.getDayNumber(dayName);
    Semester semester = Database.getSemesterAccordingToName(semesterName);
    Connection conn = connectStudyPartnerDB();
    ArrayList<TimeTable> timeTables = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE day = ? " +
          "AND semester_id = ?");
      preparedStatement.setInt(1, dayNumber);
      preparedStatement.setInt(2, semester.getId());
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        TimeTable timeTable = getSingleTimeTableFromDB(result);
        timeTables.add(timeTable);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTables;
  }

  public static TimeTable getTimeTableAccordingToSemesterDayStartTime(String semesterName, String dayName, String startTime) {
    int dayNumber = FormController.getDayNumber(dayName);
    Semester semester = Database.getSemesterAccordingToName(semesterName);
    Connection conn = connectStudyPartnerDB();
    TimeTable timeTable = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM time_table WHERE " +
          "semester_id = ? AND day = ? AND start_time = ?");
      preparedStatement.setInt(1, semester.getId());
      preparedStatement.setInt(2, dayNumber);
      preparedStatement.setString(3, startTime);
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        timeTable = getSingleTimeTableFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return timeTable;
  }

  public static void deleteTimeTableAccordingToId(int timeTableId) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM time_table WHERE id = ?");
      preparedStatement.setInt(1, timeTableId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteTimetableAccordingToSubjectDayStartTime(String subjectName, String dayName, String startTime) {
    Subject subject = Database.getSubjectAccordingToName(subjectName);
    int dayNumber = FormController.getDayNumber(dayName);
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM time_table WHERE " +
          "subject_id = ? AND day = ? AND start_time = ?");
      preparedStatement.setInt(1, subject.getId());
      preparedStatement.setInt(2, dayNumber);
      preparedStatement.setString(3, startTime);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void updateTimeTableAccordingToId(TimeTable timeTable) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE time_table SET " +
          "subject_id = ?, day = ?, room_number = ?, start_time = ?, end_time = ?, teacher_id = ?, semester_id = ? " +
          "WHERE id = ?");
      preparedStatement.setInt(1, timeTable.getSubject().getId());
      preparedStatement.setInt(2, timeTable.getDay());
      preparedStatement.setString(3, timeTable.getRoomNumber());
      preparedStatement.setString(4, timeTable.getStartTime().toString());
      preparedStatement.setString(5, timeTable.getEndTime().toString());
      preparedStatement.setInt(6, timeTable.getTeacher().getId());
      preparedStatement.setInt(7, timeTable.getSemester().getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- EXAMS TABLE ---------- */
  public static void addExam(Exam exam) {
    Connection conn = connectStudyPartnerDB();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " +
          "exams (subject_id, start_time, date, description) VALUES (?, ?, ?, ?)");
      preparedStatement.setInt(1, exam.getSubject().getId());
      preparedStatement.setString(2, exam.getStartTime().toString());
      preparedStatement.setString(3, exam.getDate().toString());
      preparedStatement.setString(4, exam.getDescription());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static ArrayList<Exam> getExams() {
    Connection conn = connectStudyPartnerDB();
    ArrayList<Exam> exams = new ArrayList<>();

    try {
      Statement statement = conn.createStatement();
      ResultSet result = statement.executeQuery("SELECT * FROM exams");
      while (result.next()) {
        Exam exam = getSingleExamFromDB(result);
        exams.add(exam);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return exams;
  }

  public static Exam getExamsAccordingToSubjectName(String subjectName) {
    Connection conn = connectStudyPartnerDB();
    Subject subject = getSubjectAccordingToName(subjectName);
    Exam exam = null;

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM exams WHERE subject_id = ?");
      preparedStatement.setInt(1, subject.getId());
      ResultSet result = preparedStatement.executeQuery();
      if (result.next()) {
        exam = getSingleExamFromDB(result);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return exam;
  }

  public static ArrayList<Exam> getExamsAccordingToDate(LocalDate date) {
    Connection conn = connectStudyPartnerDB();
    ArrayList<Exam> exams = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM exams WHERE date = ?");
      preparedStatement.setString(1, date.toString());
      ResultSet result = preparedStatement.executeQuery();
      while (result.next()) {
        Exam exam = getSingleExamFromDB(result);
        exams.add(exam);
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }

    return exams;
  }

  public static ArrayList<String> getAllExamDates() {
    ArrayList<Exam> exams = getExams();
    ArrayList<String> examDates = new ArrayList<>();

    exams.forEach(exam -> {
      String examDate = exam.getDate().toString();
      if (!isContainDate(examDate, examDates)) {
        examDates.add(examDate);
      }
    });

    return examDates;
  }

  public static void updateExamAccordingToId(Exam exam) {
    Connection conn = connectStudyPartnerDB();
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("UPDATE exams SET start_time = ?, date = ?, description = ? " +
          "WHERE id = ?");
      preparedStatement.setString(1, exam.getStartTime().toString());
      preparedStatement.setString(2, exam.getDate().toString());
      preparedStatement.setString(3, exam.getDescription());
      preparedStatement.setInt(4, exam.getId());
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  public static void deleteExamAccordingToId(int examId) {
    Connection conn = connectStudyPartnerDB();
    try {
      PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM exams WHERE id = ?");
      preparedStatement.setInt(1, examId);
      preparedStatement.executeUpdate();
    } catch (Exception exc) {
      exc.printStackTrace();
    } finally {
      try {
        conn.close();
      } catch (SQLException exc) {
        exc.printStackTrace();
      }
    }
  }

  /* ---------- UTILITIES ---------- */
  private static Semester getSingleSemesterFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");
    String name = result.getString("name");
    Semester semester = new Semester(id, name);

    return semester;
  }

  private static Teacher getSingleTeacherFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");
    String name = result.getString("name");
    String phoneNumber = result.getString("phone_number");
    Teacher teacher = new Teacher(id, name, phoneNumber);

    return teacher;
  }

  private static Subject getSingleSubjectFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");
    String name = result.getString("name");
    int credits = result.getInt("credits");

    int semesterId = result.getInt("semester_id");
    Semester semester = getSemesterAccordingToId(semesterId);

    int teacherId = result.getInt("teacher_id");
    Teacher teacher = getTeacherAccordingToId(teacherId);

    Subject subject = new Subject(id, name, credits, semester, teacher);

    return subject;
  }

  private static Assignment getSingleAssignmentFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");
    String name = result.getString("name");

    // deadLineInArray = ["year", "month", "day"]
    String[] deadLineInArray = result.getString("deadline").split("-");
    int year = Integer.parseInt(deadLineInArray[0]);
    int month = Integer.parseInt(deadLineInArray[1]);
    int dayOfMonth = Integer.parseInt(deadLineInArray[2]);
    LocalDate deadLine = LocalDate.of(year, month, dayOfMonth);

    int subjectId = result.getInt("subject_id");
    Subject subject = getSubjectAccordingToId(subjectId);

    String description = result.getString("description");

    Assignment assignment = new Assignment(id, name, deadLine, subject, description);

    return assignment;
  }

  private static TimeTable getSingleTimeTableFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");

    int subjectId = result.getInt("subject_id");
    Subject subject = getSubjectAccordingToId(subjectId);

    int day = result.getInt("day");

    String roomNumber = result.getString("room_number");

    String[] startTimeInArray = result.getString("start_time").split(":");
    int startTimeHour = Integer.parseInt(startTimeInArray[0]);
    int startTimeMinute = Integer.parseInt(startTimeInArray[1]);
    LocalTime startTime = LocalTime.of(startTimeHour, startTimeMinute);

    String[] endTimeInArray = result.getString("end_time").split(":");
    int endTimeHour = Integer.parseInt(endTimeInArray[0]);
    int endTimeMinute = Integer.parseInt(endTimeInArray[1]);
    LocalTime endTime = LocalTime.of(endTimeHour, endTimeMinute);

    int teacherId = result.getInt("teacher_id");
    Teacher teacher = getTeacherAccordingToId(teacherId);

    int semesterId = result.getInt("semester_id");
    Semester semester = getSemesterAccordingToId(semesterId);

    TimeTable timeTable = new TimeTable(subject, day, roomNumber, startTime, endTime, teacher, semester);

    return timeTable;
  }

  private static Exam getSingleExamFromDB(ResultSet result) throws SQLException {
    int id = result.getInt("id");

    int subjectId = result.getInt("subject_id");
    Subject subject = Database.getSubjectAccordingToId(subjectId);

    String[] startTimeInArray = result.getString("start_time").split(":");
    int startTimeHour = Integer.parseInt(startTimeInArray[0]);
    int startTimeMinute = Integer.parseInt(startTimeInArray[1]);
    LocalTime startTime = LocalTime.of(startTimeHour, startTimeMinute);

    String dateInString = result.getString("date");
    LocalDate date = LocalDate.parse(dateInString);

    String description = result.getString("description");

    Exam exam = new Exam(id, subject, startTime, date, description);

    return exam;
  }

  private static boolean isContainDate(String examDate, ArrayList<String> examDates) {
    for (String eachExamDate : examDates) {
      if (eachExamDate.equals(examDate)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {

  }

}
