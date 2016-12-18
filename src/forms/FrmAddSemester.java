package forms;

import javax.swing.*;

public class FrmAddSemester extends JFrame {
  private JPanel pnAddSemester;
  private JComboBox cbbChooseTerm;
  private JTextField txtAcademicYear;
  private JButton btnAddSemester;

  public FrmAddSemester() {
    setContentPane(pnAddSemester);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public JComboBox getCbbChooseTerm() {
    return cbbChooseTerm;
  }

  public JTextField getTxtAcademicYear() {
    return txtAcademicYear;
  }

  public JButton getBtnAddSemester() {
    return btnAddSemester;
  }
}
