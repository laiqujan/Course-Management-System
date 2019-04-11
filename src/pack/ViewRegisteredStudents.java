package pack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

public class ViewRegisteredStudents extends JPanel {
	private DataBaseManegar dbm;
	private static int i = 0;
	private String[] std;
	private String[] cd;
	private static String id;
	private static String code;
	 private JFrame j;
	 private JTable table_3;

	/**
	 * Create the panel.
	 */
	public ViewRegisteredStudents(final DataBaseManegar dbm,JFrame jf) {
		this.j=jf;
		this.dbm = dbm;
	
		setLayout(null);

		JLabel lblRegisterCourse = new JLabel("Register Students");
		lblRegisterCourse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegisterCourse.setBounds(136, 0, 185, 25);
		add(lblRegisterCourse);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 85, 449, 257);
		add(scrollPane);
		
		table_3 = new JTable();
		scrollPane.setViewportView(table_3);
		JButton btnSeeAvailabelCourses = new JButton("See Registerd Students");
		btnSeeAvailabelCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	     	try {
				ResultSet rs= dbm.getRegisteredCourseInfo();
				table_3.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "No Students yet Registered");
			}
			}
			
		});
		btnSeeAvailabelCourses.setBounds(12, 38, 454, 26);
		add(btnSeeAvailabelCourses);
		
		
	
	}
}
