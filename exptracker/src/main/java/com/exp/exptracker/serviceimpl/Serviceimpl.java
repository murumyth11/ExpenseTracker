package com.exp.exptracker.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.exptracker.model.ExpenseData;
import com.exp.exptracker.model.ExpenseDetails;
import com.exp.exptracker.model.UserDetails;
import com.exp.exptracker.repository.ExpenseRepo;
import com.exp.exptracker.repository.UserRepo;
import com.exp.exptracker.service.UserService;

@Service
public class Serviceimpl implements UserService {

	@Autowired
	UserRepo userrepo;

	@Autowired
	ExpenseRepo expenserepo;

	@Override
	public void adduser(UserDetails userdetails) {
		userrepo.save(userdetails);

	}

	@Override
	public List<UserDetails> getall() {
		return userrepo.findAll();
	}

	@Override
	public List<UserDetails> getByUserid(int userid) {
		return userrepo.findById(userid);
	}

	@Override
	public void addExpense(ExpenseData expensedata) {

		List<UserDetails> userdetails = userrepo.findById(expensedata.getUserdetailsid());

		ExpenseDetails exp = new ExpenseDetails();
		exp.setExpensename(expensedata.getExpensename());
		exp.setExpensevalue(expensedata.getExpensevalue());
		exp.setUserdetails(userdetails.get(0));

		expenserepo.save(exp);

	}

	@Override
	public int totalexpense(int id) {

		List<ExpenseDetails> lis = expenserepo.getTotalExpense(id);
		 
		Iterator<ExpenseDetails> itr = lis.iterator();
		
		int a = 0;
		while (itr.hasNext()) 
		{
           ExpenseDetails ed = itr.next();
         int b=  ed.getExpensevalue();
         a=a+b;
		}
		return a;

	}

	@Override
	public int dailytotal(int id) {
		List<ExpenseDetails> lis = expenserepo.getDailyTotal(id);
		 
		Iterator<ExpenseDetails> itr = lis.iterator();
		
		int a = 0;
		while (itr.hasNext()) 
		{
           ExpenseDetails ed = itr.next();
         int b=  ed.getExpensevalue();
         a=a+b;
		}
		return a;
	}

	@Override
	public int weeklytotal(int id) {
		List<ExpenseDetails> lis=expenserepo.getweeklytotal(id);
		int a=0;
		Iterator<ExpenseDetails> itr=lis.iterator();
		while(itr.hasNext())
		{
			ExpenseDetails ed=itr.next();
			int b=ed.getExpensevalue();
			a=a+b;
		}
		return a;
	}

}
