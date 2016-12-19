// TODO: Finish everything in Timetable tab except tblTimetables

package forms;

import objects.*;
import utilities.Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
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
  private FrmEditExam frmEditExam;

  // TIMETABLE TAB
  private JPanel pnTimeTable;
  private JComboBox cbbTimetableChooseSemester;
  private JComboBox cbbTimetableChooseDay;
  private JComboBox cbbTimetableChooseSubject;
  private JButton btnAddTimetable;
  private JButton btnEditTimetable;
  private JButton btnDeleteTimetable;
  private JTable tblTimetables;
  private FrmAddTimetable frmAddTimetable;
  private FrmEditTimetable frmEditTimetable;

  private FormController formController;

  private List<Subject> subjects;
  private List<Teacher> teachers;
  private List<Semester> semesters;
  private List<Exam> exams;
  private List<TimeTable> timetables;

  public FrmMain() {
    formController = new FormController();

    /* -------------------- SUBJECT TAB -------------------- */
    /* cbbSubjectChooseSemester initialization */
    formController.updateCbbModelSubjectChooseSemester();
    cbbSubjectChooseSemester.setModel(formController.getCbbModelSubjectChooseSemester());
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
    cbbExamChooseDate.setModel(formController.getCbbModelExamChooseDate());
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
    frmAddExam.getCbbExamSubject().setModel(formController.getCbbModelExamSubject());
    handleConfirmOnBtnAddExam();

    /* btnEditExam initialization */
    handleClickOnBtnEditExam();

    /* frmEditExam initialization */
    frmEditExam = new FrmEditExam();
    frmEditExam.getCbbExamSubject().setModel(formController.getCbbModelExamSubject());
    handleConfirmOnBtnEditExam();

    /* btnDeleteExam initialization */
    handleClickOnBtnDeleteExam();

    /* -------------------- TIME TABLE TAB -------------------- */
    /* cbbTimetableChooseSemester initialization */
    formController.updateCbbModelTimetableChooseSemester();
    cbbTimetableChooseSemester.setModel(formController.getCbbModelTimetableChooseSemester());
    handleClickOnCbbTimetableChooseSemester();

    /* cbbTimetableChooseDay initialization */
    formController.updateCbbModelTimetableChooseDay();
    cbbTimetableChooseDay.setModel(formController.getCbbModelTimetableChooseDay());
    handleClickOnCbbTimetableChooseDay();

    /* cbbTimetableChooseSubject initialization */
    formController.updateCbbModelTimetableChooseSubject();
    cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
    handleClickCbbTimetableChooseSubject();

    /* tblTimetables initialization */
    tblTimetables.setModel(formController.getTblModelTimetable());
    tblTimetables.setFont(new Font("Serif", Font.PLAIN, 15));
    tblTimetables.setDefaultEditor(Object.class, null);
    updateTblTimetables();

    /* btnAddTimetable initialization */
    handleClickOnBtnAddTimetable();

    /* frmAddTimetable initialization */
    frmAddTimetable = new FrmAddTimetable();
    frmAddTimetable.getCbbTimetableSubject().setModel(formController.getCbbModelTimetableSubject());
    frmAddTimetable.getCbbTimetableDay().setModel(formController.getCbbModelTimetableDay());
    frmAddTimetable.getCbbTimetableTeacher().setModel(formController.getCbbModelTimetableTeacher());
    frmAddTimetable.getCbbTimetableSemester().setModel(formController.getCbbModelTimetableSemester());
    handleConfirmOnBtnAddTimetable();

    /* btnEditTimetable initialization */
    handleClickOnBtnEditTimetable();

    /* frmEditTimetable initialization */
    frmEditTimetable = new FrmEditTimetable();
    frmEditTimetable.getCbbTimetableSemester().setModel(formController.getCbbModelTimetableSemester());
    frmEditTimetable.getCbbTimetableDay().setModel(formController.getCbbModelTimetableDay());
    frmEditTimetable.getCbbTimetableSubject().setModel(formController.getCbbModelTimetableSubject());
    frmEditTimetable.getCbbTimetableTeacher().setModel(formController.getCbbModelTimetableTeacher());
    handleConfirmOnBtnEditTimetable();

    /* btnDeleteTimetable initialization */
    handleClickOnBtnDeleteTimetable();
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
    subjects = Database.getSubjects();
    sendDataToTblSubjects();
  }

  public void handleClickOnCbbSubjectChooseSemester() {
    cbbSubjectChooseSemester.addActionListener(e -> {
      if (cbbSubjectChooseSemester.getSelectedIndex() != 0) {
        subjects = Database.getSubjectsAccordingToSemesterName((String) cbbSubjectChooseSemester.getSelectedItem());
        sendDataToTblSubjects();
      } else {
        updateTblSubjects();
      }
    });
  }

  public void handleClickOnBtnAddSubject() {
    btnAddSubject.addActionListener((ActionEvent e) -> {
      clearForm(frmAddSubject);
      formController.updateCbbModelSubjectSemester();
      frmAddSubject.getCbbSubjectSemester().setModel(formController.getCbbModelSubjectSemester());
      formController.updateCbbModelSubjectTeacher();
      frmAddSubject.getCbbSubjectTeacher().setModel(formController.getCbbModelSubjectTeacher());
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
      cbbSubjectChooseSemester.setSelectedIndex(frmAddSubject.getCbbSubjectSemester().getSelectedIndex());
      updateTblSemesters();
      formController.updateCbbModelTimetableChooseSubject();
      cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
      frmAddSubject.dispose();
    });
  }

  public void handleClickOnBtnEditSubject() {
    btnEditSubject.addActionListener(evt -> {
      formController.updateCbbModelSubjectTeacher();
      frmEditSubject.getCbbSubjectTeacher().setModel(formController.getCbbModelSubjectTeacher());
      formController.updateCbbModelSubjectSemester();
      frmEditSubject.getCbbSubjectSemester().setModel(formController.getCbbModelSubjectSemester());
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
      fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex();
      sendDataToTblSubjects();
      updateTblSemesters();
      // Trigger Exam Tab
      cbbExamChooseDate.setSelectedIndex(cbbExamChooseDate.getSelectedIndex());
      // Reset Timetable tab
      formController.updateCbbModelTimetableChooseSubject();
      cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
      cbbTimetableChooseSemester.setSelectedIndex(0);
      cbbTimetableChooseDay.setSelectedIndex(0);
      updateTblTimetables();
      frmEditSubject.dispose();
    });
  }

  public void handleClickOnBtnDeleteSubject() {
    btnDeleteSubject.addActionListener(evt -> {
      int selectedRow = tblSubjects.getSelectedRow();
      String subjectName = (String) tblSubjects.getValueAt(selectedRow, 0);

      Database.deleteSubjectAccordingToName(subjectName);
      fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex();
      sendDataToTblSubjects();
      updateTblSemesters();
      // Trigger Exam Tab
      cbbExamChooseDate.setSelectedIndex(cbbExamChooseDate.getSelectedIndex());
      // Reset Timetable tab
      formController.updateCbbModelTimetableChooseSubject();
      cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
      cbbTimetableChooseSemester.setSelectedIndex(0);
      cbbTimetableChooseDay.setSelectedIndex(0);
      updateTblTimetables();
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
    semesters = Database.getSemesters();
    sendDataToTblSemesters();
  }

  public void handleClickOnBtnAddSemester() {
    btnAddSemester.addActionListener((ActionEvent e) -> {
      clearForm(frmAddSemester);
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
      String currentSelectSemester = (String) cbbSubjectChooseSemester.getSelectedItem();
      formController.updateCbbModelSubjectChooseSemester();
      cbbSubjectChooseSemester.setModel(formController.getCbbModelSubjectChooseSemester());
      cbbSubjectChooseSemester.setSelectedItem(currentSelectSemester);
      fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex();
      sendDataToTblSubjects();
      // Reset Timetable tab
      formController.updateCbbModelTimetableChooseSemester();
      cbbTimetableChooseSemester.setModel(formController.getCbbModelTimetableChooseSemester());
      cbbTimetableChooseSubject.setSelectedIndex(0);
      cbbTimetableChooseDay.setSelectedIndex(0);
      updateTblTimetables();
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
      cbbSubjectChooseSemester.setModel(formController.getCbbModelSubjectChooseSemester());
      updateTblSubjects();
      // Reset Timetable tab
      formController.updateCbbModelTimetableChooseSemester();
      cbbTimetableChooseSemester.setModel(formController.getCbbModelTimetableChooseSemester());
      cbbTimetableChooseSubject.setSelectedIndex(0);
      cbbTimetableChooseDay.setSelectedIndex(0);
      updateTblTimetables();
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
      cbbSubjectChooseSemester.setModel(formController.getCbbModelSubjectChooseSemester());
      updateTblSubjects();
      // Reset Timetable tab
      formController.updateCbbModelTimetableChooseSemester();
      cbbTimetableChooseSemester.setModel(formController.getCbbModelTimetableChooseSemester());
      cbbTimetableChooseSubject.setSelectedIndex(0);
      cbbTimetableChooseDay.setSelectedIndex(0);
      updateTblTimetables();
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
    teachers = Database.getTeachers();
    sendDataToTblTeachers();
  }

  public void handleClickOnBtnAddTeacher() {
    btnAddTeacher.addActionListener(evt -> {
      clearForm(frmAddTeacher);
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
      fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex();
      sendDataToTblSubjects();
      // Reset Time Table tab
      cbbTimetableChooseDay.setSelectedIndex(0);
      cbbTimetableChooseSemester.setSelectedIndex(0);
      cbbTimetableChooseSubject.setSelectedIndex(0);
      updateTblTimetables();
      frmEditTeacher.dispose();
    });
  }

  public void handleClickOnBtnDeleteTeacher() {
    btnDeleteTeacher.addActionListener(evt -> {
      int selectedRow = tblTeachers.getSelectedRow();
      String teacherName = (String) tblTeachers.getValueAt(selectedRow, 0);

      Database.deleteTeacherAccordingToName(teacherName);
      updateTblTeachers();
      fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex();
      sendDataToTblSubjects();
      // Reset Time Table tab
      cbbTimetableChooseDay.setSelectedIndex(0);
      cbbTimetableChooseSemester.setSelectedIndex(0);
      cbbTimetableChooseSubject.setSelectedIndex(0);
      updateTblTimetables();
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
    exams = Database.getExams();
    sendDataToTblExams();
  }

  public void handleClickOnBtnAddExam() {
    btnAddExam.addActionListener(e -> {
      clearForm(frmAddExam);
      formController.updateCbbModelExamSubject();
      frmAddExam.getCbbExamSubject().setModel(formController.getCbbModelExamSubject());
      int currentSelectedIndex = cbbExamChooseDate.getSelectedIndex();
      if (currentSelectedIndex != 0) {
        String examDate = (String) cbbExamChooseDate.getSelectedItem();
        frmAddExam.getTxtDate().setText(examDate);
      }
      frmAddExam.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddExam() {
    frmAddExam.getBtnAddExam().addActionListener(e -> {
      Subject subject = Database.getSubjectAccordingToName((String) frmAddExam.getCbbExamSubject().getSelectedItem());
      LocalDate examDate = LocalDate.parse(frmAddExam.getTxtDate().getText());
      LocalTime startTime = LocalTime.parse(frmAddExam.getTxtStartTime().getText());
      String description = frmAddExam.getTxtDescription().getText();

      Exam exam = new Exam(subject, startTime, examDate, description);
      Database.addExam(exam);
      updateTblExams();
      formController.updateCbbModelExamChooseDate();
      cbbExamChooseDate.setModel(formController.getCbbModelExamChooseDate());
      frmAddExam.dispose();
    });
  }

  public void handleClickOnBtnEditExam() {
    btnEditExam.addActionListener(e -> {
      formController.updateCbbModelExamSubject();
      frmEditExam.getCbbExamSubject().setModel(formController.getCbbModelExamSubject());
      frmEditExam.setVisible(true);

      int selectedRow = tblExams.getSelectedRow();
      String subjectName = (String) tblExams.getValueAt(selectedRow, 0);
      String examDate = (String) tblExams.getValueAt(selectedRow, 1);
      String startTime = (String) tblExams.getValueAt(selectedRow, 2);
      String description = (String) tblExams.getValueAt(selectedRow, 3);

      frmEditExam.getCbbExamSubject().setSelectedItem(subjectName);
      frmEditExam.getTxtDate().setText(examDate);
      frmEditExam.getTxtStartTime().setText(startTime);
      frmEditExam.getTxtDescription().setText(description);
    });
  }

  public void handleConfirmOnBtnEditExam() {
    frmEditExam.getBtnEditExam().addActionListener(e -> {
      int selectedRow = tblExams.getSelectedRow();
      Exam currentExam = Database.getExamsAccordingToSubjectName((String) tblExams.getValueAt(selectedRow, 0));

      Subject subject = Database.getSubjectAccordingToName((String) frmEditExam.getCbbExamSubject().getSelectedItem());
      LocalDate examDate = LocalDate.parse(frmEditExam.getTxtDate().getText());
      LocalTime startTime = LocalTime.parse(frmEditExam.getTxtStartTime().getText());
      String description = frmEditExam.getTxtDescription().getText();

      currentExam.setSubject(subject);
      currentExam.setDate(examDate);
      currentExam.setStartTime(startTime);
      currentExam.setDescription(description);

      Database.updateExamAccordingToId(currentExam);
      updateTblExams();
      formController.updateCbbModelExamChooseDate();
      cbbExamChooseDate.setModel(formController.getCbbModelExamChooseDate());
      frmEditExam.dispose();
    });
  }

  public void handleClickOnBtnDeleteExam() {
    btnDeleteExam.addActionListener(e -> {
      int selectedRow = tblExams.getSelectedRow();
      Exam currentExam = Database.getExamsAccordingToSubjectName((String) tblExams.getValueAt(selectedRow, 0));
      Database.deleteExamAccordingToId(currentExam.getId());
      cbbExamChooseDate.setSelectedIndex(0);
      updateTblExams();
      formController.updateCbbModelExamChooseDate();
      cbbExamChooseDate.setModel(formController.getCbbModelExamChooseDate());
    });
  }

  /* -------------------- TIMETABLE TAB -------------------- */
  public void handleClickOnCbbTimetableChooseSemester() {
    cbbTimetableChooseSemester.addActionListener(e -> {
      if (cbbTimetableChooseSemester.getSelectedIndex() != 0) {
        String semesterName = (String) cbbTimetableChooseSemester.getSelectedItem();
        formController.updateCbbModelTimetableChooseSubjectAccordingToSemester(semesterName);
        cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());

        if (cbbTimetableChooseDay.getSelectedIndex() == 0 && cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToSemesterName((String) cbbTimetableChooseSemester.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseDay.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          String dayName = (String) cbbTimetableChooseDay.getSelectedItem();
          timetables = Database.getTimeTablesAccordingToSemesterAndDay(semesterName, dayName);
          sendDataToTblTimetables();
        } else {
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        }
      } else {
        if (cbbTimetableChooseDay.getSelectedIndex() == 0 && cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          updateTblTimetables();
        } else if (cbbTimetableChooseDay.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToDay((String) cbbTimetableChooseDay.getSelectedItem());
          sendDataToTblTimetables();
        } else {
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        }
      }
    });
  }

  public void handleClickOnCbbTimetableChooseDay() {
    cbbTimetableChooseDay.addActionListener(e -> {
      if (cbbTimetableChooseDay.getSelectedIndex() != 0) {
        if (cbbTimetableChooseSemester.getSelectedIndex() == 0 && cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToDay((String) cbbTimetableChooseDay.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseSemester.getSelectedIndex() == 0) {
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          String semesterName = (String) cbbTimetableChooseSemester.getSelectedItem();
          String dayName = (String) cbbTimetableChooseDay.getSelectedItem();
          formController.updateCbbModelTimetableChooseSubjectAccordingToSemesterAndDay(semesterName, dayName);
          cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
          timetables = Database.getTimeTablesAccordingToSemesterAndDay(semesterName, dayName);
          sendDataToTblTimetables();
        } else {
          // Get timetable according to subject
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        }
      } else {
        String currentSubjectName = (String) cbbTimetableChooseSubject.getSelectedItem();
        formController.updateCbbModelTimetableChooseSubject();
        cbbTimetableChooseSubject.setModel(formController.getCbbModelTimetableChooseSubject());
        cbbTimetableChooseSubject.setSelectedItem(currentSubjectName);
        if (cbbTimetableChooseSubject.getSelectedIndex() == 0 && cbbTimetableChooseSemester.getSelectedIndex() == 0) {
          updateTblTimetables();
        } else if (cbbTimetableChooseSubject.getSelectedIndex() == 0) {
          // Get timetable according to semester
          timetables = Database.getTimeTablesAccordingToSemesterName((String) cbbTimetableChooseSemester.getSelectedItem());
          sendDataToTblTimetables();
        } else if (cbbTimetableChooseSemester.getSelectedIndex() == 0) {
          // Get timetable according to subject
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        } else {
          // Get timetable according to subject
          timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
          sendDataToTblTimetables();
        }
      }
    });
  }

  public void handleClickCbbTimetableChooseSubject() {
    cbbTimetableChooseSubject.addActionListener(e -> {
      if (cbbTimetableChooseSubject.getSelectedIndex() != 0) {
        // Get timetable according to subject
        timetables = Database.getTimeTablesAccordingToSubjectName((String) cbbTimetableChooseSubject.getSelectedItem());
        sendDataToTblTimetables();
      } else {
        if (cbbTimetableChooseSemester.getSelectedIndex() == 0 && cbbTimetableChooseDay.getSelectedIndex() == 0) {
          updateTblTimetables();
        }
      }
    });
  }

  public void handleClickOnBtnAddTimetable() {
    btnAddTimetable.addActionListener(e -> {
      clearForm(frmAddTimetable);
      formController.updateCbbModelTimetableDay();
      frmAddTimetable.getCbbTimetableDay().setModel(formController.getCbbModelTimetableDay());
      formController.updateCbbModelTimetableSemester();
      frmAddTimetable.getCbbTimetableSemester().setModel(formController.getCbbModelTimetableSemester());
      formController.updateCbbModelTimetableSubject();
      frmAddTimetable.getCbbTimetableSubject().setModel(formController.getCbbModelTimetableSubject());
      formController.updateCbbModelTimetableTeacher();
      frmAddTimetable.getCbbTimetableTeacher().setModel(formController.getCbbModelTimetableTeacher());
      frmAddTimetable.getCbbTimetableSemester().setSelectedIndex(cbbTimetableChooseSemester.getSelectedIndex());
      frmAddTimetable.getCbbTimetableDay().setSelectedIndex(cbbTimetableChooseDay.getSelectedIndex());
      frmAddTimetable.getCbbTimetableSubject().setSelectedIndex(cbbTimetableChooseSubject.getSelectedIndex());
      frmAddTimetable.setVisible(true);
    });
  }

  public void handleConfirmOnBtnAddTimetable() {
    frmAddTimetable.getBtnAddTimetable().addActionListener(e -> {
      String subjectName = (String) frmAddTimetable.getCbbTimetableSubject().getSelectedItem();
      Subject subject = Database.getSubjectAccordingToName(subjectName);
      int dayNumber = FormController.getDayNumber((String) frmAddTimetable.getCbbTimetableDay().getSelectedItem());
      String roomNumber = frmAddTimetable.getTxtRoomNumber().getText();
      LocalTime startTime = LocalTime.parse(frmAddTimetable.getTxtStartTime().getText());
      LocalTime endTime = LocalTime.parse(frmAddTimetable.getTxtEndTime().getText());
      String teacherName = (String) frmAddTimetable.getCbbTimetableTeacher().getSelectedItem();
      Teacher teacher = Database.getTeacherAccordingToName(teacherName);
      String semesterName = (String) frmAddTimetable.getCbbTimetableSemester().getSelectedItem();
      Semester semester = Database.getSemesterAccordingToName(semesterName);

      TimeTable timeTable = new TimeTable(subject, dayNumber, roomNumber, startTime, endTime, teacher, semester);
      Database.addTimeTable(timeTable);
      updateTblTimetables();
      frmAddTimetable.dispose();
    });
  }

  public void handleClickOnBtnEditTimetable() {
    btnEditTimetable.addActionListener(e -> {
      formController.updateCbbModelTimetableTeacher();
      frmEditTimetable.getCbbTimetableTeacher().setModel(formController.getCbbModelTimetableTeacher());
      formController.updateCbbModelTimetableSubject();
      frmEditTimetable.getCbbTimetableSubject().setModel(formController.getCbbModelTimetableSubject());
      formController.updateCbbModelTimetableSemester();
      frmEditTimetable.getCbbTimetableSemester().setModel(formController.getCbbModelTimetableSemester());
      formController.updateCbbModelTimetableDay();
      frmEditTimetable.getCbbTimetableDay().setModel(formController.getCbbModelTimetableDay());

      int selectedRow = tblTimetables.getSelectedRow();
      String subjectName = (String) tblTimetables.getValueAt(selectedRow, 0);
      String dayName = (String) tblTimetables.getValueAt(selectedRow, 1);
      String roomNumber = (String) tblTimetables.getValueAt(selectedRow, 2);
      String startTime = (String) tblTimetables.getValueAt(selectedRow, 3);
      String endTime = (String) tblTimetables.getValueAt(selectedRow, 4);
      String teacherName = (String) tblTimetables.getValueAt(selectedRow, 5);
      String semesterName = (String) tblTimetables.getValueAt(selectedRow, 6);

      frmEditTimetable.getCbbTimetableSemester().setSelectedItem(semesterName);
      frmEditTimetable.getCbbTimetableSubject().setSelectedItem(subjectName);
      frmEditTimetable.getCbbTimetableTeacher().setSelectedItem(teacherName);
      frmEditTimetable.getCbbTimetableDay().setSelectedItem(dayName);
      frmEditTimetable.getTxtStartTime().setText(startTime);
      frmEditTimetable.getTxtEndTime().setText(endTime);
      frmEditTimetable.getTxtRoomNumber().setText(roomNumber);
      frmEditTimetable.setVisible(true);
    });
  }

  public void handleConfirmOnBtnEditTimetable() {
    frmEditTimetable.getBtnEditTimetable().addActionListener(e -> {
      int selectedRow = tblTimetables.getSelectedRow();

      String currentSubjectName = (String) tblTimetables.getValueAt(selectedRow, 0);
      String currentDayName = (String) tblTimetables.getValueAt(selectedRow, 1);
      String currentStartTime = (String) tblTimetables.getValueAt(selectedRow, 3);
      String currentSemesterName = (String) tblTimetables.getValueAt(selectedRow, 6);
      TimeTable timeTable = Database.getTimeTableAccordingToSubjectSemesterDayStartTime(currentSubjectName,
          currentSemesterName, currentDayName, currentStartTime);

      String subjectName = (String) frmEditTimetable.getCbbTimetableSubject().getSelectedItem();
      Subject subject = Database.getSubjectAccordingToName(subjectName);
      String dayName = (String) frmEditTimetable.getCbbTimetableDay().getSelectedItem();
      int dayNumber = FormController.getDayNumber(dayName);
      String teacherName = (String) frmEditTimetable.getCbbTimetableTeacher().getSelectedItem();
      Teacher teacher = Database.getTeacherAccordingToName(teacherName);
      String semesterName = (String) frmEditTimetable.getCbbTimetableSemester().getSelectedItem();
      Semester semester = Database.getSemesterAccordingToName(semesterName);
      String roomNumber = frmEditTimetable.getTxtRoomNumber().getText();
      LocalTime startTime = LocalTime.parse(frmEditTimetable.getTxtStartTime().getText());
      LocalTime endTime = LocalTime.parse(frmEditTimetable.getTxtEndTime().getText());

      timeTable.setSubject(subject);
      timeTable.setDay(dayNumber);
      timeTable.setRoomNumber(roomNumber);
      timeTable.setTeacher(teacher);
      timeTable.setSemester(semester);
      timeTable.setStartTime(startTime);
      timeTable.setEndTime(endTime);

      Database.updateTimeTableAccordingToId(timeTable);
      updateTblTimetables();
      frmEditTimetable.dispose();
    });
  }

  public void handleClickOnBtnDeleteTimetable() {
    btnDeleteTimetable.addActionListener(e -> {
      int selectedRow = tblTimetables.getSelectedRow();
      String subjectName = (String) tblTimetables.getValueAt(selectedRow, 0);
      String dayName = (String) tblTimetables.getValueAt(selectedRow, 1);
      String startTime = (String) tblTimetables.getValueAt(selectedRow, 3);
      Database.deleteTimetableAccordingToSubjectDayStartTime(subjectName, dayName, startTime);
      cbbTimetableChooseDay.setSelectedIndex(0);
      cbbTimetableChooseSemester.setSelectedIndex(0);
      cbbTimetableChooseSubject.setSelectedIndex(0);
      updateTblTimetables();
    });
  }

  public void sendDataToTblTimetables() {
    DefaultTableModel tblModelTimetable = formController.getTblModelTimetable();
    tblModelTimetable.setRowCount(0);

    for (TimeTable timetable : timetables) {
      String subjectName = timetable.getSubject().getName();
      String dayName = FormController.getDayName(timetable.getDay());
      String roomNumber = timetable.getRoomNumber();
      String startTime = timetable.getStartTime().toString();
      String endTime = timetable.getEndTime().toString();
      String teacherName = timetable.getTeacher().getName();
      String semesterName = timetable.getSemester().getName();
      tblModelTimetable.addRow(new Object[]{subjectName, dayName, roomNumber, startTime, endTime, teacherName, semesterName});
    }
  }

  public void updateTblTimetables() {
    timetables = Database.getTimeTables();
    sendDataToTblTimetables();
  }

  /* -------------------- OTHER STUFF -------------------- */
  private void updateAllTable() {
    sendDataToTblSemesters();
    sendDataToTblSubjects();
    sendDataToTblTeachers();
  }

  private void clearForm(JFrame form) {
    for (Component component : form.getContentPane().getComponents()) {
      if (component instanceof JTextField) {
        ((JTextField) component).setText("");
      }
    }
  }

  private void fetchSubjectsAccordingToCbbSubjectChooseSemesterSelectedIndex() {
    if (cbbSubjectChooseSemester.getSelectedIndex() != 0) {
      subjects = Database.getSubjectsAccordingToSemesterName((String) cbbSubjectChooseSemester.getSelectedItem());
    } else {
      subjects = Database.getSubjects();
    }
  }
}
