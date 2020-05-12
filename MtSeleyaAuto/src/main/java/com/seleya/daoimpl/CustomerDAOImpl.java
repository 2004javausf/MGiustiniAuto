package com.seleya.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seleya.beans.Customer;
import com.seleya.dao.CustomerDAO;
import com.seleya.util.ConnFactory;

public class CustomerDAOImpl implements CustomerDAO {
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void insertCustomer(int custID, String custFName, String custLName, String custUsername, String custPassword)
			throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO CUSTOMER VALUES("+custID+",'"+custFName+"','"+custLName+"','"+custUsername+"','"+custPassword+"')";
		stmt.executeUpdate(sql);
	}

	@Override
	public List<Customer> getCustomerList() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			customerList.add(c);
		}
		return customerList;
	}
	
}
