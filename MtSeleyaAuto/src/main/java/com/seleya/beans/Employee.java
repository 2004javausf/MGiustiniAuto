package com.seleya.beans;

public class Employee {
	private int empID;
	private String empFName;
	private String empLName;
	private String empUsername;
	private String empPassword;
	public Employee(int empID, String empFName, String empLName, String empUsername, String empPassword) {
		super();
		this.empID = empID;
		this.empFName = empFName;
		this.empLName = empLName;
		this.empUsername = empUsername;
		this.empPassword = empPassword;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public String getEmpUsername() {
		return empUsername;
	}
	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFName=" + empFName + ", empLName=" + empLName + ", empUsername="
				+ empUsername + ", empPassword=" + empPassword + "]";
	}
	
}
