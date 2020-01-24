package DAO;

import java.sql.*;
import java.util.ArrayList;

import DB.*;
import BEAN.*;

public class AddCartDAO {
	public static String addCart(String name, String ID) {
		String sql = "insert into list values(?,?)";
		int id = Integer.parseInt(ID);
		try {
			PreparedStatement statement = Connect.executeSQL(sql);
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.executeUpdate();
			return "Add Car into Cart success";
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return "Fail";
	}
}
