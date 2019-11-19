package com.exp.exptracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exp.exptracker.model.ExpenseDetails;

public interface ExpenseRepo extends JpaRepository<ExpenseDetails, Integer>{

	
	
	@Query(value = "SELECT * FROM exptracker.expensedetails WHERE userdetails_userid = ?1", nativeQuery = true)
	List<ExpenseDetails> getTotalExpense(int id);

	@Query(value = "SELECT * FROM exptracker.expensedetails WHERE userdetails_userid = ?1 and DATE(date) = curdate()", nativeQuery = true)
	List<ExpenseDetails> getDailyTotal(int id);
	@Query(value = "SELECT * FROM exptracker.expensedetails WHERE userdetails_userid = ?1 and yearweek(date) = yearweek(curdate())", nativeQuery = true)
	List<ExpenseDetails> getweeklytotal(int id);

}
