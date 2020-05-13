package com.seleya.beans;

public class Customer {
	private static int custID;
	private String custFName;
	private String custLName;
	private static String custUsername;
	private static String custPassword;
	
	public Customer(int custID, String custFName, String custLName, String custUsername, String custPassword) {
		super();
		this.custID = custID;
		this.custFName = custFName;
		this.custLName = custLName;
		this.custUsername = custUsername;
		this.custPassword = custPassword;
	}

	public static int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public String getCustUsername() {
		return custUsername;
	}

	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custFName=" + custFName + ", custLName=" + custLName
				+ ", custUsername=" + custUsername + ", custPassword=" + custPassword + "]";
	}
	
}
