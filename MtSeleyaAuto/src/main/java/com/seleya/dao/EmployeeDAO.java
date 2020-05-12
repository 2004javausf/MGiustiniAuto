package com.seleya.dao;

import java.sql.SQLException;
import java.util.List;

import com.seleya.beans.Employee;

public interface EmployeeDAO {
	
	public void insertEmployee(int empID, String empFName, String empLName, String empUsername, String empPassword) throws SQLException;
	
	public List<Employee> getEmployeeList() throws SQLException;
}
