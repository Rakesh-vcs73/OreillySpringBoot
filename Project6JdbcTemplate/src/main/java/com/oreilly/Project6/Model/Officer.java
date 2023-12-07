package com.oreilly.Project6.Model;

public class Officer {

	private Integer id;
	private Rank rank;
	private String firstName;
	private String lastname;
	
	
	public Officer() {
		super();
	}


	public Officer(Rank rank, String firstName, String lastname) {
		super();
		this.rank = rank;
		this.firstName = firstName;
		this.lastname = lastname;
	}


	public Officer(Integer id, Rank rank, String firstName, String lastname) {
		super();
		this.id = id;
		this.rank = rank;
		this.firstName = firstName;
		this.lastname = lastname;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Override
	public String toString() {
		return "Officer [id=" + id + ", rank=" + rank + ", firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	
	
}
