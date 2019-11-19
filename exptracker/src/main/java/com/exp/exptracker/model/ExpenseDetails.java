package com.exp.exptracker.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="expensedetails")
public class ExpenseDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseid;
	
	@Column(name="expensename")
	private String expensename;
	
	@Column(name="expensevalue")
	private int expensevalue;

	@Column(name="date")
	private Date date =new Date();
	
	@ManyToOne
	private UserDetails userdetails;
	
	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	public int getExpenseid() {
		return expenseid;
	}

	public void setExpenseid(int expenseid) {
		this.expenseid = expenseid;
	}

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
	
	

}
