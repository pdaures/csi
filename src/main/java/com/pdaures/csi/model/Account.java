package com.pdaures.csi.model;

public class Account {

	private final String firstName;
	private final String lastName;
	
	public Account(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	
	
}
