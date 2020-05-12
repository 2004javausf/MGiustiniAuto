package com.seleya.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.seleya.beans.Car;
import com.seleya.beans.Customer;
import com.seleya.dao.CustomerDAO;

public class UserAccounts {
	static Scanner scan = new Scanner(System.in);
	public static List<?> offerList = new ArrayList<>();
	public static List<?> newoffers = new ArrayList<>();
	
	//place new offers in pending state for employee approval
	public Offer newOffer() {
		Offer newOff = new Offer();
		newOffer.add(newOff)''
	}
	//checks new potential username against customerList to prevent duplicates
	public static Customer exists(String userExist) {
		for(int i = 0; i < customerList.size(); i++) {
			String existingUser = customerList.get(i).getCustUsername();
			if(userExist.equals(existingUser)) {
				System.out.println("Username taken. Please try again.");
				Menu.signUp();
			}
		}
		return null;
	}
	//login
	public static Customer login(String custUsername, String custPassword) {
		for(int i=0; i<customerList.size(); i++) {
			String customer = customerList.get(i).getCustUsername();
			String password = customerList.get(i).getCustPassword();
			if(custUsername.equals(customer) && custPassword.equals(password)) {
				return customerList.get(i);
			} else {
				System.out.println("Username and/or Password incorrect. Please try again.");
				Menu.customerLogin();
			}
		}
		return null;
	}
	
	//employee codes
	//allow employee to approve or deny offers
//	public static Offer approveOrDeny() {
//		for(Offer newOff: new) {
//			System.out.println("NEW OFFERS WAITING FOR APPROVAL N/"+"OFFER #"+newOff.getOfferID()+" OF "+newOff.getOfferAmt+" MADE BY "+c.getCustFName()+" "+c.getCustLName()+"FOR CAR "+r.getCarID());
//		}
//		return null;
//	}
	
	public static void appDeny() {
		for(Offer newOff : newoffers) {
			System.out.println("NEW OFFERS WAITING FOR APPROVAL N/"+"OFFER #"+newOff.getOfferID()+" OF "+newOff.getOfferAmt+" MADE BY "+c.getCustFName()+" "+c.getCustLName()+"FOR CAR "+r.getCarID());
			System.out.println("[A]pprove Offer \n"
								+"[D]eny Offer");
			String select = scan.nextLine();
			switch(select.toLowerCase()) {
			case "a":
				offerList.add(newOff);
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
	public static Payment employeeCheck() {
		for(int i = 0; i < paymentList.size(); i++) {
			int payment = paymentList.get(i).getPaymentID();
			if(paymentInfo.equals(payment)) {
				return paymentList.get(i);
			}
		}
		return null;
	}
	
	public static void removeCar() {
		System.out.println("Enter the ID of the car you would like to remove");
		int vin = scan.nextInt();
		for(Car r : carList) {
			if(r.getCarID() == vin) {
				System.out.println(r.getCarID()+" "+r.getCarMake()+" "+r.getCarModel());
				carList.remove(r);
				System.out.println("Car Removed from the lot");
				Files.writeCarFile(carList);
				Menu.employeeMenu();
			}else {
				System.out.println();
				System.out.println("No such car on the lot");
				break;
			}
		}
	}
}
