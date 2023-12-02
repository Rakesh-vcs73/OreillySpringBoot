package com.oreilly.Project4.Model;

public class Astro {
	
	public String name;
	public String craft;
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
		return "Astro [name=" + name + ", craft=" + craft + "]";
	}
}
