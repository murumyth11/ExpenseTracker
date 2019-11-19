package com.exp.exptracker.service;

import java.util.List;
import java.util.Optional;

import com.exp.exptracker.model.ExpenseData;
import com.exp.exptracker.model.UserDetails;

public interface UserService {

	public void adduser(UserDetails userdetails);

	public List<UserDetails> getall();

	public List<UserDetails> getByUserid(int userid);

	

	public void addExpense(ExpenseData expensedata);

	public int totalexpense(int id);

	public int dailytotal(int id);

	public int weeklytotal(int id);
				
	
	

}
