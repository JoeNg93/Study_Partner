// TODO: Add functionality for AddExam form, then create Delete and Edit Exam

package forms;

import objects.*;
import utilities.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FrmMain {

  private JPanel pnMain;
  private JTabbedPane tabbedPane1;

  private JPanel pnNotifications;

  // SUBJECT TAB
  private JPanel pnSubjects;
  private JComboBox cbbSemesters;
  private JTable tblSubjects;
  private JButton btnAddSubject;
  private FrmAddSubject frmAddSubject;
  private FrmEditSubject frmEditSubject;
  private JButton btnDeleteSubject;
  private JButton btnEditSubject;

  // SEMESTER TAB
  private JPanel pnSemesters;
  private JTable tblSemesters;
  private JButton btnAddSemester;
  private FrmAddSemester frmAddSemester;
  private FrmEditSemester frmEditSemester;
  private JButton btnDeleteSemester;
  private JButton btnEditSemester;

  // TEACHER TAB
  private JPanel pnTeachers;
  private JTable tblTeachers;
  private JButton btnAddTeacher;
  private JButton btnDeleteTeacher;
  private JButton btnEditTeacher;
  private FrmAddTeacher frmAddTeacher;
  private FrmEditTeacher frmEditTeacher;

  // EXAM TAB
  private JPanel pnExams;
  private JTable tblExams;
  private JComboBox cbbChooseDate;
  private JButton btnAddExam;
  private JButton btnEditExam;
  private JButton btnDeleteExam;

  private FormController formController;

  private List<Subject> subjects;
  private List<Teacher> teachers;
  private List<Semester> semesters;
  private List<Exam> exams;

  public FrmMain() {
    formController = new FormController();

    /* cbbSemesters initialization */
    cbbSemesters.setModel(formController.getCbbModelSemester());
    handleClickOnCbbSemesters();

    /* cbbChooseDate initialization */
    cbbChooseDate.setModel(formController.getCbbModelChooseDate());
    handleClickOnCbbChooseDate();

    /* tblSubjects initialization */
    tblSubjects.setModel(formController.getTblModelSubject());
    tblSubjects.setFont(new Font("Serif", Font.PLAIN, 15));
    tblSubjects.setDefaultEditor(Object.class, null); // set the table uneditable
    updateTblSubjects();

    /* tblSemesters initialization*/
    tblSemesters.setModel(formController.getTblModelSemester());
    tblSemesters.setFont(new Font("Serif", Font.PLAIN, 15));
    tblSemesters.setDefaultEditor(Object.class, null);
    updateTblSemesters();

    /* tblTeachers initialization */
    tblTeachers.setModel(formController.getTblModelTeacher());
    tblTeachers.setFont(new Font("Serif", Font.PLAIN, 15));
    tblTeachers.setDefaultEditor(Object.class, null);
    updateTblTeachers();

    /* tblExams initialization */
    tblExams.setModel(formController.getTblModelExam());
    tblExams.setFont(new Font("Serif", Font.PLAIN, 15));
    tblExams.setDefaultEditor(Object.class, null);
    updateTblExams();

    /* frmAddSemester initialization */
    frmAddSemester = new FrmAddSemester();
    frmAddSemester.getCbbChooseTerm().setModel(formController.getCbbModelChooseTerm());
    handleConfirmOnBtnAddSemester();

    /* btnAddSemester initialization */
    handleClickOnBtnAddSemester();

    /* frmAddSubject initialization */
    frmAddSubject = new FrmAddSubject();
    frmAddSubject.getCbbSubjectSemester().setModel(formController.getCbbModelSubjectSemester());
    frmAddSubject.getCbbSubjectTeacher().setModel(formController.getCbbModelSubjectTeacher());
    handleConfirmOnBtnAddSubject();

    /* frmAddTeacher initialization */
    frmAddTeacher = new FrmAddTeacher();
    handleConfirmOnBtnAddTeacher();

    /* frmEditSemester initialization */
    frmEditSemester = new FrmEditSemester();
    frmEditSemester.getCbbChooseTerm().setModel(formController.getCbbModelChooseTerm());
    handleConfirmOnBtnEditSemester();

    /* frmEditSubject initialization */
    frmEditSubject = new FrmEditSubject();
    frmEditSubject.getCbbSemester().setModel(formController.getCbbModelSemester());
    frmEditSubject.getCbbTeacher().setModel(formController.getCbbModelSubjectTeacher());
    handleConfirmOnBtnEditSubject();

    /* frmEditTeacher initiliazation */
    frmEditTeacher = new FrmEditTeacher();
    handleConfirmOnBtnEditTeacher();

    /* btnEditTeacher initialization */
    handleClickOnBtnEditTeacher();

    /* btnEditSubject initialization */
    handleClickOnBtnEditSubject();

    /* btnAddSubject initialization */
    handleClickOnBtnAddSubject();

    /* btnDeleteSemester initialization */
    handleClickOnBtnDeleteSemester();

    /* btnDeleteSubject initialization */
    handleClickOnBtnDeleteSubject();

    /* btnDeleteTeacher initialization */
    handleClickOnBtnDeleteTeacher();

    /* btnAddTeacher initialization */
    handleClickOnBtnAddTeacher();

    /* btnEditSemester initialization */
    handleClickOnBtnEditSemester();

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("FrmMain");
    frame.setContentPane(new FrmMain().pnMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.setVisible(true);

  }

  public void handleClickOnCbbSemesters() {
    cbbSemesters.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (cbbSemesters.getSelectedIndex() != 0) {
          fetchDataAccordingToCbbSemesterSelectedIndex();
          sendDataToTblSubjects();
        } else {
          updateTblSubjects();
        }
      }
    });
  }

  public void handleClickOnCbbChooseDate() {
    cbbChooseDate.addActionListener(evt -> {
      if (cbbChooseDate.getSelectedIndex() != 0) {
        String examDateInString = (String) cbbChooseDate.getSelectedItem();
        LocalDate examDate = LocalDate.parse(examDateInString);
        exams = Database.getExamsAccordingToDate(examDate);
        sendDataToTblExams();
      } else {
        updateTblExams();
      }
    });


  }

  public void handleClickOnBtnAddSemester() {
    btnAddSemester.addActionListener((ActionEvent e) -> {
      frmAddSemester.setVisible(true);
    });
  }

  public void handleClickOnBtnAddSubject() {
    btnAddSubject.addActionListener((ActionEvent e) -> {
      frmAddSubject.getCbbSubjectSemester().setSelectedIndex(cbbSemesters.getSelectedIndex());
      frmAddSubject.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddSemester() {
    frmAddSemester.getBtnAddSemester().addActionListener((ActionEvent e) -> {
      String academicYear = frmAddSemester.getTxtAcademicYear().getText();
      String academicTerm = null;

      int selectedIndex = frmAddSemester.getCbbChooseTerm().getSelectedIndex();
      switch (selectedIndex) {
        case 1:
          academicTerm = "Autumn";
          break;
        case 2:
          academicTerm = "Spring";
          break;
        default:
          JOptionPane.showMessageDialog(null, "Please choose the semester");
          return;
      }

      Semester semester = new Semester(academicTerm + " " + academicYear);
      Database.addSemester(semester);
      updateTblSemesters();
      formController.renderCbbModelSemester();
      updateTblSubjects();
      frmAddSemester.dispose();
    });
  }

  public void handleConfirmOnBtnAddSubject() {
    frmAddSubject.getBtnAddSubject().addActionListener(evt -> {
      String name = frmAddSubject.getTxtSubjectName().getText();
      int credits = Integer.parseInt(frmAddSubject.getTxtSubjectCredits().getText());

      String semesterName = (String) frmAddSubject.getCbbSubjectSemester().getSelectedItem();
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      String teacherName = (String) frmAddSubject.getCbbSubjectTeacher().getSelectedItem();
      Teacher teacher = Database.getTeacherAccordingToName(teacherName);

      Subject subject = new Subject(name, credits, semester, teacher);

      Database.addSubject(subject);
      fetchDataAccordingToCbbSemesterSelectedIndex();
      updateTblSemesters();
      sendDataToTblSubjects();
      frmAddSubject.dispose();
    });
  }

  public void handleClickOnBtnDeleteSemester() {
    btnDeleteSemester.addActionListener(e -> {
      int selectedRow = tblSemesters.getSelectedRow();
      String semesterName = (String) tblSemesters.getValueAt(selectedRow, 0);

      Database.deleteSemesterAccordingToName(semesterName);
      updateTblSemesters();
      formController.renderCbbModelSemester();
      updateTblSubjects();
    });
  }

  public void handleClickOnBtnDeleteSubject() {
    btnDeleteSubject.addActionListener(evt -> {
      int selectedRow = tblSubjects.getSelectedRow();
      String subjectName = (String) tblSubjects.getValueAt(selectedRow, 0);

      Database.deleteSubjectAccordingToName(subjectName);
      fetchDataAccordingToCbbSemesterSelectedIndex();
      sendDataToTblSubjects();
      updateTblSemesters();
    });
  }

  public void handleClickOnBtnAddTeacher() {
    btnAddTeacher.addActionListener(evt -> {
      frmAddTeacher.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddTeacher() {
    frmAddTeacher.getBtnAddTeacher().addActionListener(evt -> {
      String teacherName = frmAddTeacher.getTxtTeacherName().getText();
      String phoneNumber = frmAddTeacher.getTxtPhoneNumber().getText();
      Teacher teacher = new Teacher(teacherName, phoneNumber);

      Database.addTeacher(teacher);
      updateTblTeachers();
      formController.renderCbbModelSubjectTeacher();
      frmAddTeacher.dispose();
    });
  }

  public void handleClickOnBtnDeleteTeacher() {
    btnDeleteTeacher.addActionListener(evt -> {
      int selectedRow = tblTeachers.getSelectedRow();
      String teacherName = (String) tblTeachers.getValueAt(selectedRow, 0);

      Database.deleteTeacherAccordingToName(teacherName);
      updateTblTeachers();
      formController.renderCbbModelSubjectTeacher();
    });
  }

  public void handleClickOnBtnEditSemester() {
    btnEditSemester.addActionListener(evt -> {
      frmEditSemester.setVisible(true);

      int selectedRow = tblSemesters.getSelectedRow();
      String[] academicTermAndYear = ((String) tblSemesters.getValueAt(selectedRow, 0)).split(" ");
      String academicTerm = academicTermAndYear[0];
      String academicYear = academicTermAndYear[1];

      frmEditSemester.getCbbChooseTerm().setSelectedItem(academicTerm);
      frmEditSemester.getTxtAcademicYear().setText(academicYear);
    });
  }

  public void handleConfirmOnBtnEditSemester() {
    frmEditSemester.getBtnEditSemester().addActionListener(evt -> {
      int selectedRow = tblSemesters.getSelectedRow();
      String semesterName = (String) tblSemesters.getValueAt(selectedRow, 0);
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      String academicTerm = (String) frmEditSemester.getCbbChooseTerm().getSelectedItem();
      String academicYear = frmEditSemester.getTxtAcademicYear().getText();

      semester.setName(academicTerm + " " + academicYear);
      Database.updateSemesterAccordingToId(semester);
      updateTblSemesters();
      formController.renderCbbModelSemester();
      updateTblSubjects();
      frmEditSemester.dispose();
    });
  }

  public void handleClickOnBtnEditSubject() {
    btnEditSubject.addActionListener(evt -> {
      frmEditSubject.setVisible(true);

      int selectedRow = tblSubjects.getSelectedRow();
      String subjectName = (String) tblSubjects.getValueAt(selectedRow, 0);
      int credits = (Integer) tblSubjects.getValueAt(selectedRow, 1);
      String teacherName = (String) tblSubjects.getValueAt(selectedRow, 2);
      String semesterName = (String) cbbSemesters.getSelectedItem();

      frmEditSubject.getTxtName().setText(subjectName);
      frmEditSubject.getTxtCredits().setText(String.valueOf(credits));
      frmEditSubject.getCbbTeacher().setSelectedItem(teacherName);
      frmEditSubject.getCbbSemester().setSelectedItem(semesterName);
    });
  }

  public void handleConfirmOnBtnEditSubject() {
    frmEditSubject.getBtnEditSubject().addActionListener(evt -> {
      int selectedRow = tblSubjects.getSelectedRow();
      String currentSubjectName = (String) tblSubjects.getValueAt(selectedRow, 0);
      Subject subject = Database.getSubjectAccordingToName(currentSubjectName);

      String subjectName = frmEditSubject.getTxtName().getText();
      int credits = Integer.parseInt(frmEditSubject.getTxtCredits().getText());

      String semesterName = (String) frmEditSubject.getCbbSemester().getSelectedItem();
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      String teacherName = (String) frmEditSubject.getCbbTeacher().getSelectedItem();
      Teacher teacher = Database.getTeacherAccordingToName(teacherName);

      subject.setName(subjectName);
      subject.setCredits(credits);
      subject.setTeacher(teacher);
      subject.setSemester(semester);

      Database.updateSubjectAccordingToId(subject);
      fetchDataAccordingToCbbSemesterSelectedIndex();
      sendDataToTblSubjects();
      frmEditSubject.dispose();
    });
  }

  public void handleClickOnBtnEditTeacher() {
    btnEditTeacher.addActionListener(evt -> {
      frmEditTeacher.setVisible(true);

      int selectedRow = tblTeachers.getSelectedRow();
      String teacherName = (String) tblTeachers.getValueAt(selectedRow, 0);
      String phoneNumber = (String) tblTeachers.getValueAt(selectedRow, 1);

      frmEditTeacher.getTxtName().setText(teacherName);
      frmEditTeacher.getTxtPhoneNumber().setText(phoneNumber);
    });
  }

  public void handleConfirmOnBtnEditTeacher() {
    frmEditTeacher.getBtnEditTeacher().addActionListener(evt -> {
      int selectedRow = tblTeachers.getSelectedRow();
      String currentTeacherName = (String) tblTeachers.getValueAt(selectedRow, 0);
      Teacher teacher = Database.getTeacherAccordingToName(currentTeacherName);

      String teacherName = frmEditTeacher.getTxtName().getText();
      String phoneNumber = frmEditTeacher.getTxtPhoneNumber().getText();
      teacher.setName(teacherName);
      teacher.setPhoneNumber(phoneNumber);

      Database.updateTeacherAccordingToId(teacher);
      updateTblTeachers();
      fetchDataAccordingToCbbSemesterSelectedIndex();
      sendDataToTblSubjects();
      formController.renderCbbModelSubjectTeacher();
      frmEditTeacher.dispose();
    });
  }

  private void fetchDataAccordingToCbbSemesterSelectedIndex() {
    String semesterName = (String) cbbSemesters.getSelectedItem();
    int semesterId = Database.getSemesterAccordingToName(semesterName).getId();
    subjects = Database.getSubjectsAccordingToSemesterId(semesterId);
  }

  private void sendDataToTblSubjects() {
    // Clear the table model first
    formController.getTblModelSubject().setRowCount(0);

    DefaultTableModel tblModelSubject = formController.getTblModelSubject();

    for (Subject eachSubject : subjects) {
      String subjectName = eachSubject.getName();
      int subjectCredits = eachSubject.getCredits();
      Teacher subjectTeacher = eachSubject.getTeacher();
      tblModelSubject.addRow(new Object[]{subjectName, subjectCredits, subjectTeacher.getName()});
    }
  }

  private void sendDataToTblSemesters() {
    // Clear the table model first
    formController.getTblModelSemester().setRowCount(0);

    DefaultTableModel tblModelSemester = formController.getTblModelSemester();

    semesters.forEach(semester -> {
      String semesterName = semester.getName();
      int totalCredits = Database.getTotalCreditsOfSemester(semester.getId());
      tblModelSemester.addRow(new Object[]{semesterName, totalCredits});
    });
  }

  private void sendDataToTblTeachers() {
    // Clear the table model first
    formController.getTblModelTeacher().setRowCount(0);

    DefaultTableModel tblModelTeacher = formController.getTblModelTeacher();

    teachers.forEach(teacher -> {
      String name = teacher.getName();
      String phoneNumber = teacher.getPhoneNumber();
      tblModelTeacher.addRow(new Object[]{name, phoneNumber});
    });

  }

  private void sendDataToTblExams() {
    formController.getTblModelExam().setRowCount(0);

    DefaultTableModel tblModelExam = formController.getTblModelExam();

    exams.forEach(exam -> {
      String subjectName = exam.getSubject().getName();
      String date = exam.getDate().toString();
      String startTime = exam.getStartTime().toString();
      String description = exam.getDescription();

      tblModelExam.addRow(new Object[] {subjectName, date, startTime, description});
    });

  }

  private void updateAllTable() {
    sendDataToTblSemesters();
    sendDataToTblSubjects();
    sendDataToTblTeachers();
  }

  private void updateTblExams() {
    formController.getTblModelExam().setRowCount(0);

    exams = Database.getExams();

    DefaultTableModel tblModelExam = formController.getTblModelExam();

    exams.forEach(exam -> {
      String subjectName = exam.getSubject().getName();
      String date = exam.getDate().toString();
      String startTime = exam.getStartTime().toString();
      String description = exam.getDescription();

      tblModelExam.addRow(new Object[] {subjectName, date, startTime, description});
    });
  }

  private void updateTblSemesters() {
    // Clear the table model first
    formController.getTblModelSemester().setRowCount(0);

    semesters = Database.getSemesters();

    DefaultTableModel tblModelSemester = formController.getTblModelSemester();

    semesters.forEach(semester -> {
      String semesterName = semester.getName();
      int totalCredits = Database.getTotalCreditsOfSemester(semester.getId());
      tblModelSemester.addRow(new Object[]{semesterName, totalCredits});
    });
  }

  private void updateTblTeachers() {
    // Clear the table model first
    formController.getTblModelTeacher().setRowCount(0);

    teachers = Database.getTeachers();

    DefaultTableModel tblModelTeacher = formController.getTblModelTeacher();

    teachers.forEach(teacher -> {
      String name = teacher.getName();
      String phoneNumber = teacher.getPhoneNumber();
      tblModelTeacher.addRow(new Object[]{name, phoneNumber});
    });
  }

  private void updateTblSubjects() {
    // Clear the table model first
    formController.getTblModelSubject().setRowCount(0);

    subjects = Database.getSubjects();

    DefaultTableModel tblModelSubject = formController.getTblModelSubject();

    for (Subject eachSubject : subjects) {
      String subjectName = eachSubject.getName();
      int subjectCredits = eachSubject.getCredits();
      Teacher subjectTeacher = eachSubject.getTeacher();
      tblModelSubject.addRow(new Object[]{subjectName, subjectCredits, subjectTeacher.getName()});
    }
  }
}
