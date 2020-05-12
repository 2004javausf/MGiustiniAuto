package com.seleya.dao;

import java.sql.SQLException;
import java.util.List;

import com.seleya.beans.Customer;

public interface CustomerDAO {
	
	public void insertCustomer(int custID, String custFName, String custLName, String custUsername, String custPassword) throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
}
