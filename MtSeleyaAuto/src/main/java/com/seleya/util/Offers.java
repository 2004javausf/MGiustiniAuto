package com.seleya.util;

public class Offers {
	private static int offerID;
	private static int offerAmt;
	private static int offerCar;
	private static int offerCust;
	
	public Offers(int offerID, int offerAmt, int offerCar, int offerCust) {
		this.offerID = offerID;
		this.offerAmt = offerAmt;
		this.setOfferCar(offerCar);
		this.setOfferCust(offerCust);
	}

	public static int getOfferID() {
		return offerID;
	}

	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}

	public static int getOfferAmt() {
		return offerAmt;
	}

	public void setOfferAmt(int offerAmt) {
		this.offerAmt = offerAmt;
	}

	public static int getOfferCar() {
		return offerCar;
	}

	public void setOfferCar(int offerCar) {
		this.offerCar = offerCar;
	}

	public static int getOfferCust() {
		return offerCust;
	}

	public void setOfferCust(int offerCust) {
		this.offerCust = offerCust;
	}

	@Override
	public String toString() {
		return "Offers [offerID=" + offerID + ", offerAmt=" + offerAmt + ", offerCar=" + offerCar + ", offerCust="
				+ offerCust + "]";
	}

}
