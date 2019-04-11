package pack;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllStudents extends JPanel {
  DataBaseManegar dbm;
	private JTable table;
	private JTable table_1;
	 
	/**
	 * Create the panel.
	 */
	public ViewAllStudents(final DataBaseManegar dbm) {
		this.dbm=dbm;
		setLayout(null);
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 79, 453, 328);
		add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		JButton btnNewButton = new JButton("ViewAllStudents");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ResultSet   rs = dbm.getAllStudents();
					
					table_1.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Record Not Present");
				}
			  
			}
		});
		btnNewButton.setBounds(12, 26, 454, 26);
		add(btnNewButton);

	}
}
