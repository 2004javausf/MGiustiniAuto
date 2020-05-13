package com.seleya.dao;

import java.sql.SQLException;
import java.util.List;

import com.seleya.util.Offers;

public interface OffersDAO {
	public void insertOffers(int offerID, int offerAmt, int offerCar, int offerCust) throws SQLException;
	
	public List<Offers> getOfferList() throws SQLException;
}
