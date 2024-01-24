package com.expense.expenseManagement.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.expenseManagement.Model.Expenses;
import com.expense.expenseManagement.Repository.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepo repo;
	
	public List<Expenses> getAllExpenses(){
		return repo.findAll();
	}
	
	public Long getTotalExpense() {
		List<Expenses> expense = repo.findAll();
		AtomicReference<Long> totalExpense = new AtomicReference<>(0L);
		expense.forEach(e->
		{
			totalExpense.set(totalExpense.get() + e.getAmount());
			
		}
		);
		return totalExpense.get();
	}
	
	public Expenses addExpense(Expenses exp) {
		repo.save(exp);
		return exp;
	}
	
	public Expenses updateExpenses(Expenses exp, Integer id) {
		repo.save(exp);
		return exp;
	}
	
	public Optional<Expenses> deleteone(Integer id) {
		Optional<Expenses> exp = repo.findById(id);
		repo.deleteById(id);
		return exp;
	}

}
