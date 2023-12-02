package com.oreilly.Project4.Model;

import java.util.List;

public class AstroResult {

	
	public String message;
	public int number;
	public List<Astro> people;
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
	public List<Astro> getPerson() {
		return people;
	}
	public void setPerson(List<Astro> person) {
		this.people = person;
	}
	@Override
	public String toString() {
		return "AstroResult [message=" + message + ", number=" + number + ", person=" + people + "]";
	}
	
	
}
