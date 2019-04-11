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

public class RegisterCourse extends JPanel {
	private DataBaseManegar dbm;
	private static int i = 0;
	private String[] std;
	private String[] cd;
	private static String id;
	private static String code;
	private JFrame j;
	private JTextField choursTf;

	/**
	 * Create the panel.
	 */
	public RegisterCourse(final DataBaseManegar dbm, JFrame jf) {
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

		JButton btnRegistercourse = new JButton("Select");
		btnRegistercourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				id = studentID.getSelectedItem().toString();
				code = courseID.getSelectedItem().toString();
				try {

					if (i < 24) {
						dbm.RegistrationTemp(id, code);
						i = dbm.getTotatCredit(id);

						JOptionPane.showMessageDialog(null,
								"Course Selected For Registration");
					} else if (i >= 24) {
						i = dbm.getTotatCredit(id);
						
						JOptionPane
								.showMessageDialog(null,
										"Selection of Courses Completed You Can not Take more Credit Hours verify them");
					} else {
						i = dbm.getTotatCredit(id);

						JOptionPane.showMessageDialog(null,
								"Selection of Courses completed Verify them");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,
							"You Can not Take Same course Two Times");
					// e.printStackTrace();

				}

			}
		});
		btnRegistercourse.setBounds(335, 104, 144, 29);
		add(btnRegistercourse);

		JLabel lblRegisterCourse = new JLabel("Register Course");
		lblRegisterCourse.setFont(new Font("Dialog", Font.BOLD, 18));
		lblRegisterCourse.setBounds(136, 0, 150, 25);
		add(lblRegisterCourse);

		JButton btnSubmitt = new JButton("Verify");
		btnSubmitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i < 12) {

					JOptionPane
							.showMessageDialog(
									null,
									""
											+ "You can take Minimum 12 Credit Hours Plz Register courses Correctly");
					try {
						dbm.droptempRegistration(id, code);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

				} else if (i > 24) {
					JOptionPane
							.showMessageDialog(
									null,
									""
											+ "You can take Maximum 24 Credit Hours Plz Register courses Correctly");

					try {
						dbm.droptempRegistration(id, code);
						// i = dbm.getTotatCredit(id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

				} else {
					try {
						dbm.VerifyRegistartion(id);
						JOptionPane.showMessageDialog(null,
								"Registration Completed");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
								"Registration Time Completed");
						// e.printStackTrace();
					}

				}
			}
		});
		btnSubmitt.setBounds(335, 146, 144, 29);
		add(btnSubmitt);

		JLabel lblSelectCoursesWhich = new JLabel(
				"Note:Select Courses which you want to Take ");
		lblSelectCoursesWhich.setBounds(12, 79, 342, 31);
		add(lblSelectCoursesWhich);

		JLabel lblMinimumCredit = new JLabel(
				"Minimum 12 Credit Hours and Maximum 24 Credit Hours");
		lblMinimumCredit.setBounds(12, 111, 342, 16);
		add(lblMinimumCredit);

		JLabel lblSubmittTheSelected = new JLabel(
				"Verify the Selected Courses For Registration");
		lblSubmittTheSelected.setBounds(10, 150, 289, 16);
		add(lblSubmittTheSelected);

		JButton btnChekcredithours = new JButton("ChekCreditHours");
		btnChekcredithours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					id = studentID.getSelectedItem().toString();
					code = courseID.getSelectedItem().toString();
					i = dbm.getTotatCredit(id);
					String st = "" + i;
					choursTf.setText(st);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnChekcredithours.setBounds(335, 199, 144, 26);
		add(btnChekcredithours);

		choursTf = new JTextField();
		choursTf.setBounds(12, 199, 287, 26);
		add(choursTf);
		choursTf.setColumns(10);

	}
}
