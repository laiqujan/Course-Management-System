package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DataBaseManegar{
	private Connection con;
	private java.sql.Statement stmt;
	private String connUrl;
	private String query;
    public DataBaseManegar(String serverName, int portNumber,
			String databasename) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
		connUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";"
				+ "DatabaseName=" +databasename + ";"
				+ "username=sa;password=laiqujan";
		con = DriverManager.getConnection(connUrl);
	    
	}
	public void closeConnection() throws SQLException {
		con.close();
		}
	public void addStudentViaProcerdure(String id, String name, float cgpa)
			throws SQLException,NumberFormatException {
		stmt = null;
		stmt = con.createStatement();
	    String r="exec InsertStudentrecord '" +id + "','" + name+ "',  '"+cgpa+"'";

        stmt.execute(r);
	}

	public Connection getCon() throws SQLException {
		return con;
	}

	public boolean addStudent(String id, String name, float cgpa)
			throws SQLException,NumberFormatException {
		stmt = null;
		stmt = con.createStatement();
	    boolean r=	stmt.execute("insert into Student(stId,name,CGPA)VALUES" + "('"
				+ id + "','" + name + "','" + cgpa + "')");
        return r;
	}

	public boolean addCourse(String cId, String cName, int cCreditHours)
			throws SQLException,NumberFormatException {
		stmt = null;
		stmt = con.createStatement();
		boolean r=stmt.execute("insert into Course (courseId,cName,creditHours)VALUES"
				+ "('" + cId + "','" + cName + "','" + cCreditHours + "')");
		return r;
	}

	public boolean registerStudent(String stId, String ccode) throws SQLException {
		stmt = null;
		stmt = con.createStatement();
		boolean r=stmt.execute("insert into RegisterCourse(stId,courseId)VALUES"
				+ "('" + stId + "','" + ccode + "')");
		return r;

	}
	public boolean  RegistrationTemp(String stId, String ccode) throws SQLException {
		stmt = null;
		stmt = con.createStatement();
		boolean r=stmt.execute("insert into  RegistrationTemp(id,cid)VALUES"
				+ "('" + stId + "','" + ccode + "')");
		return r;

	}

   public ResultSet getStudent(String id) throws SQLException {
		stmt = null;
		query = "select * from Student where stId='" + id + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

    }

	public ResultSet getCourse(String cid) throws SQLException {
		stmt = null;
		query = "select * from Course where courseId='" + cid + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	public ResultSet getAllStudents() throws SQLException {
		stmt = null;
		query = "select * from Student";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getAllCourses() throws SQLException {
		stmt = null;
		query = "select * from Course ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	public ResultSet getRegisteredCourseInfo() throws SQLException {
		stmt = null;
		query="Select *from RegisterCourse";
	    stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}
	public void VerifyRegistartion(String sid) throws SQLException {
		stmt = null;
		query = "select * from RegistrationTemp where RegistrationTemp.id='" + sid + "' ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
	    String stdId,cId;
	    boolean isRecord;
					do{
						isRecord = rs.next();
					if (isRecord) {
						stdId=rs.getString("id");
						cId=rs.getString("cid");
						stmt = con.createStatement();
						stmt.execute("insert into RegisterCourse(stId,courseId)VALUES"
								+ "('" + stdId + "','" + cId + "')");
					
						}
					}while(isRecord);
	}
	
	public void deleteStudent(String id) throws SQLException {
		stmt = null;
		query = "Delete  from Student where stId='" + id + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);
	}

	public void deleteCourse(String cid) throws SQLException {
		stmt = null;
		query = "Delete  from Course where courseId='" + cid + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);
	}
	public boolean dropcourse(String id,String cid) throws SQLException {
		stmt = null;
		query = "Delete from RegisterCourse where courseId='" + cid + "' and stId='"+id+"'";
		stmt = con.createStatement();
		boolean i=stmt.execute(query);
		return i;
	}
	public boolean droptempRegistration(String id,String cid) throws SQLException {
		stmt = null;
		query = "Delete from RegisterCourse where courseId='" + cid + "' and stId='"+id+"'";
		stmt = con.createStatement();
		boolean i=stmt.execute(query);
		return i;
	}

	public void updateStudent(String id, String name, float cgpa)
			throws SQLException {
		stmt = null;
		query = "Update  Student set name='" + name + "' where stId='" + id
				+ "'";
		query += "Update  Student set CGPA='" + cgpa + "' where stId='" + id
				+ "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}

	public void updateCourse(String cid, String cname, int cHrs)
			throws SQLException {
		stmt = null;
		query = "Update Course set cName='" + cname + "' where courseId='"
				+ cid + "'";
		query += "Update  Course set creditHours ='" + cHrs
				+ "' where courseId='" + cid + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}
	public int getTotatCredit(String sid)throws SQLException{
		int i=0;
		query="select SUM(creditHours) as MYSUM from Course,RegistrationTemp " 
       +"WHERE RegistrationTemp.cid=Course.courseId"
       +" and RegistrationTemp.id='"+sid+"'";
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		boolean isRecord = rs.next();
		if (isRecord) {
		 i=(rs.getInt("MYSUM"));
			}
	
		return i;

		
	}
	public int getregisterdCredit(String sid)throws SQLException{
		int i=0;
		query="select SUM(creditHours) as MYSUM from Course,RegistrationTemp " 
       +"WHERE RegistrationTemp.cid=Course.courseId"
       +" and RegistrationTemp.id='"+sid+"'";
		stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		boolean isRecord = rs.next();
		if (isRecord) {
		 i=(rs.getInt("MYSUM"));
			}
	
		return i;

		
	}

	
	
	public String[] getStudentID() throws SQLException {
		int i = 1;
		stmt = null;
		Statement s = null;
		String query1 = "select stId from Student";
		String query2 = "select COUNT(*) As TotalStudent from Student";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		s = con.createStatement();
		s.execute(query2);
		int length = s.getFetchSize();
		String[] std = new String[length];
		std[0] = "Select Student ID";
		boolean isRecord;
		do {
			isRecord = rs.next();
			if (isRecord && i < length) {
				std[i] = rs.getString("stId");
				i++;
			}
		} while (isRecord);
		return std;
	}


	
	public String[] getCourseCode() throws SQLException {
		int i = 1;
		stmt = null;
		Statement s = null;
		String query1 = "select courseId from Course";
		String query2 = "select COUNT(*) As TotalCourse from Course";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		s = con.createStatement();
		s.execute(query2);
		int length = s.getFetchSize();
		String[] std = new String[length];
		std[0] = "Select Course--";
		boolean isRecord;
		do {
			isRecord = rs.next();
			if (isRecord && i < length) {
				std[i] = rs.getString("courseId");
				i++;
			}
		} while (isRecord);
		return std;
	}
}
