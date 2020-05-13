package com.seleya.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.seleya.beans.Customer;
import com.seleya.beans.Payment;
import com.seleya.daoimpl.CarDAOImpl;
import com.seleya.daoimpl.CustomerDAOImpl;
import com.seleya.daoimpl.EmployeeDAOImpl;
import com.seleya.daoimpl.OffersDAOImpl;
import com.seleya.daoimpl.PaymentDAOImpl;

public class Menu {
	private static final Payment Payment = null;
	static Scanner scan = new Scanner(System.in);
	static CustomerDAOImpl cdi = new CustomerDAOImpl();
	static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static CarDAOImpl rdi = new CarDAOImpl();
	static PaymentDAOImpl pdi = new PaymentDAOImpl();
	static OffersDAOImpl odi = new OffersDAOImpl();
	
	public static void mainMenu() throws SQLException {
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
		
	public static void customerMenu() throws SQLException {
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
	
	public static Customer customerLogin() throws SQLException {
		try {
			cdi.getCustomerList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean logInSuccess = false;
		System.out.println("Please enter your username");
		String user = scan.nextLine();
		System.out.println("PLease enter your password");
		String pass = scan.nextLine();
		for(int i = 0; i<cdi.getCustomerList().size(); i++) {
			String username = cdi.getCustomerList().get(i).getCustUsername();
			String password = cdi.getCustomerList().get(i).getCustPassword();
			if(user.equals(username) && pass.equals(password)) {
				cdi.getCustomerList().get(i);
				logInSuccess = true;
			}
			}
		if(logInSuccess==true) {
			System.out.println("Successfully logged in");
			customerOptions();
		}else {
			System.out.println("Incorrect username and/or password. Please try again");
			customerLogin();
		}
		return null;
	}
	
	public static void customerOptions() throws SQLException {
		System.out.println("WELCOME BACK");
		System.out.println("What Would You Like to Do? \n"
							+"1. View Available Cars \n"
							+"2. Make An Offer On a Car \n"
							+"3. View My Car(s) \n"
							+"4. View My Payment Plan(s) \n"
							+"5. Make A Payment \n"
							+"6. Exit");
		int selection = Integer.parseInt(scan.nextLine());
		switch(selection) {
		case 1:
			try {
				rdi.getCarList();
				System.out.println(rdi.getCarList());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				Transactions.makeOffer();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			break;
		case 3:
			Connection conn = ConnFactory.cf.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER_CARS WHERE CUSTOMER_ID = '"+Customer.getCustID()+"'");
			break;
		case 4:
			Connection conn2 = ConnFactory.cf.getConnection();
			Statement stmt2 = conn2.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT * FROM PAYMENT_PLANS WHERE CUSTOMER_ID = '"+Customer.getCustID()+"'");
			Payment p = null;
			while(rs2.next()) {
				p = new Payment(rs2.getInt(1), rs2.getInt(2), rs2.getInt(3), rs2.getInt(4), rs2.getInt(5), rs2.getInt(6));
				pdi.getPaymentList().add(p);
			}
			try {
				pdi.getPaymentList();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case 5:
			try {
				Transactions.makePayment(Payment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		case 6:
			System.out.println("Goodbye");
			try {
				mainMenu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid entry. Please try again.");
			try {
				customerMenu();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
	
	
	public static void signUp() throws SQLException {
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
	
	public static void addCar() throws SQLException {
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
	
	public static void employeeLogin() throws SQLException {
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
	
	public static void employeeMenu() throws SQLException {
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
			try {
				UserAccounts.removeCar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "v":
		default:
		}
	}
	
	@SuppressWarnings("static-access")
	public static void reviewPayments() throws SQLException {
		System.out.println("View Plan Payments");
		System.out.println("Enter Payment Plan ID");
		int planID = scan.nextInt();
		Payment check = UserAccounts.employeeCheck(planID);
		System.out.println(check);
		System.out.println("Payment Plan"+check.getPlanID());
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
