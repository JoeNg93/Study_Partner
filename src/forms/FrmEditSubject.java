package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/5/16.
 */
public class FrmEditSubject extends JFrame{
  private JPanel pnEditSubject;
  private JTextField txtName;
  private JButton btnEditSubject;
  private JTextField txtCredits;
  private JComboBox cbbSemester;
  private JComboBox cbbTeacher;

  public FrmEditSubject() {
    setContentPane(pnEditSubject);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JButton getBtnEditSubject() {
    return btnEditSubject;
  }

  public JComboBox getCbbSemester() {
    return cbbSemester;
  }

  public JComboBox getCbbTeacher() {
    return cbbTeacher;
  }

  public JTextField getTxtCredits() {
    return txtCredits;
  }

  public JTextField getTxtName() {
    return txtName;
  }
}
