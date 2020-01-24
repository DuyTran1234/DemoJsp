package DB;

import java.sql.*;
public class Connect {
	public static Connection ConnectDB() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "tranvietduy0504";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static PreparedStatement executeSQL(String sql) {
		PreparedStatement statement = null;
		try {
			statement = ConnectDB().prepareStatement(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return statement;
	}
}
