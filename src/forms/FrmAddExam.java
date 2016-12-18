package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/5/16.
 */
public class FrmAddExam extends JFrame {
  private JPanel pnAddExam;
  private JComboBox cbbExamSubject;
  private JTextField txtDate;
  private JTextField txtStartTime;
  private JTextField txtDescription;
  private JButton btnAddExam;

  public FrmAddExam() {
    setContentPane(pnAddExam);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JButton getBtnAddExam() {
    return btnAddExam;
  }

  public JComboBox getCbbExamSubject() {
    return cbbExamSubject;
  }

  public JTextField getTxtDate() {
    return txtDate;
  }

  public JTextField getTxtDescription() {
    return txtDescription;
  }

  public JTextField getTxtStartTime() {
    return txtStartTime;
  }
}
