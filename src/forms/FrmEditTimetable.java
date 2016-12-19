package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/19/16.
 */
public class FrmEditTimetable extends JFrame{
  private JPanel pnEditTimetable;
  private JComboBox cbbTimetableSubject;
  private JComboBox cbbTimetableDay;
  private JTextField txtRoomNumber;
  private JTextField txtStartTime;
  private JTextField txtEndTime;
  private JComboBox cbbTimetableTeacher;
  private JComboBox cbbTimetableSemester;
  private JButton btnEditTimetable;

  public FrmEditTimetable() {
    setContentPane(pnEditTimetable);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 500);
    setVisible(false);
  }

  public JPanel getPnEditTimetable() {
    return pnEditTimetable;
  }

  public JComboBox getCbbTimetableSubject() {
    return cbbTimetableSubject;
  }

  public JComboBox getCbbTimetableDay() {
    return cbbTimetableDay;
  }

  public JTextField getTxtRoomNumber() {
    return txtRoomNumber;
  }

  public JTextField getTxtStartTime() {
    return txtStartTime;
  }

  public JTextField getTxtEndTime() {
    return txtEndTime;
  }

  public JComboBox getCbbTimetableTeacher() {
    return cbbTimetableTeacher;
  }

  public JComboBox getCbbTimetableSemester() {
    return cbbTimetableSemester;
  }

  public JButton getBtnEditTimetable() {
    return btnEditTimetable;
  }
}
