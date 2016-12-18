package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/5/16.
 */
public class FrmAddTeacher extends JFrame {
  private JPanel pnAddTeacher;
  private JTextField txtTeacherName;
  private JTextField txtPhoneNumber;
  private JButton btnAddTeacher;

  public  FrmAddTeacher() {
    setContentPane(pnAddTeacher);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JTextField getTxtTeacherName() {
    return txtTeacherName;
  }

  public JTextField getTxtPhoneNumber() {
    return txtPhoneNumber;
  }

  public JButton getBtnAddTeacher() {
    return btnAddTeacher;
  }
}
