package com.seleya.dao;

import java.sql.SQLException;
import java.util.List;

import com.seleya.beans.Payment;

public interface PaymentDAO {
	public void insertPayment(int planID, int payeeID, int planLength, int payAmt, int amtPaid, int payRem) throws SQLException;
	
	public List<Payment> getPaymentList() throws SQLException;
}
