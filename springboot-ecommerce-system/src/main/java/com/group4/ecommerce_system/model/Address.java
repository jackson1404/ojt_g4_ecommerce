package com.group4.ecommerce_system.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String buildingName;
	private String city;
	private String street;
	
	public Address(){
		
	}
	
	public Address(String buildingName, String city, String street) {
		this.buildingName = buildingName;
		this.city = city;
		this.street = street;
	}

	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
} 
