package com.seleya.beans;

public class Payment {
	private static int planID;
	private int payeeID;
	private int planLength;
	private int payAmt;
	private int amtPaid;
	private int payRem;
	
	public Payment(int planID, int payeeID, int planLength, int payAmt, int amtPaid, int payRem) {
		super();
		Payment.planID = planID;
		this.payeeID = payeeID;
		this.planLength = planLength;
		this.payAmt = payAmt;
		this.amtPaid = amtPaid;
		this.payRem = payRem;
	}

	public static int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		Payment.planID = planID;
	}

	public int getPayeeID() {
		return payeeID;
	}

	public void setPayeeID(int payeeID) {
		this.payeeID = payeeID;
	}

	public int getPlanLength() {
		return planLength;
	}

	public void setPlanLength(int planLength) {
		this.planLength = planLength;
	}

	public int getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(int payAmt) {
		this.payAmt = payAmt;
	}

	public int getAmtPaid() {
		return amtPaid;
	}

	public void setAmtPaid(int amtPaid) {
		this.amtPaid = amtPaid;
	}

	public int getPayRem() {
		return payRem;
	}

	public void setPayRem(int payRem) {
		this.payRem = payRem;
	}

	@Override
	public String toString() {
		return "Payment [planID=" + planID + ", payeeID=" + payeeID + ", planLength=" + planLength + ", payAmt="
				+ payAmt + ", amtPaid=" + amtPaid + ", payRem=" + payRem + "]";
	}
	
}
