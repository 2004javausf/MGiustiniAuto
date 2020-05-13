package com.seleya.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.seleya.beans.Customer;
import com.seleya.beans.Payment;
import com.seleya.daoimpl.CarDAOImpl;
import com.seleya.daoimpl.CustomerDAOImpl;
import com.seleya.daoimpl.EmployeeDAOImpl;
import com.seleya.daoimpl.OffersDAOImpl;
import com.seleya.daoimpl.PaymentDAOImpl;

public class Transactions {
	public static ConnFactory cf = ConnFactory.getInstance();
	static Scanner scan = new Scanner(System.in);
	static CustomerDAOImpl cdi = new CustomerDAOImpl();
	static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static CarDAOImpl rdi = new CarDAOImpl();
	static PaymentDAOImpl pdi = new PaymentDAOImpl();
	static OffersDAOImpl odi = new OffersDAOImpl();
	
	public static void makeOffer() throws SQLException {
		try {
			rdi.getCarList();
			System.out.println(rdi.getCarList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Which car would you like to make an offer on?");
		int c = scan.nextInt();
		System.out.println("How much would you like to offer?");
		int o = scan.nextInt();
		new Offers(Offers.getOfferID(), Offers.getOfferAmt(), Offers.getOfferCar(), Offers.getOfferCust());
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO OFFERS VALUES("+Offers.getOfferID()+", "+Offers.getOfferAmt()+", "+Offers.getOfferCar()+", "+Offers.getOfferCust()+")";
		stmt.executeUpdate(sql);
		System.out.println("Thank you for making an offer. You will be notified if it is accepted.");
		Menu.customerOptions();
	}
	
	public static void makePayment(Payment d) throws SQLException {
		Connection conn = ConnFactory.cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER_CARS WHERE CUSTOMER_ID = '"+Customer.getCustID()+"'");
		System.out.println(rs);
		System.out.println("How many payments would you like to make?");
		int p = scan.nextInt();
		System.out.println("After making "+p+" payments, you have "+(d.getPlanLength()-p)+" payments remaining");
		
	}
}
