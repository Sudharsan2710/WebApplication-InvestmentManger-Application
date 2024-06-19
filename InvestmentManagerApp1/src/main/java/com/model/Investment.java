package com.model;

import java.sql.Date;

public class Investment {
	private int userId;
	private int investmenttype;
	private int amount;
	private Date date;
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getInvestmenttype() {
		return investmenttype;
	}
	public void setInvestmenttype(int investmenttype) {
		this.investmenttype = investmenttype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
