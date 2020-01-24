package DAO;

import java.sql.*;
import java.util.ArrayList;

import DB.*;
import BEAN.*;

public class ListCar {
	public static ArrayList<Car> getList() {
		ArrayList<Car> list = new ArrayList<>();
		String sql = "select * from car";
		try {
			PreparedStatement statement = Connect.executeSQL(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Car car = new Car();
				car.setID(result.getInt("ID"));
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
