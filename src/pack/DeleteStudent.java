package pack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;

public class DeleteStudent extends JPanel {
  private DataBaseManegar dbm;
  private JTextField idTf;
  private JTextField nameTf;
  private JTextField cgpaTf;
  private JFrame j;
	/**
	 * Create the panel.
	 */
	public DeleteStudent(final DataBaseManegar dbm,JFrame jf) {
		this.j=jf;
     this.dbm=dbm;
     setLayout(null);
     
     JLabel lblId = new JLabel("Id:");
     lblId.setBounds(20, 75, 46, 14);
     add(lblId);
     
     idTf = new JTextField();
     idTf.setBounds(80, 66, 250, 33);
     add(idTf);
     idTf.setColumns(10);
     
     JLabel lblName = new JLabel("Name:");
     lblName.setBounds(20, 120, 46, 14);
     add(lblName);
     
     nameTf = new JTextField();
     nameTf.setBounds(80, 111, 250, 33);
     add(nameTf);
     nameTf.setColumns(10);
     
     JLabel lblCgpa = new JLabel("CGPA");
     lblCgpa.setBounds(20, 165, 46, 14);
     add(lblCgpa);
     
     cgpaTf = new JTextField();
     cgpaTf.setBounds(80, 156, 250, 33);
     add(cgpaTf);
     cgpaTf.setColumns(10);
     
     JButton btnDelete = new JButton("Delete");
     btnDelete.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     	   String id=idTf.getText();
     		try {
     			ResultSet rs = dbm.getStudent(id);
				boolean isRecord = rs.next();
				if (isRecord) {
     			
				dbm.deleteStudent(id);
				JOptionPane.showMessageDialog(null, "Record Deleted");
				}else{
				JOptionPane.showMessageDialog(null, "Record is Not Present");	
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Plz Input Correct Arguments");
				//e1.printStackTrace();
				
			}
     	}
     });
     btnDelete.setBounds(80, 208, 114, 36);
     add(btnDelete);
     
     JLabel lblStudent = new JLabel("Student");
     lblStudent.setFont(new Font("Dialog", Font.BOLD, 22));
     lblStudent.setBounds(110, 12, 88, 29);
     add(lblStudent);
     
     JButton button = new JButton("Search");
     button.setBounds(215, 208, 114, 36);
     add(button);
	}
}
