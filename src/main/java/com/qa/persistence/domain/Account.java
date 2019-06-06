
package com.qa.persistence.domain;

import javax.persistence.*;

@Entity
public class Account {

	// This class needs to have:
	// An id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	// An Account Number
	@Column(length = 10)
	private String accNum;
	// A First Name
	@Column(length = 50)
	private String firstName;
	// A last Name
	@Column(length = 50)
	private String lastName;

	public Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		//this.accNum = firstName.substring(0, 1) + lastName.substring(0, 1) + this.id;
	}

	public int getID() {
		return id;
	}

	public Account() {
		super();
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
