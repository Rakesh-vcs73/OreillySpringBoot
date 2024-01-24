package com.expense.expenseManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.expenseManagement.Model.Expenses;

public interface ExpenseRepo extends JpaRepository<Expenses, Integer>{

}
