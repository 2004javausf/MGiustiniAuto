package com.seleya.util;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.seleya.beans.Customer;
import com.seleya.daoimpl.CarDAOImpl;
import com.seleya.daoimpl.CustomerDAOImpl;
import com.seleya.daoimpl.EmployeeDAOImpl;

public class Menu {
	
	static Scanner scan = new Scanner(System.in);
	static CustomerDAOImpl cdi = new CustomerDAOImpl();
	static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static CarDAOImpl rdi = new CarDAOImpl();
	
	public static void mainMenu() {
		System.out.println("**WELCOME TO MT. SELEYA AUTO**");
		System.out.println("Are you a Customer or an Employee? \n"
							+"[C]ustomer \n"
							+"[E]mployee");
		String mainSelect = scan.nextLine();
		switch(mainSelect.toLowerCase()) {
		case "c":
			customerMenu();
			break;
		case "e":
			employeeLogin();
			break;
		default:
			break;
		}
	}
		
	public static void customerMenu() {
		System.out.println("**WELCOME TO MT. SELEYA AUTO**");
		System.out.println("Please select one of the following: \n"
							+"1. I have an account \n"
							+"2. I want to create an account \n"
							+"3. Exit");
		int selection = Integer.parseInt(scan.nextLine());
		switch(selection) {
		case 1:
			customerLogin();
			break;
		case 2:
			signUp();
			break;
		case 3:
			System.out.println("Goodbye");
			mainMenu();
			break;
		default:
			System.out.println("Invalid entry. Please try again.");
			customerMenu();
			break;
		}
	}
	
	public static void customerLogin() {
		System.out.println("Please Sign In");
		System.out.println("Username:");
		String username = scan.nextLine();
		Object user = customerList.login(username);
	}
	
	public static void signUp() {
		System.out.println("Create An Account");
		System.out.println("First Name");
		String custFName = scan.nextLine();
		System.out.println("Last Name");
		String custLName = scan.nextLine();
		System.out.println("Username");
		String custUsername = scan.nextLine();
		Customer c = UserAccounts.exists(custUsername);
		System.out.println("Password");
		String custPassword = scan.nextLine();
		int custID = ThreadLocalRandom.current().nextInt();
		System.out.println();
		try {
			cdi.insertCustomer(custID, custFName, custLName, custUsername, custPassword);
			cdi.getCustomerList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainMenu();
	}
	
	public static void addCar() {
		System.out.println("Add a car to the lot");
		int carID = ThreadLocalRandom.current().nextInt();
		System.out.println("Car Make");
		String carMake = scan.nextLine();
		System.out.println("Car Model");
		String carModel = scan.nextLine();
		System.out.println("Year (YYYY)");
		String carYear = scan.nextLine();
		System.out.println("Color");
		String carColor = scan.nextLine();
		System.out.println("Price");
		int carPrice = scan.nextInt();
		System.out.println("Owned");
		String owned = scan.nextLine();
		System.out.println();
		try {
			rdi.insertCar(carID, carMake, carModel, carYear, carColor, carPrice, owned);
			rdi.getCarList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employeeMenu();
	}
	
	public static void employeeLogin() {
		String empUsername = "maurieg05";
		String empPassword = "StrongPassword";
		System.out.println("Employee Portal");
		System.out.println("Please enter your username");
		empUsername = scan.nextLine();
		System.out.println("Please enter your password");
		empPassword = scan.nextLine();
		if(empUsername.equals(empUsername) && empPassword.equals(empPassword)) {
			System.out.println("Welcome Maurie");
			employeeMenu();
		}else {
			System.out.println("Username and/or password is incorrect. Please try again");
			employeeLogin();
		}
	}
	
	public static void employeeMenu() {
		System.out.println("[A]dd a new car to the lot \n"
							+"[E]xamine offers to accept or reject \n"
							+"[R]emove a car from the lot \n"
							+"[V]iew all payments");
		String selection = scan.nextLine();
		switch(selection.toLowerCase()) {
		case "a":
			addCar();
			break;
		case "e":
			UserAccounts.appDeny();
			break;
		case "r":
			UserAccounts.removeCar();
			break;
		case "v":
		default:
		}
	}
	
	public static void reviewPayments() {
		System.out.println("View Plan Payments");
		System.out.println("Enter Payment Plan ID");
		int planID = scan.nextInt();
		Payment check = UserAccounts.employeeCheck(planID);
		System.out.println(check);
		System.out.println("Payment Plan"+check.getPlanID);
		System.out.println("Would you like to look up another payment plan? y/n \n"
				+ "'No' will return you to the Employee Portal");
		String select = scan.nextLine();
		switch(select.toLowerCase()) {
		case "y":
			reviewPayments();
			scan.nextLine();
			break;
		case "n":
			employeeMenu();
			break;
		default:
			System.out.println("Invalid entry. Please try again");
			break;
		}
	}
}
