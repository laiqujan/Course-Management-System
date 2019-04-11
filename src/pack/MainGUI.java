package pack;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Font;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private DataBaseManegar dbm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		try {
			dbm = new DataBaseManegar("127.0.0.1", 1433, "StudentCourseReg_154");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		setTitle("CourseRegistration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddstudent = new JButton("Student");
		btnAddstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        JFrame jf = new JFrame();
		        jf.setSize(1440, 720);
		        jf.setTitle("Student");
		        Student d = new Student(dbm,jf);
		        jf.getContentPane().add(d);
		        jf.setVisible(true);
				
			}
		});
		btnAddstudent.setBounds(204, 108, 133, 38);
		contentPane.add(btnAddstudent);
		
		JButton btnNewButton = new JButton("Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				    JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        Course c = new Course(dbm);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
					
			}
		});
		btnNewButton.setBounds(204, 158, 133, 35);
		contentPane.add(btnNewButton);
		
		JButton btnRegisterstudent = new JButton("RegisterStudent");
		btnRegisterstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("CourseRegistration");
			        RegisterCourse rc = new RegisterCourse(dbm,jf);
			        jf.getContentPane().add(rc);
			        jf.setVisible(true);
				
			}
			
		});
		btnRegisterstudent.setBounds(204, 205, 133, 38);
		contentPane.add(btnRegisterstudent);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(204, 255, 133, 38);
		contentPane.add(btnExit);
		
		JLabel lblStudentcourseregistration = new JLabel("StudentCourseRegistration");
		lblStudentcourseregistration.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblStudentcourseregistration.setBounds(108, 12, 200, 36);
		contentPane.add(lblStudentcourseregistration);
		
		JLabel lblCrudStudent = new JLabel("CRUD Student");
		lblCrudStudent.setBounds(45, 119, 109, 16);
		contentPane.add(lblCrudStudent);
		
		JLabel lblCrudCourse = new JLabel("CRUD Course");
		lblCrudCourse.setBounds(45, 167, 97, 16);
		contentPane.add(lblCrudCourse);
		
		JLabel lblCrudRegister = new JLabel("CRUD Register");
		lblCrudRegister.setBounds(45, 216, 97, 16);
		contentPane.add(lblCrudRegister);
	}
}
