package com.seleya.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.seleya.beans.Car;
import com.seleya.beans.Customer;
import com.seleya.beans.Payment;
import com.seleya.dao.CustomerDAO;
import com.seleya.daoimpl.CarDAOImpl;
import com.seleya.daoimpl.CustomerDAOImpl;
import com.seleya.util.Offers;
import com.seleya.daoimpl.OffersDAOImpl;

public class UserAccounts {
	static Scanner scan = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public static List<Offers> newoffers = new ArrayList<>();
	
	//place new offers in pending state for employee approval
//	public Offers newOffer() {
//		Offer newOff = new Offer();
//		newOffer.add(newOff)
//	}
	//checks new potential username against customerList to prevent duplicates
	public static Customer exists(String userExist) throws SQLException {
		for(int i = 0; i < Menu.cdi.getCustomerList().size(); i++) {
			String existingUser = Menu.cdi.getCustomerList().get(i).getCustUsername();
			if(userExist.equals(existingUser)) {
				System.out.println("Username taken. Please try again.");
				Menu.signUp();
			}
		}
		return null;
	}
	//login
	public static Customer login(String custUsername, String custPassword) throws SQLException {
		for(int i=0; i<Menu.cdi.getCustomerList().size(); i++) {
			String customer = Menu.cdi.getCustomerList().get(i).getCustUsername();
			String password = Menu.cdi.getCustomerList().get(i).getCustPassword();
			if(custUsername.equals(customer) && custPassword.equals(password)) {
				return Menu.cdi.getCustomerList().get(i);
			} else {
				System.out.println("Username and/or Password incorrect. Please try again.");
				Menu.customerLogin();
			}
		}
		return null;
	}
	
	//employee codes
	//allow employee to approve or deny offers
	@SuppressWarnings("null")
	public static void appDeny() throws SQLException {
		Customer c = null;
		Car r = null;
		for(Offers newOff : newoffers) {
			System.out.println("NEW OFFERS WAITING FOR APPROVAL N/"+"OFFER #"+newOff.getOfferID()+" OF "+newOff.getOfferAmt()+" MADE BY "+c.getCustFName()+" "+c.getCustLName()+"FOR CAR "+r.getCarID());
			System.out.println("[A]pprove Offer \n"
								+"[D]eny Offer");
			String select = scan.nextLine();
			switch(select.toLowerCase()) {
			case "a":
				Menu.odi.getOfferList().add(newOff);
				System.out.println("Offer Approved");
				break;
			case "d":
				System.out.println("Offer Denied");
				scan.nextLine();
				break;
			default:
				System.out.println("Please Make Another Selection");
				break;
			}
		}
		newoffers.removeAll(newoffers);
		System.out.println("No More Offers");
		Menu.employeeMenu();
		return;
	}
	
	//allow employee to see all payments
	public static Payment employeeCheck(int planID) throws SQLException {
		for(int i = 0; i < Menu.pdi.getPaymentList().size(); i++) {
			@SuppressWarnings("static-access")
			int payment = Menu.pdi.getPaymentList().get(i).getPlanID();
			if(Payment.getPlanID() == (payment)) {
				return Menu.pdi.getPaymentList().get(i);
			}
		}
		return null;
	}
	
	public static void removeCar() throws SQLException {
		System.out.println("Enter the ID of the car you would like to remove");
		int vin = scan.nextInt();
		for(Car r : Menu.rdi.getCarList()) {
			if(r.getCarID() == vin) {
				System.out.println(r.getCarID()+" "+r.getCarMake()+" "+r.getCarModel());
				Menu.rdi.getCarList().remove(r);
				System.out.println("Car Removed from the lot");
				Connection conn = cf.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "UPDATE TABLE CAR (OWNED) VALUES('YES')";
				stmt.executeUpdate(sql);
				Menu.employeeMenu();
			}else {
				System.out.println();
				System.out.println("No such car on the lot");
				break;
			}
		}
	}
}
