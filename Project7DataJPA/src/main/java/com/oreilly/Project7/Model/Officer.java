package com.oreilly.Project7.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "officers")
public class Officer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Rank rank;
	private String firstname;
	private String lastname;
	
	public Officer() {
		super();
		
	}
	
	public Officer(Integer id, Rank rank, String firstname, String lastname) {
		super();
		this.id = id;
		this.rank = rank;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	public Officer(Rank rank, String firstname, String lastname) {
		super();
		this.rank = rank;
		this.firstname = firstname;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "Officer [id=" + id + ", rank=" + rank + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}


}
