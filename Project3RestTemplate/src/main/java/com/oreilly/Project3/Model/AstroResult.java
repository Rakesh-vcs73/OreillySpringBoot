package com.oreilly.Project3.Model;

import java.util.List;

public class AstroResult {
	
	private String message;
	private int number;
	private List<Astros> people;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getNumber() {
		return number;
	}



	public void setNumber(int number) {
		this.number = number;
	}



	public List<Astros> getPeople() {
		return people;
	}



	public void setPeople(List<Astros> people) {
		this.people = people;
	}



	@Override
	public String toString() {
		return "AstroResult [message=" + message + ", number=" + number + ", people=" + people + "]";
	}
	
	

}
