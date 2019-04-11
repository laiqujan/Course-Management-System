package pack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteCourse extends JPanel {
  private DataBaseManegar dbm;
  private JTextField coursenameTf;
  private JTextField creditHours;
  private JFrame j;
	/**
	 * Create the panel.
	 */
	public DeleteCourse(final DataBaseManegar dbm,JFrame jf) {
	 this.j=jf;
     this.dbm=dbm;
     setLayout(null);
     
     JLabel lblCoursecode = new JLabel("CourseID");
     lblCoursecode.setBounds(12, 73, 82, 16);
     add(lblCoursecode);
     
     final JTextField courseTf = new JTextField();
     courseTf.setBounds(132, 59, 250, 45);
     add(courseTf);
     courseTf.setColumns(10);
     
     coursenameTf = new JTextField();
     coursenameTf.setBounds(132, 116, 250, 45);
     add(coursenameTf);
     coursenameTf.setColumns(10);
     
     JLabel lblName = new JLabel("CourseName");
     lblName.setBounds(12, 130, 82, 16);
     add(lblName);
     
     JLabel lblCredithours = new JLabel("CreditHours");
     lblCredithours.setBounds(12, 197, 68, 16);
     add(lblCredithours);
     
     creditHours = new JTextField();
     creditHours.setBounds(132, 173, 250, 45);
     add(creditHours);
     creditHours.setColumns(10);
     
     JButton btnSearch = new JButton("Search");
     btnSearch.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
        String cid=courseTf.getText();
  		try {
     			ResultSet rs = dbm.getCourse(cid);
				boolean isRecord = rs.next();
				if (isRecord) {
					coursenameTf.setText(rs.getString("cName"));
					creditHours.setText(rs.getString("creditHours"));
					
				}else{
				JOptionPane.showMessageDialog(null, "Record is Not Present");	
				}
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Plz Input Correct Arguments");
			//	e1.printStackTrace();
				
			}
     		
     	}
     });
     btnSearch.setBounds(133, 228, 120, 38);
     add(btnSearch);
     
     JButton btnDelete = new JButton("Delete");
     btnDelete.addActionListener(new ActionListener() {
     	public void actionPerformed(ActionEvent e) {
            String cid=courseTf.getText();
      		try {
         			ResultSet rs = dbm.getCourse(cid);
    				boolean isRecord = rs.next();
    				if (isRecord) {
    				dbm.deleteCourse(cid);
    				JOptionPane.showMessageDialog(null, "Record deleted");	
    				}else{
    				JOptionPane.showMessageDialog(null, "Record is Not Present");	
    				}
    				
    			} catch (SQLException e1) {
    				JOptionPane.showMessageDialog(null, "Plz Input Correct Arguments");
    				//e1.printStackTrace();
    				
    			}
     		
     	}
     });
     btnDelete.setBounds(268, 227, 113, 38);
     add(btnDelete);
     
     JLabel lblCourse = new JLabel("Course");
     lblCourse.setFont(new Font("Dialog", Font.BOLD, 24));
     lblCourse.setBounds(132, 11, 106, 36);
     add(lblCourse);
	}
}
