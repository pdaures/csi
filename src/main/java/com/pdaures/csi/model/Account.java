package com.pdaures.csi.model;

public class Account {

	private final String firstName;
	private final String lastName;
	private final String country;
	
	public Account(String firstName, String lastName, String country){
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getCountry() {
		return country;
	}

	
	
}
