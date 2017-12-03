package loginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;

public class LoginModel {
	Connection connection;
	
	public LoginModel() {
		try {
			this.connection = dbConnection.getConnection();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		if(this.connection == null) {
			System.exit(1);
		}
	}
	
	public boolean isDatabaseConnected() {
		return this.connection != null;
	}
	
	public boolean isLogin(String user, String password, String option) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from login where username = ? and password = ? and division = ?";
		try {
			ps = this.connection.prepareStatement(sql);
			ps.setString(1,  user);
			ps.setString(2, password);
			ps.setString(3, option);
			rs = ps.executeQuery();
			
			if(rs.next())
				return true;
			else
				return false;
		}catch (SQLException ex) {
			return false;
		}finally {
			ps.close();
			rs.close();
		}
		//could have used try-with-resources here
	}
}
