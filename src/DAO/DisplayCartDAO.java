package DAO;

import java.sql.*;
import java.util.ArrayList;

import DB.*;
import BEAN.*;

public class DisplayCartDAO {
	public static ArrayList<Car> displayCart(String name) {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "select list.carID, car.Name from list, car where list.carID = car.ID and list.account = ?";
		PreparedStatement statement = null;
		ResultSet result = null;
		
		try {
			statement = Connect.executeSQL(sql);
			statement.setString(1, name);
			result = statement.executeQuery();
			while(result.next()) {
				Car car = new Car();
				car.setID(result.getInt("carID"));
				car.setNameCar(result.getString("Name"));
				list.add(car);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
