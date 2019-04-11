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
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class AddStudent extends JPanel {
  private DataBaseManegar dbm;
  private JTextField idTf;
  private JTextField nameTf;
  private JTextField cgpaTf;
  private JFrame j;
	/**
	 * Create the panel.
	 */
	public AddStudent(final DataBaseManegar dbm,JFrame jf) {
		this.j=jf;
     this.dbm=dbm;
     setLayout(null);
     
     JLabel lblId = new JLabel("Id:");
     lblId.setBounds(12, 75, 54, 14);
     add(lblId);
     
     idTf = new JTextField();
     idTf.setBounds(80, 66, 250, 33);
     add(idTf);
     idTf.setColumns(10);
     
     JLabel lblName = new JLabel("Name:");
     lblName.setBounds(12, 120, 54, 14);
     add(lblName);
     
     nameTf = new JTextField();
     nameTf.setBounds(80, 111, 250, 33);
     add(nameTf);
     nameTf.setColumns(10);
     
     JLabel lblCgpa = new JLabel("CGPA");
     lblCgpa.setBounds(12, 165, 54, 14);
     add(lblCgpa);
     
     cgpaTf = new JTextField();
     cgpaTf.setBounds(80, 156, 250, 33);
     add(cgpaTf);
     cgpaTf.setColumns(10);
     
     JButton btnAdd = new JButton("Add");
     btnAdd.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		String id;
			String name;
			float cgpa = 0;

		try {
     			cgpa=Float.parseFloat(cgpaTf.getText());
     			id=idTf.getText();
         		name=nameTf.getText();
     		
				dbm.addStudentViaProcerdure(id, name, cgpa);
				JOptionPane.showMessageDialog(null, "Record added");
			} catch(SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Violation of priamry key/Wrong Input");
				e1.printStackTrace();
			}
              catch(NumberFormatException b){
        	 JOptionPane.showMessageDialog(null, "Violation of priamry key/Wrong Input");	
     		}
     	
     	}
     });
     btnAdd.setBounds(81, 203, 250, 36);
     add(btnAdd);
     
     JLabel lblStudent = new JLabel("Student");
     lblStudent.setFont(new Font("Dialog", Font.BOLD, 22));
     lblStudent.setBounds(110, 12, 88, 29);
     add(lblStudent);
     
     JLabel label = new JLabel("");
     label.setIcon(new ImageIcon(AddStudent.class.getResource("/pack/Un.jpg")));
     label.setBounds(56, 43, 409, 362);
     add(label);
	}
}
