package com.seleya.dao;

import java.sql.SQLException;
import java.util.List;

import com.seleya.beans.Car;

public interface CarDAO {
	
	public void insertCar(int carID, String carMake, String carModel, String carYear, String carColor, int carPrice,
			String owned) throws SQLException;
	
	public List<Car> getCarList() throws SQLException;
}
