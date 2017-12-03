package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	//for MYSQL (not needed but just for show)
	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String CONN = "jdbc:mysql://localhost/login";
	//for SQLite we do not need the above
	private static final String SQCONN = "jdbc:sqlite:schoolsystem.sqlite";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQCONN);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
}
