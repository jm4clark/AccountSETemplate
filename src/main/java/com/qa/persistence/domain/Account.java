
package com.qa.persistence.domain;

public class Account {

	// This class needs to have:
	// An id
	private static int counter = 0;
	private int id;
	// An Account Number
	private int accNum;
	// A First Name
	private String firstName;
	// A last Name
	private String lastName;
	
	public Account(int accNum, String firstName, String lastName) {
		this.accNum = accNum;
		this.firstName = firstName;
		this.lastName = lastName;
		
		counter++;
		this.id = counter;
	}
	
	public long getID() {
		return id;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
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
