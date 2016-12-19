package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/18/16.
 */
public class FrmEditExam extends JFrame{
  private JPanel pnEditExam;
  private JComboBox cbbExamSubject;
  private JTextField txtDate;
  private JTextField txtStartTime;
  private JTextField txtDescription;
  private JButton btnEditExam;

  public FrmEditExam() {
    setContentPane(pnEditExam);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 300);
    setVisible(false);
  }

  public JButton getBtnEditExam() {
    return btnEditExam;
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
