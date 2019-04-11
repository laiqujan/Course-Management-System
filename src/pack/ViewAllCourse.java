package pack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllCourse extends JPanel {
	DataBaseManegar dbm;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ViewAllCourse(final DataBaseManegar dbm) {
		this.dbm=dbm;
		setLayout(null);
		
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 85, 444, 316);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JButton btnViewallcoures = new JButton("ViewAllCoures");
		btnViewallcoures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ResultSet   rs = dbm.getAllCourses();
					table.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Record Not Present");
				}
				
			}
		});
		btnViewallcoures.setBounds(12, 24, 451, 26);
		add(btnViewallcoures);
		

	}
}
