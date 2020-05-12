package com.seleya.beans;

public class Car {
	private int carID;
	private String carMake;
	private String carModel;
	private String carYear;
	private String carColor;
	private int carPrice;
	private String owned;
	

	public Car(int carID, String carMake, String carModel, String carYear, String carColor, int carPrice, String owned) {
		super();
		this.carID = carID;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = carYear;
		this.carColor = carColor;
		this.carPrice = carPrice;
		this.owned = owned;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public String getOwned() {
		return owned;
	}

	public void setOwned(String owned) {
		this.owned = owned;
	}


	@Override
	public String toString() {
		return "Car [carID=" + carID + ", carMake=" + carMake + ", carModel=" + carModel + ", carYear=" + carYear
				+ ", carColor=" + carColor + ", carPrice=" + carPrice + ", owned=" + owned +"]";
	}
	
}
