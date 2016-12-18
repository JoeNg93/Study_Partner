package forms;

import javax.swing.*;

/**
 * Created by joenguyen on 10/7/16.
 */
public class FrmAddSubject extends JFrame {
  private JPanel pnAddSubject;
  private JTextField txtSubjectName;
  private JTextField txtSubjectCredits;
  private JComboBox cbbSubjectSemester;
  private JComboBox cbbSubjectTeacher;
  private JButton btnAddSubject;

  public FrmAddSubject() {
    setContentPane(pnAddSubject);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    pack();
    setVisible(false);
  }

  public void setModelForCbbSubjectSemester(DefaultComboBoxModel cbbModel) {
    cbbSubjectSemester.setModel(cbbModel);
  }

  public JComboBox getCbbSubjectSemester() {
    return cbbSubjectSemester;
  }

  public JComboBox getCbbSubjectTeacher() {
    return cbbSubjectTeacher;
  }

  public JTextField getTxtSubjectCredits() {
    return txtSubjectCredits;
  }

  public JTextField getTxtSubjectName() {
    return txtSubjectName;
  }

  public JButton getBtnAddSubject() {
    return btnAddSubject;
  }

  private void createUIComponents() {
    // TODO: place custom component creation code here
  }
}
