package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/19/16.
 */
public class FrmAddTimetable extends JFrame {
  private JPanel pnAddTimetable;
  private JComboBox cbbTimetableSubject;
  private JComboBox cbbTimetableDay;
  private JTextField txtRoomNumber;
  private JTextField txtStartTime;
  private JTextField txtEndTime;
  private JComboBox cbbTimetableTeacher;
  private JComboBox cbbTimetableSemester;
  private JButton btnAddTimetable;

  public FrmAddTimetable() {
    setContentPane(pnAddTimetable);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 500);
    setVisible(false);
  }

  public JTextField getTxtStartTime() {
    return txtStartTime;
  }

  public JButton getBtnAddTimetable() {
    return btnAddTimetable;
  }

  public JComboBox getCbbTimetableDay() {
    return cbbTimetableDay;
  }

  public JComboBox getCbbTimetableSemester() {
    return cbbTimetableSemester;
  }

  public JComboBox getCbbTimetableSubject() {
    return cbbTimetableSubject;
  }

  public JComboBox getCbbTimetableTeacher() {
    return cbbTimetableTeacher;
  }

  public JPanel getPnAddTimetable() {
    return pnAddTimetable;
  }

  public JTextField getTxtEndTime() {
    return txtEndTime;
  }

  public JTextField getTxtRoomNumber() {
    return txtRoomNumber;
  }
}
