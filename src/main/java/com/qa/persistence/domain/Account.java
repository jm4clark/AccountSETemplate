
package com.qa.persistence.domain;

public class Account {

	// This class needs to have:
	// An id
	private static int counter = 0;
	private int id;
	// An Account Number
	private String accNum;
	// A First Name
	private String firstName;
	// A last Name
	private String lastName;
	
	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		counter++;
		this.id = counter;

		this.accNum = firstName.substring(0, 1) + lastName.substring(0, 1) + this.id;
	}
	
	public int getID() {
		return id;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
