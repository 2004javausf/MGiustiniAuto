package com.seleya.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.seleya.beans.Payment;
import com.seleya.dao.PaymentDAO;
import com.seleya.util.ConnFactory;

public class PaymentDAOImpl implements PaymentDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void insertPayment(int planID, int payeeID, int planLength, int payAmt, int amtPaid, int payRem)
			throws SQLException {
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO PAYMENT_PLANS VALUES("+planID+", "+payeeID+", "+planLength+", "+payAmt+", "+amtPaid+", "+payRem+")";
			stmt.executeUpdate(sql);
		
	}

	@Override
	public List<Payment> getPaymentList() throws SQLException {
		List<Payment> paymentList = new ArrayList<Payment>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PAYMENT_PLANS");
		Payment p = null;
		while(rs.next()) {
			p = new Payment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
			paymentList.add(p);
		}
		return paymentList;
		
	}

}
