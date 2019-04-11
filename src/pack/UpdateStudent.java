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

public class UpdateStudent extends JPanel {
  private DataBaseManegar dbm;
  private JTextField idTf;
  private JTextField nameTf;
  private JTextField cgpaTf;
  private JFrame j;
	/**
	 * Create the panel.
	 */
	public UpdateStudent(final DataBaseManegar dbm,JFrame jf) {
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
     btnUpdate.setBounds(80, 200, 109, 35);
     add(btnUpdate);
     
     JLabel lblStudent = new JLabel("Student");
     lblStudent.setFont(new Font("Dialog", Font.BOLD, 22));
     lblStudent.setBounds(110, 12, 88, 29);
     add(lblStudent);
     
     JButton button = new JButton("Search");
     button.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent arg0) {
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
     button.setBounds(218, 199, 109, 36);
     add(button);
	}
}
