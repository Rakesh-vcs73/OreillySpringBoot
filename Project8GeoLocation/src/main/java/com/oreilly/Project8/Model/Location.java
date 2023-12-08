package com.oreilly.Project8.Model;

public class Location {
	
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
