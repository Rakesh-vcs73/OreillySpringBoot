package com.oreilly.Project2.Model;


public class Greeting {
	
	public String message;

	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "{'message':'Hello World !!}";
	}

}
