package com.seleya.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seleya.beans.Payment;
import com.seleya.dao.OffersDAO;
import com.seleya.util.ConnFactory;
import com.seleya.util.Offers;

public class OffersDAOImpl implements OffersDAO{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertOffers(int offerID, int offerAmt, int offerCar, int offerCust) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO OFFERS VALUES("+offerID+", "+offerAmt+", "+offerCar+", "+offerCust+")";
		stmt.executeUpdate(sql);
		
	}

	@Override
	public List<Offers> getOfferList() throws SQLException {
		List<Offers> offerList = new ArrayList<Offers>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS");
		Offers o = null;
		while(rs.next()) {
			o = new Offers(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
			offerList.add(o);
		}
		return offerList;
	}

}
