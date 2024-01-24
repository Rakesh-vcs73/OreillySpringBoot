package com.expense.expenseManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.expenseManagement.Model.Expenses;
import com.expense.expenseManagement.Service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/fetchAll")
	private List<Expenses> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/getTotal")
	private Long getTotal() {
		return expenseService.getTotalExpense();
	}
	
	@PostMapping("/addExpense")
	private Expenses addExpense(@RequestBody Expenses exp){
		return expenseService.addExpense(exp);
		
	}
	
	@PostMapping("/updateExpense/{id}")
	private Expenses updateExpense(@RequestBody Expenses exp, @PathVariable("id") Integer id){
		return expenseService.updateExpenses(exp, id);
	}
	
	
	@DeleteMapping("/delete/{id}")
	private Optional<Expenses> deleteOne(@PathVariable("id") Integer id) {
		return expenseService.deleteone(id);
		
	}
	
}
