package com.exp.exptracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ExpenseData {
	private String expensename;
	
	private int expensevalue;

	
	
	private int userdetailsid;

	public String getExpensename() {
		return expensename;
	}

	public void setExpensename(String expensename) {
		this.expensename = expensename;
	}

	public int getExpensevalue() {
		return expensevalue;
	}

	public void setExpensevalue(int expensevalue) {
		this.expensevalue = expensevalue;
	}

	

	public int getUserdetailsid() {
		return userdetailsid;
	}

	public void setUserdetailsid(int userdetailsid) {
		this.userdetailsid = userdetailsid;
	}
	
}
