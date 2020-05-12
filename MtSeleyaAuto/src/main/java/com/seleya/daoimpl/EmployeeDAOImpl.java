package com.seleya.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seleya.beans.Employee;
import com.seleya.dao.EmployeeDAO;
import com.seleya.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertEmployee(int empID, String empFName, String empLName, String empUsername, String empPassword)
			throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO EMPLOYEE VALUES("+empID+",'"+empFName+"','"+empLName+"','"+empUsername+"','"+empPassword+"')";
		stmt.executeUpdate(sql);
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		List<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			employeeList.add(e);
		}
		return employeeList;
	}

}
