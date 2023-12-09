package com.oreilly.Project8.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "locations")
public class Location {
	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
	
	private Integer place_id;
	private String lat;
	private String lon;
	private String display_name;
	
	
	
	public Location() {
		super();
	}
	
	
	public Location(String lat, String lon, String display_name) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.display_name = display_name;
	}
	
	
	public Location(Integer place_id, String lat, String lon, String display_name) {
		super();
		this.place_id = place_id;
		this.lat = lat;
		this.lon = lon;
		this.display_name = display_name;
	}


//	public Integer getId() {
//		return id;
//	}
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Integer getPlace_id() {
		return place_id;
	}


	public void setPlace_id(Integer place_id) {
		this.place_id = place_id;
	}


	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lon=" + lon + ", display_name=" + display_name + "]";
	}
	
	

}
