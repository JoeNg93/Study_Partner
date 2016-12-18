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
import java.util.List;

public class FrmMain {

  private JPanel pnMain;
  private JTabbedPane tabbedPane1;

  private JPanel pnNotifications;

  // SUBJECT TAB
  private JPanel pnSubjects;
  private JComboBox cbbSubjectChooseSemester;
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
  private JComboBox cbbExamChooseDate;
  private JButton btnAddExam;
  private JButton btnEditExam;
  private JButton btnDeleteExam;
  private FrmAddExam frmAddExam;

  private FormController formController;

  private List<Subject> subjects;
  private List<Teacher> teachers;
  private List<Semester> semesters;
  private List<Exam> exams;

  public FrmMain() {
    formController = new FormController();

    /* -------------------- SUBJECT TAB -------------------- */
    /* cbbSubjectChooseSemester initialization */
    cbbSubjectChooseSemester.setModel(formController.getCbbModelSubjectChooseSemester());
    formController.updateCbbModelSubjectChooseSemester();
    handleClickOnCbbSubjectChooseSemester();

    /* tblSubjects initialization */
    tblSubjects.setModel(formController.getTblModelSubject());
    tblSubjects.setFont(new Font("Serif", Font.PLAIN, 15));
    tblSubjects.setDefaultEditor(Object.class, null); // set the table uneditable
    updateTblSubjects();

    /* btnAddSubject initialization */
    handleClickOnBtnAddSubject();

    /* frmAddSubject initialization */
    frmAddSubject = new FrmAddSubject();
    frmAddSubject.getCbbSubjectSemester().setModel(formController.getCbbModelSubjectSemester());
    frmAddSubject.getCbbSubjectTeacher().setModel(formController.getCbbModelSubjectTeacher());
    handleConfirmOnBtnAddSubject();

    /* btnEditSubject initialization */
    handleClickOnBtnEditSubject();

    /* frmEditSubject initialization */
    frmEditSubject = new FrmEditSubject();
    frmEditSubject.getCbbSubjectSemester().setModel(formController.getCbbModelSubjectSemester());
    frmEditSubject.getCbbSubjectTeacher().setModel(formController.getCbbModelSubjectTeacher());
    handleConfirmOnBtnEditSubject();

    /* btnDeleteSubject initialization */
    handleClickOnBtnDeleteSubject();

    /* -------------------- SEMESTER TAB -------------------- */
    /* tblSemesters initialization*/
    tblSemesters.setModel(formController.getTblModelSemester());
    tblSemesters.setFont(new Font("Serif", Font.PLAIN, 15));
    tblSemesters.setDefaultEditor(Object.class, null);
    updateTblSemesters();

    /* btnAddSemester initialization*/
    handleClickOnBtnAddSemester();

    /* frmAddSemester initialization */
    frmAddSemester = new FrmAddSemester();
    frmAddSemester.getCbbSemesterTerm().setModel(formController.getCbbModelSemesterTerm());
    handleConfirmOnBtnAddSemester();

    /* btnEditSemester initialization */
    handleClickOnBtnEditSemester();

    /* frmEditSemester initialization */
    frmEditSemester = new FrmEditSemester();
    frmEditSemester.getCbbSemesterTerm().setModel(formController.getCbbModelSemesterTerm());
    handleConfirmOnBtnEditSemester();

    /* btnDeleteSemester initialization */
    handleClickOnBtnDeleteSemester();

    /* -------------------- TEACHER TAB -------------------- */
    /* tblTeachers initialization */
    tblTeachers.setModel(formController.getTblModelTeacher());
    tblTeachers.setFont(new Font("Serif", Font.PLAIN, 15));
    tblTeachers.setDefaultEditor(Object.class, null);
    updateTblTeachers();

    /* btnAddTeacher initialization */
    handleClickOnBtnAddTeacher();

    /* frmAddTeacher initialization */
    frmAddTeacher = new FrmAddTeacher();
    handleConfirmOnBtnAddTeacher();

    /* btnEditTeacher initialization */
    handleClickOnBtnEditTeacher();

    /* frmEditTeacher initialization */
    frmEditTeacher = new FrmEditTeacher();
    handleConfirmOnBtnEditTeacher();

    /* btnDeleteTeacher initialization */
    handleClickOnBtnDeleteTeacher();

    /* -------------------- EXAM TAB -------------------- */
    /* cbbExamChooseDate initialization */
    cbbExamChooseDate.setModel(formController.getCbbModelExamChooseDate());
    formController.updateCbbModelExamChooseDate();
    handleClickOnCbbExamChooseDate();

    /* tblExams initialization */
    tblExams.setModel(formController.getTblModelExam());
    tblExams.setFont(new Font("Serif", Font.PLAIN, 15));
    tblExams.setDefaultEditor(Object.class, null);
    updateTblExams();

    /* btnAddExam initialization */
    handleClickOnBtnAddExam();

    /* frmAddExam initialization */
    frmAddExam = new FrmAddExam();
    handleConfirmOnBtnAddExam();
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Study Partner");
    frame.setContentPane(new FrmMain().pnMain);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(700, 700);
    frame.setVisible(true);

  }

  /* -------------------- SUBJECT TAB -------------------- */
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

  public void handleClickOnCbbSubjectChooseSemester() {
    cbbSubjectChooseSemester.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (cbbSubjectChooseSemester.getSelectedIndex() != 0) {
          fetchDataAccordingToCbbSemesterSelectedIndex();
          sendDataToTblSubjects();
        } else {
          updateTblSubjects();
        }
      }
    });
  }

  public void handleClickOnBtnAddSubject() {
    btnAddSubject.addActionListener((ActionEvent e) -> {
      frmAddSubject.getCbbSubjectSemester().setSelectedIndex(cbbSubjectChooseSemester.getSelectedIndex());
      frmAddSubject.setVisible(true);
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

  public void handleClickOnBtnEditSubject() {
    btnEditSubject.addActionListener(evt -> {
      frmEditSubject.setVisible(true);

      int selectedRow = tblSubjects.getSelectedRow();
      String subjectName = (String) tblSubjects.getValueAt(selectedRow, 0);
      int credits = (Integer) tblSubjects.getValueAt(selectedRow, 1);
      String teacherName = (String) tblSubjects.getValueAt(selectedRow, 2);
      String semesterName = (String) cbbSubjectChooseSemester.getSelectedItem();

      frmEditSubject.getTxtName().setText(subjectName);
      frmEditSubject.getTxtCredits().setText(String.valueOf(credits));
      frmEditSubject.getCbbSubjectTeacher().setSelectedItem(teacherName);
      frmEditSubject.getCbbSubjectSemester().setSelectedItem(semesterName);
    });
  }

  public void handleConfirmOnBtnEditSubject() {
    frmEditSubject.getBtnEditSubject().addActionListener(evt -> {
      int selectedRow = tblSubjects.getSelectedRow();
      String currentSubjectName = (String) tblSubjects.getValueAt(selectedRow, 0);
      Subject subject = Database.getSubjectAccordingToName(currentSubjectName);

      String subjectName = frmEditSubject.getTxtName().getText();
      int credits = Integer.parseInt(frmEditSubject.getTxtCredits().getText());

      String semesterName = (String) frmEditSubject.getCbbSubjectSemester().getSelectedItem();
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      String teacherName = (String) frmEditSubject.getCbbSubjectTeacher().getSelectedItem();
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

  /* -------------------- SEMESTER TAB -------------------- */
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

  public void handleClickOnBtnAddSemester() {
    btnAddSemester.addActionListener((ActionEvent e) -> {
      frmAddSemester.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddSemester() {
    frmAddSemester.getBtnAddSemester().addActionListener((ActionEvent e) -> {
      String academicYear = frmAddSemester.getTxtAcademicYear().getText();
      String academicTerm = null;

      int selectedIndex = frmAddSemester.getCbbSemesterTerm().getSelectedIndex();
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
      formController.updateCbbModelSubjectChooseSemester();
      updateTblSubjects();
      frmAddSemester.dispose();
    });
  }

  public void handleClickOnBtnEditSemester() {
    btnEditSemester.addActionListener(evt -> {
      frmEditSemester.setVisible(true);

      int selectedRow = tblSemesters.getSelectedRow();
      String[] academicTermAndYear = ((String) tblSemesters.getValueAt(selectedRow, 0)).split(" ");
      String academicTerm = academicTermAndYear[0];
      String academicYear = academicTermAndYear[1];

      frmEditSemester.getCbbSemesterTerm().setSelectedItem(academicTerm);
      frmEditSemester.getTxtAcademicYear().setText(academicYear);
    });
  }

  public void handleConfirmOnBtnEditSemester() {
    frmEditSemester.getBtnEditSemester().addActionListener(evt -> {
      int selectedRow = tblSemesters.getSelectedRow();
      String semesterName = (String) tblSemesters.getValueAt(selectedRow, 0);
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      String academicTerm = (String) frmEditSemester.getCbbSemesterTerm().getSelectedItem();
      String academicYear = frmEditSemester.getTxtAcademicYear().getText();

      semester.setName(academicTerm + " " + academicYear);
      Database.updateSemesterAccordingToId(semester);
      updateTblSemesters();
      formController.updateCbbModelSubjectChooseSemester();
      updateTblSubjects();
      frmEditSemester.dispose();
    });
  }

  public void handleClickOnBtnDeleteSemester() {
    btnDeleteSemester.addActionListener(e -> {
      int selectedRow = tblSemesters.getSelectedRow();
      String semesterName = (String) tblSemesters.getValueAt(selectedRow, 0);

      Database.deleteSemesterAccordingToName(semesterName);
      updateTblSemesters();
      formController.updateCbbModelSubjectChooseSemester();
      updateTblSubjects();
    });
  }

  /* -------------------- TEACHER TAB -------------------- */
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
      formController.updateCbbModelSubjectTeacher();
      frmAddTeacher.dispose();
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
      formController.updateCbbModelSubjectTeacher();
      frmEditTeacher.dispose();
    });
  }

  public void handleClickOnBtnDeleteTeacher() {
    btnDeleteTeacher.addActionListener(evt -> {
      int selectedRow = tblTeachers.getSelectedRow();
      String teacherName = (String) tblTeachers.getValueAt(selectedRow, 0);

      Database.deleteTeacherAccordingToName(teacherName);
      updateTblTeachers();
      formController.updateCbbModelSubjectTeacher();
    });
  }

  /* -------------------- EXAM TAB -------------------- */
  public void handleClickOnCbbExamChooseDate() {
    cbbExamChooseDate.addActionListener(evt -> {
      if (cbbExamChooseDate.getSelectedIndex() != 0) {
        String examDateInString = (String) cbbExamChooseDate.getSelectedItem();
        LocalDate examDate = LocalDate.parse(examDateInString);
        exams = Database.getExamsAccordingToDate(examDate);
        sendDataToTblExams();
      } else {
        updateTblExams();
      }
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

      tblModelExam.addRow(new Object[]{subjectName, date, startTime, description});
    });
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

      tblModelExam.addRow(new Object[]{subjectName, date, startTime, description});
    });
  }

  public void handleClickOnBtnAddExam() {
    btnAddExam.addActionListener(e -> {
      frmAddExam.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddExam() {

  }

  /* -------------------- OTHER STUFF -------------------- */
  private void updateAllTable() {
    sendDataToTblSemesters();
    sendDataToTblSubjects();
    sendDataToTblTeachers();
  }

}
