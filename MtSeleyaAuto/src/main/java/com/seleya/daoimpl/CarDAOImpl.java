package com.seleya.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seleya.beans.Car;
import com.seleya.dao.CarDAO;
import com.seleya.util.ConnFactory;

public class CarDAOImpl implements CarDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertCar(int carID, String carMake, String carModel, String carYear, String carColor, int carPrice,
			String owned) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CAR VALUES("+carID+",'"+carMake+"','"+carModel+"','"+carYear+"','"+carColor+"',"+carPrice+",'"+owned+"')";
		stmt.executeUpdate(sql);
	}

	@Override
	public List<Car> getCarList() throws SQLException {
		List<Car> carList = new ArrayList<Car>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CAR");
		Car r = null;
		while(rs.next()) {
			r = new Car(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			carList.add(r);
		}
		return carList;
	}

}
