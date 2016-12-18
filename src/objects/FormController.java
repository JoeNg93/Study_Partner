package objects;

import utilities.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by joenguyen on 9/18/16.
 */
public class FormController {

  private DefaultTableModel tblModelSubject;
  private DefaultTableModel tblModelSemester;
  private DefaultTableModel tblModelTeacher;
  private DefaultTableModel tblModelExam;

  private DefaultComboBoxModel cbbModelSemester;
  private DefaultComboBoxModel cbbModelChooseTerm;
  private DefaultComboBoxModel cbbModelSubjectSemester;
  private DefaultComboBoxModel cbbModelSubjectTeacher;
  private DefaultComboBoxModel cbbModelChooseDate;

  public FormController() {
    initializeCbbModelSemester();
    fetchSemesterToComboBox();

    initializeCbbModelChooseTerm();

    initializeTblModelSubject();

    initializeTblModelSemester();

    initializeTblModelTeacher();

    initializeTblModelExam();

    initializeCbbModelSubjectTeacher();

    initializeCbbModelSubjectSemester();

    initializeCbbModelChooseDate();
  }

  public void fetchSemesterToComboBox() {
    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSemester.addElement(semester.getName());
    }
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

  private void initializeCbbModelSemester() {
    cbbModelSemester = new DefaultComboBoxModel();

    cbbModelSemester.addElement("--Choose semester-- ");
  }

  private void initializeCbbModelSubjectTeacher() {
    cbbModelSubjectTeacher = new DefaultComboBoxModel();

    cbbModelSubjectTeacher.addElement("--Choose Teacher--");

    ArrayList<Teacher> teachers = Database.getTeachers();
    for (Teacher teacher : teachers) {
      cbbModelSubjectTeacher.addElement(teacher.getName());
    }
  }

  private void initializeCbbModelSubjectSemester() {
    cbbModelSubjectSemester = new DefaultComboBoxModel();

    cbbModelSubjectSemester.addElement("--Choose Semester--");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSubjectSemester.addElement(semester.getName());
    }
  }

  public void initializeCbbModelChooseTerm() {
    cbbModelChooseTerm = new DefaultComboBoxModel();

    cbbModelChooseTerm.addElement("--Choose term--");
    cbbModelChooseTerm.addElement("Autumn");
    cbbModelChooseTerm.addElement("Spring");
  }

  public void initializeTblModelTeacher() {
    tblModelTeacher = new DefaultTableModel();

    tblModelTeacher.addColumn("Name");
    tblModelTeacher.addColumn("Phone Number");
  }

  public void initializeCbbModelChooseDate() {
    cbbModelChooseDate = new DefaultComboBoxModel();

    cbbModelChooseDate.addElement("--Choose date--");

    ArrayList<String> examDates = Database.getAllExamDates();
    for (String examDate : examDates) {
      cbbModelChooseDate.addElement(examDate);
    }
  }

  public void renderCbbModelSemester() {
    try {
      cbbModelSemester.removeAllElements();
    } catch (NullPointerException exc) { }

    cbbModelSemester.addElement("--Choose semester-- ");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSemester.addElement(semester.getName());
    }
  }

  public void renderCbbModelSubjectTeacher() {
    try {
      cbbModelSubjectTeacher.removeAllElements();
    } catch (NullPointerException exc) { }

    cbbModelSubjectTeacher.addElement("--Choose Teacher--");

    ArrayList<Teacher> teachers = Database.getTeachers();
    for (Teacher teacher : teachers) {
      cbbModelSubjectTeacher.addElement(teacher.getName());
    }
  }

  public DefaultComboBoxModel getCbbModelSemester() {
    return cbbModelSemester;
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

  public DefaultComboBoxModel getCbbModelChooseTerm() {
    return cbbModelChooseTerm;
  }

  public DefaultTableModel getTblModelTeacher() {
    return tblModelTeacher;
  }

  public DefaultComboBoxModel getCbbModelSubjectSemester() {
    return cbbModelSubjectSemester;
  }

  public DefaultComboBoxModel getCbbModelSubjectTeacher() {
    return cbbModelSubjectTeacher;
  }

  public DefaultComboBoxModel getCbbModelChooseDate() {
    return cbbModelChooseDate;
  }
}
