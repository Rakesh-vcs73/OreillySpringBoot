package com.expense.expenseManagement.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {
	
	@Id
	private Integer id;
	
	private Long amount;
	private String description;
	
	
	public Expenses() {
		super();
	}
	
	public Expenses(Integer id, Long amount, String description) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Expenses [id=" + id + ", amount=" + amount + ", description=" + description + "]";
	}

}
