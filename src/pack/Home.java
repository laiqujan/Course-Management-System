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
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private DataBaseManegar dbm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		try {
			dbm = new DataBaseManegar("127.0.0.1", 1433, "StudentCourseReg_154");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		setTitle("CourseRegistration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 425);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnStudents = new JMenu("Students");
		mnStudents.setForeground(new Color(0, 0, 255));
		mnStudents.setBackground(new Color(205, 92, 92));
		mnStudents.setFont(new Font("Dialog", Font.BOLD, 18));
		menuBar.add(mnStudents);
		
		JMenuItem mntmAddStudent = new JMenuItem("Add Student");
		mntmAddStudent.setForeground(new Color(165, 42, 42));
		mntmAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Student");
			        AddStudent d = new AddStudent(dbm,jf);
			        jf.getContentPane().add(d);
			        jf.setVisible(true);
				
			}
		});
		mnStudents.add(mntmAddStudent);
		
		JMenuItem mntmUpdateStudent = new JMenuItem("Update Student");
		mntmUpdateStudent.setForeground(new Color(165, 42, 42));
		mntmUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Student");
			        UpdateStudent d = new UpdateStudent(dbm,jf);
			        jf.getContentPane().add(d);
			        jf.setVisible(true);
			}
		});
		mnStudents.add(mntmUpdateStudent);
		
		JMenuItem mntmSearchStudent = new JMenuItem("Search Student");
		mntmSearchStudent.setForeground(new Color(165, 42, 42));
		mntmSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Student");
			        SearchStudent d = new SearchStudent(dbm,jf);
			        jf.getContentPane().add(d);
			        jf.setVisible(true);
			}
		});
		mnStudents.add(mntmSearchStudent);
		
		JMenuItem mntmDeleteStudent = new JMenuItem("Delete Student");
		mntmDeleteStudent.setForeground(new Color(165, 42, 42));
		mntmDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Student");
			        DeleteStudent d = new DeleteStudent(dbm,jf);
			        jf.getContentPane().add(d);
			        jf.setVisible(true);
			}
		});
		mnStudents.add(mntmDeleteStudent);
		
		JMenu mnCourses = new JMenu("Courses");
		mnCourses.setForeground(new Color(0, 0, 255));
		mnCourses.setFont(new Font("Dialog", Font.BOLD, 18));
		menuBar.add(mnCourses);
		
		JMenuItem mntmAddCourse = new JMenuItem("Add Course");
		mntmAddCourse.setForeground(new Color(165, 42, 42));
		mntmAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        AddCourse c = new AddCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
				
			}
		});
		mnCourses.add(mntmAddCourse);
		
		JMenuItem mntmUpdateCourse = new JMenuItem("Update Course");
		mntmUpdateCourse.setForeground(new Color(165, 42, 42));
		mntmUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        UpdateCourse c = new UpdateCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);	
			}
		});
		mnCourses.add(mntmUpdateCourse);
		
		JMenuItem mntmSearchCourse = new JMenuItem("Search Course");
		mntmSearchCourse.setForeground(new Color(165, 42, 42));
		mntmSearchCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        SearchCourse c = new SearchCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
			}
		});
		mnCourses.add(mntmSearchCourse);
		
		JMenuItem mntmDeleteCourse = new JMenuItem("Delete Course");
		mntmDeleteCourse.setForeground(new Color(165, 42, 42));
		mntmDeleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        DeleteCourse c = new DeleteCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
			}
		});
		mnCourses.add(mntmDeleteCourse);
		
		JMenu mnAdmission = new JMenu("Admission");
		mnAdmission.setFont(new Font("Dialog", Font.BOLD, 18));
		mnAdmission.setForeground(new Color(0, 0, 255));
		menuBar.add(mnAdmission);
		
		JMenuItem mntmRegisteration = new JMenuItem("Course Registeration");
		mntmRegisteration.setForeground(new Color(165, 42, 42));
		mntmRegisteration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        RegisterCourse c = new RegisterCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
			}
		});
		mnAdmission.add(mntmRegisteration);
		
		JMenuItem mntmRequestForDrop = new JMenuItem("Request For Drop Course");
		mntmRequestForDrop.setForeground(new Color(165, 42, 42));
		mntmRequestForDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        DropRegisterdCourse c = new DropRegisterdCourse(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
				
			}
		});
		mnAdmission.add(mntmRequestForDrop);
		
		JMenuItem mntmViewRegisterStudent = new JMenuItem("View Registered Student");
		mntmViewRegisterStudent.setForeground(new Color(165, 42, 42));
		mntmViewRegisterStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Course");
			        ViewRegisteredStudents c = new ViewRegisteredStudents(dbm,jf);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
				
			}
		});
		mnAdmission.add(mntmViewRegisterStudent);
		
		JMenu mnAdminstration = new JMenu("Adminstration");
		mnAdminstration.setForeground(new Color(0, 0, 255));
		mnAdminstration.setFont(new Font("Dialog", Font.BOLD, 18));
		menuBar.add(mnAdminstration);
		
		JMenuItem mntmTotalStudents = new JMenuItem("Total Students");
		mntmTotalStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Students");
			        ViewAllStudents c = new ViewAllStudents(dbm);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);
				
			}
		});
		mntmTotalStudents.setForeground(new Color(165, 42, 42));
		mnAdminstration.add(mntmTotalStudents);
		
		JMenuItem mntmTotalCourses = new JMenuItem("Total Courses");
		mntmTotalCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFrame jf = new JFrame();
			        jf.setSize(1440, 720);
			        jf.setTitle("Students");
			        ViewAllCourse c = new ViewAllCourse(dbm);
			        jf.getContentPane().add(c);
			        jf.setVisible(true);	
			}
		});
		mntmTotalCourses.setForeground(new Color(165, 42, 42));
		mnAdminstration.add(mntmTotalCourses);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Downloads\\Pictures\\1301727934321_1301727934321_r.jpg"));
		lblNewLabel.setBounds(0, 0, 445, 370);
		contentPane.add(lblNewLabel);
	}
}
