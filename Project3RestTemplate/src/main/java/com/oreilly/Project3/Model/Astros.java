package com.oreilly.Project3.Model;


public class Astros {
	
	private String name;
	private String craft;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCraft() {
		return craft;
	}
	public void setCraft(String craft) {
		this.craft = craft;
	}
	@Override
	public String toString() {
		return "Astros [name=" + name + ", craft=" + craft + "]";
	}

}
