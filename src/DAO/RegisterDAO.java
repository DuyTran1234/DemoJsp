package DAO;

import BEAN.*;
import DB.*;
import java.sql.*;

public class RegisterDAO {
	public static String registerAccount(User user, String confirmPassword) {
		if(!user.getPassword().equals(confirmPassword)) {
			return "Check confirm password and password";
		}
		String sql = "select * from test.user where account = ?";
		PreparedStatement statement = Connect.executeSQL(sql);
		ResultSet result = null;
		try {
			statement.setString(1, user.getAccount());
			result = statement.executeQuery();
			
			if(!result.next()) {
				String query = "insert into test.user (account, password) values(?,?)";
				PreparedStatement statementInsert = Connect.executeSQL(query);
				statementInsert.setString(1, user.getAccount());
				statementInsert.setString(2, user.getPassword());
				statementInsert.executeUpdate();
				return "true";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Register fail, user existsed";
	}
}





