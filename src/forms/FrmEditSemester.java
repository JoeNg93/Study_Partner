package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 12/5/16.
 */
public class FrmEditSemester extends JFrame {
  private JPanel pnEditSemester;
  private JTextField txtAcademicYear;
  private JComboBox cbbSemesterTerm;
  private JButton btnEditSemester;

  public FrmEditSemester() {
    setContentPane(pnEditSemester);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JButton getBtnEditSemester() {
    return btnEditSemester;
  }

  public JTextField getTxtAcademicYear() {
    return txtAcademicYear;
  }

  public JComboBox getCbbSemesterTerm() {
    return cbbSemesterTerm;
  }
}
