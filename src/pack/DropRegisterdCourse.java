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

public class DropRegisterdCourse extends JPanel {
	private DataBaseManegar dbm;
	private static int i = 0;
	private String[] std;
	private String[] cd;
	private static String id;
	private static String code;
	private JFrame j;

	/**
	 * Create the panel.
	 */
	public DropRegisterdCourse(final DataBaseManegar dbm, JFrame jf) {
		this.j = jf;
		this.dbm = dbm;
		try {
			std = dbm.getStudentID();
			cd = dbm.getCourseCode();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		final JComboBox studentID = new JComboBox();
		// studentCb.setModel(new DefaultComboBoxModel(new String[] {
		// "Select Student ID" }));
		studentID.setModel(new DefaultComboBoxModel(std));
		studentID.setBounds(12, 37, 198, 25);
		add(studentID);

		final JComboBox courseID = new JComboBox();
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {
		// "Select Course " }));
		courseID.setModel(new DefaultComboBoxModel(cd));
		courseID.setBounds(259, 37, 207, 25);
		add(courseID);

		JButton btnRegistercourse = new JButton("DropCourse");
		btnRegistercourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				id = studentID.getSelectedItem().toString();
				code = courseID.getSelectedItem().toString();
				try {

					i = dbm.getregisterdCredit(id);
					if (i >= 15) {
						dbm.dropcourse(id, code);
						dbm.droptempRegistration(id, code);

						JOptionPane.showMessageDialog(null, "Course Droped");

					}

					else {

						JOptionPane.showMessageDialog(null,
								"Course can not be dropped");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"Plz Select correct Cousre id and student Id");
					// e.printStackTrace();

				}

			}
		});
		btnRegistercourse.setBounds(259, 98, 207, 29);
		add(btnRegistercourse);

		JLabel lblRegisterCourse = new JLabel("Register Course");
		lblRegisterCourse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegisterCourse.setBounds(136, 0, 150, 25);
		add(lblRegisterCourse);

		JLabel lblSelectstudentidAndCourse = new JLabel(
				"SelectStudentId And Course");
		lblSelectstudentidAndCourse.setBounds(12, 104, 198, 16);
		add(lblSelectstudentidAndCourse);

	}
}
