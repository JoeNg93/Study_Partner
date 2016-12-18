package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/5/16.
 */
public class FrmEditTeacher extends JFrame{
  private JPanel pnEditTeacher;
  private JTextField txtName;
  private JTextField txtPhoneNumber;
  private JButton btnEditTeacher;

  public FrmEditTeacher() {
    setContentPane(pnEditTeacher);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public JTextField getTxtPhoneNumber() {
    return txtPhoneNumber;
  }

  public JButton getBtnEditTeacher() {
    return btnEditTeacher;
  }
}
