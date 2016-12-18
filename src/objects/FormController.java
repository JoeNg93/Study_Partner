package objects;

import utilities.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by joenguyen on 9/18/16.
 */
public class FormController {

  private DefaultTableModel tblModelSubject;
  private DefaultTableModel tblModelSemester;
  private DefaultTableModel tblModelTeacher;
  private DefaultTableModel tblModelExam;

  // Name note: cbbModel[tabName][nameOfCombobox]
  private DefaultComboBoxModel cbbModelSubjectChooseSemester; // Choose semester of Subject tab
  private DefaultComboBoxModel cbbModelSemesterTerm; // Choose term of Semester tab, Add Semester
  private DefaultComboBoxModel cbbModelSubjectSemester; // Choose semester of Subject tab, Add Subject
  private DefaultComboBoxModel cbbModelSubjectTeacher; // Choose teacher of Subject tab, Add Subject
  private DefaultComboBoxModel cbbModelExamChooseDate; // Choose date of Exam tab
  private DefaultComboBoxModel cbbModelExamSubject;

  public FormController() {
    initializeTblModelSubject();
    initializeTblModelSemester();
    initializeTblModelTeacher();
    initializeTblModelExam();

    initializeCbbModelSubjectChooseSemester();
    initializeCbbModelSemesterTerm();
    initializeCbbModelSubjectSemester();
    initializeCbbModelSubjectTeacher();
    initializeCbbModelExamChooseDate();
    initializeCbbModelExamSubject();
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

  public void updateCbbModelSubjectChooseSemester() {
    try {
      cbbModelSubjectChooseSemester.removeAllElements();
    } catch (NullPointerException exc) { }

    cbbModelSubjectChooseSemester.addElement("--Choose semester-- ");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSubjectChooseSemester.addElement(semester.getName());
    }
  }

  public void updateCbbModelSubjectTeacher() {
    try {
      cbbModelSubjectTeacher.removeAllElements();
    } catch (NullPointerException exc) { }

    cbbModelSubjectTeacher.addElement("--Choose Teacher--");

    ArrayList<Teacher> teachers = Database.getTeachers();
    for (Teacher teacher : teachers) {
      cbbModelSubjectTeacher.addElement(teacher.getName());
    }
  }

  public void updateCbbModelSubjectSemester() {
    try {
      cbbModelSubjectSemester.removeAllElements();
    } catch (NullPointerException exc) {

    }

    cbbModelSubjectSemester.addElement("--Choose Semester--");

    ArrayList<Semester> semesters = Database.getSemesters();
    for (Semester semester : semesters) {
      cbbModelSubjectSemester.addElement(semester.getName());
    }
  }

  public void updateCbbModelExamChooseDate() {
    try {
      cbbModelExamChooseDate.removeAllElements();
    } catch (NullPointerException exc) {

    }

    cbbModelExamChooseDate.addElement("--Choose Date--");

    ArrayList<Exam> exams = Database.getExams();
    for (Exam exam : exams) {
      cbbModelExamChooseDate.addElement(exam.getDate().toString());
    }
  }

  public void updateCbbModelExamSubject() {
    try {
      cbbModelExamSubject.removeAllElements();
    } catch (NullPointerException exc) {

    }

    cbbModelExamSubject.addElement("--Choose Subject");

    ArrayList<Subject> subjects = Database.getSubjects();
    for (Subject subject: subjects) {
      cbbModelExamSubject.addElement(subject.getName());
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
}
