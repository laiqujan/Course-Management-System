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

public class Student extends JPanel {
  private DataBaseManegar dbm;
  private JTextField idTf;
  private JTextField nameTf;
  private JTextField cgpaTf;
  private JFrame j;
	/**
	 * Create the panel.
	 */
	public Student(final DataBaseManegar dbm,JFrame jf) {
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
     		
				dbm.addStudent(id, name, cgpa);
				JOptionPane.showMessageDialog(null, "Record added");
			} catch(SQLException e1) {
				 JOptionPane.showMessageDialog(null, "Violation of priamry key/Wrong Input");
				//e1.printStackTrace();
			}
              catch(NumberFormatException b){
        	 JOptionPane.showMessageDialog(null, "Violation of priamry key/Wrong Input");	
     		}
     	
     	}
     });
     btnAdd.setBounds(10, 262, 70, 29);
     add(btnAdd);
     
     JButton btnUpdate = new JButton("Update");
     btnUpdate.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		String id;
			String name;
			float cgpa;
     		id=idTf.getText();
     		name=nameTf.getText();
     		cgpa=Float.parseFloat(cgpaTf.getText());
    	
     		try {
     			ResultSet rs = dbm.getStudent(id);
				boolean isRecord = rs.next();
				if (isRecord) {
				dbm.updateStudent(id, name, cgpa);
				JOptionPane.showMessageDialog(null, "Record Updated");
				}else{
				JOptionPane.showMessageDialog(null, "Record is Not Present");	
				}
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Plz Input Correct Arguments");
				//e1.printStackTrace();
				
			}
     	}
     });
     btnUpdate.setBounds(91, 262, 74, 29);
     add(btnUpdate);
     
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
     btnDelete.setBounds(260, 262, 70, 29);
     add(btnDelete);
     
     JButton btnSearch = new JButton("Search");
     btnSearch.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
     		
    		try {
    		    String id=idTf.getText();
				ResultSet rs = dbm.getStudent(id);
				boolean isRecord = rs.next();
				if (isRecord) {
					nameTf.setText(rs.getString("name"));
					cgpaTf.setText(rs.getString("CGPA"));
					
				} else {
					JOptionPane.showMessageDialog(null,
							"Record not found");
				}
			} catch (Exception e1) {
				//e1.printStackTrace();
			
     	}
     	}
     });
     btnSearch.setBounds(175, 262, 75, 29);
     add(btnSearch);
     
     JLabel lblStudent = new JLabel("Student");
     lblStudent.setFont(new Font("Dialog", Font.BOLD, 22));
     lblStudent.setBounds(110, 12, 88, 29);
     add(lblStudent);
	}
}
