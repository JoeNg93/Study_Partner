package objects;

import utilities.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by joenguyen on 9/18/16.
 */
public class FormController {

  private DefaultTableModel tblModelSubject;
  private DefaultTableModel tblModelSemester;
  private DefaultTableModel tblModelTeacher;
  private DefaultTableModel tblModelExam;
  private DefaultTableModel tblModelTimetable;

  // Name note: cbbModel[tabName][nameOfCombobox]
  private DefaultComboBoxModel cbbModelSubjectChooseSemester; // Choose semester of Subject tab
  private DefaultComboBoxModel cbbModelSemesterTerm; // Choose term of Semester tab, Add Semester
  private DefaultComboBoxModel cbbModelSubjectSemester; // Choose semester of Subject tab, Add Subject
  private DefaultComboBoxModel cbbModelSubjectTeacher; // Choose teacher of Subject tab, Add Subject
  private DefaultComboBoxModel cbbModelExamChooseDate; // Choose date of Exam tab
  private DefaultComboBoxModel cbbModelExamSubject;
  private DefaultComboBoxModel cbbModelTimetableChooseSemester;
  private DefaultComboBoxModel cbbModelTimetableChooseDay;
  private DefaultComboBoxModel cbbModelTimetableChooseSubject;
  private DefaultComboBoxModel cbbModelTimetableSubject;
  private DefaultComboBoxModel cbbModelTimetableDay;
  private DefaultComboBoxModel cbbModelTimetableTeacher;
  private DefaultComboBoxModel cbbModelTimetableSemester;

  private static final String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

  public FormController() {
    initializeTblModelSubject();
    initializeTblModelSemester();
    initializeTblModelTeacher();
    initializeTblModelExam();
    initializeTblModelTimetable();

    initializeCbbModelSubjectChooseSemester();
    initializeCbbModelSemesterTerm();
    initializeCbbModelSubjectSemester();
    initializeCbbModelSubjectTeacher();
    initializeCbbModelExamChooseDate();
    initializeCbbModelExamSubject();
    initializeCbbModelTimetableChooseSemester();
    initializeCbbModelTimetableChooseDay();
    initializeCbbModelTimetableChooseSubject();
    initializeCbbModelTimetableSubject();
    initializeCbbModelTimetableDay();
    initializeCbbModelTimetableTeacher();
    initializeCbbModelTimetableSemester();

  }

  private void initializeTblModelSubject() {
    tblModelSubject = new DefaultTableModel();

    tblModelSubject.addColumn("Name");
    tblModelSubject.addColumn("Credits");
    tblModelSubject.addColumn("Instructor");
  }

  private void initializeTblModelSemester() {
    tblModelSemester = new DefaultTableModel();

    tblModelSemester.addColumn("Name");
    tblModelSemester.addColumn("Total Credits");
  }

  private void initializeTblModelExam() {
    tblModelExam = new DefaultTableModel();

    tblModelExam.addColumn("Subject");
    tblModelExam.addColumn("Date");
    tblModelExam.addColumn("Start Time");
    tblModelExam.addColumn("Description");
  }

  private void initializeTblModelTimetable() {
    tblModelTimetable = new DefaultTableModel();

    tblModelTimetable.addColumn("Subject");
    tblModelTimetable.addColumn("Day");
    tblModelTimetable.addColumn("Room Number");
    tblModelTimetable.addColumn("Start Time");
    tblModelTimetable.addColumn("End Time");
    tblModelTimetable.addColumn("Teacher");
    tblModelTimetable.addColumn("Semester");
  }

  private void initializeCbbModelSubjectChooseSemester() {
    cbbModelSubjectChooseSemester = new DefaultComboBoxModel();
  }

  private void initializeCbbModelSubjectTeacher() {
    cbbModelSubjectTeacher = new DefaultComboBoxModel();
  }

  private void initializeCbbModelSubjectSemester() {
    cbbModelSubjectSemester = new DefaultComboBoxModel();
  }

  public void initializeCbbModelSemesterTerm() {
    cbbModelSemesterTerm = new DefaultComboBoxModel();

    cbbModelSemesterTerm.addElement("--Choose term--");
    cbbModelSemesterTerm.addElement("Autumn");
    cbbModelSemesterTerm.addElement("Spring");
  }

  public void initializeTblModelTeacher() {
    tblModelTeacher = new DefaultTableModel();

    tblModelTeacher.addColumn("Name");
    tblModelTeacher.addColumn("Phone Number");
  }

  public void initializeCbbModelExamChooseDate() {
    cbbModelExamChooseDate = new DefaultComboBoxModel();
  }

  public void initializeCbbModelExamSubject() {
    cbbModelExamSubject = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableChooseSemester() {
    cbbModelTimetableChooseSemester = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableChooseDay() {
    cbbModelTimetableChooseDay = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableChooseSubject() {
    cbbModelTimetableChooseSubject = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableSubject() {
    cbbModelTimetableSubject = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableDay() {
    cbbModelTimetableDay = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableTeacher() {
    cbbModelTimetableTeacher = new DefaultComboBoxModel();
  }

  public void initializeCbbModelTimetableSemester() {
    cbbModelTimetableSemester = new DefaultComboBoxModel();
  }

  public void updateCbbModelSubjectChooseSemester() {
    initializeCbbModelSubjectChooseSemester();

    cbbModelSubjectChooseSemester.addElement("--Choose semester-- ");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSubjectChooseSemester.addElement(semester.getName());
    }
  }

  public void updateCbbModelSubjectTeacher() {
    initializeCbbModelSubjectTeacher();

    cbbModelSubjectTeacher.addElement("--Choose Teacher--");

    ArrayList<Teacher> teachers = Database.getTeachers();
    for (Teacher teacher : teachers) {
      cbbModelSubjectTeacher.addElement(teacher.getName());
    }
  }

  public void updateCbbModelSubjectSemester() {
    initializeCbbModelSubjectSemester();

    cbbModelSubjectSemester.addElement("--Choose Semester--");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSubjectSemester.addElement(semester.getName());
    }
  }

  public void updateCbbModelExamChooseDate() {
    initializeCbbModelExamChooseDate();

    cbbModelExamChooseDate.addElement("--Choose Date--");

    ArrayList<String> examDates = Database.getAllExamDates();
    for (String examDate : examDates) {
      cbbModelExamChooseDate.addElement(examDate);
    }
  }

  public void updateCbbModelExamSubject() {
    initializeCbbModelExamSubject();

    cbbModelExamSubject.addElement("--Choose Subject");

    ArrayList<Subject> subjects = Database.getSubjects();
    for (Subject subject : subjects) {
      cbbModelExamSubject.addElement(subject.getName());
    }
  }

  public void updateCbbModelTimetableChooseSemester() {
    initializeCbbModelTimetableChooseSemester();

    cbbModelTimetableChooseSemester.addElement("--Choose Semester--");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelTimetableChooseSemester.addElement(semester.getName());
    }
  }

  public void updateCbbModelTimetableChooseDay() {
    initializeCbbModelTimetableChooseDay();

    cbbModelTimetableChooseDay.addElement("--Choose Day--");
    for (int i = 0; i < dayOfWeek.length; i++) {
      cbbModelTimetableChooseDay.addElement(getDayName(i));
    }
  }

  public void updateCbbModelTimetableChooseSubject() {
    initializeCbbModelTimetableChooseSubject();

    cbbModelTimetableChooseSubject.addElement("--Choose Subject--");

    ArrayList<Subject> subjects = Database.getSubjects();
    for (Subject subject : subjects) {
      cbbModelTimetableChooseSubject.addElement(subject.getName());
    }
  }

  public void updateCbbModelTimetableChooseSubjectAccordingToSemester(String semesterName) {
    initializeCbbModelTimetableChooseSubject();

    cbbModelTimetableChooseSubject.addElement("--Choose Subject--");

    ArrayList<Subject> subjects = Database.getSubjectsAccordingToSemesterName(semesterName);
    for (Subject subject : subjects) {
      cbbModelTimetableChooseSubject.addElement(subject.getName());
    }
  }

  public void updateCbbModelTimetableChooseSubjectAccordingToSemesterAndDay(String semesterName, String dayName) {
    initializeCbbModelTimetableChooseSubject();

    cbbModelTimetableChooseSubject.addElement("--Choose Subject--");

    ArrayList<TimeTable> timeTables = Database.getTimeTablesAccordingToSemesterAndDay(semesterName, dayName);
    ArrayList<String> subjectNames = new ArrayList<>();
    for (TimeTable timeTable : timeTables) {
      subjectNames.add(timeTable.getSubject().getName());
    }
    HashSet<String> uniqueSubjectNames = new HashSet<>(subjectNames);
    for (String subjectName : uniqueSubjectNames) {
      cbbModelTimetableChooseSubject.addElement(subjectName);
    }
  }

  public void updateCbbModelTimetableSubject() {
    initializeCbbModelTimetableSubject();

    cbbModelTimetableSubject.addElement("--Choose Subject--");

    ArrayList<Subject> subjects = Database.getSubjects();
    for (Subject subject : subjects) {
      cbbModelTimetableSubject.addElement(subject.getName());
    }
  }

  public void updateCbbModelTimetableDay() {
    initializeCbbModelTimetableDay();

    cbbModelTimetableDay.addElement("--Choose Day--");
    for (int i = 0; i < dayOfWeek.length; i++) {
      cbbModelTimetableDay.addElement(getDayName(i));
    }
  }

  public void updateCbbModelTimetableTeacher() {
    initializeCbbModelTimetableTeacher();

    cbbModelTimetableTeacher.addElement("--Choose Teacher--");

    ArrayList<Teacher> teachers = Database.getTeachers();
    for (Teacher teacher : teachers) {
      cbbModelTimetableTeacher.addElement(teacher.getName());
    }
  }

  public void updateCbbModelTimetableSemester() {
    initializeCbbModelTimetableSemester();

    cbbModelTimetableSemester.addElement("--Choose Semester--");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelTimetableSemester.addElement(semester.getName());
    }
  }

  public DefaultComboBoxModel getCbbModelSubjectChooseSemester() {
    return cbbModelSubjectChooseSemester;
  }

  public DefaultTableModel getTblModelSubject() {
    return tblModelSubject;
  }

  public DefaultTableModel getTblModelSemester() {
    return tblModelSemester;
  }

  public DefaultTableModel getTblModelExam() {
    return tblModelExam;
  }

  public DefaultComboBoxModel getCbbModelSemesterTerm() {
    return cbbModelSemesterTerm;
  }

  public DefaultTableModel getTblModelTeacher() {
    return tblModelTeacher;
  }

  public DefaultTableModel getTblModelTimetable() {
    return tblModelTimetable;
  }

  public DefaultComboBoxModel getCbbModelSubjectSemester() {
    return cbbModelSubjectSemester;
  }

  public DefaultComboBoxModel getCbbModelSubjectTeacher() {
    return cbbModelSubjectTeacher;
  }

  public DefaultComboBoxModel getCbbModelExamChooseDate() {
    return cbbModelExamChooseDate;
  }

  public DefaultComboBoxModel getCbbModelExamSubject() {
    return cbbModelExamSubject;
  }

  public DefaultComboBoxModel getCbbModelTimetableChooseDay() {
    return cbbModelTimetableChooseDay;
  }

  public DefaultComboBoxModel getCbbModelTimetableChooseSemester() {
    return cbbModelTimetableChooseSemester;
  }

  public DefaultComboBoxModel getCbbModelTimetableChooseSubject() {
    return cbbModelTimetableChooseSubject;
  }

  public DefaultComboBoxModel getCbbModelTimetableDay() {
    return cbbModelTimetableDay;
  }

  public DefaultComboBoxModel getCbbModelTimetableSemester() {
    return cbbModelTimetableSemester;
  }

  public DefaultComboBoxModel getCbbModelTimetableSubject() {
    return cbbModelTimetableSubject;
  }

  public DefaultComboBoxModel getCbbModelTimetableTeacher() {
    return cbbModelTimetableTeacher;
  }

  public static String getDayName(int dayNumber) {
    return dayOfWeek[dayNumber];
  }

  public static int getDayNumber(String dayName) {
    return Arrays.asList(dayOfWeek).indexOf(dayName);
  }
}
