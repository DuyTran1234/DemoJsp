package DAO;

import java.sql.*;
import BEAN.*;
import DB.*;

public class LoginDAO {
	public static boolean loginAccount(User user) {
		String sql = "select * from test.user where account = ? and password = ?";
		try {
			PreparedStatement statement = Connect.executeSQL(sql);
			statement.setString(1, user.getAccount());
			statement.setString(2, user.getPassword());
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
