package edu.neu.cs5200.jdbc.models;

import java.time.LocalDate;
import java.util.Date;

public class Person {
	protected int personId;
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected String email;
	protected LocalDate dob;
	
	protected int addressId;
	protected int phoneId;
	
	public Person(String firstName, String lastName, String username, String password, String email,
			LocalDate dob) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int personId, String firstName, String lastName, String username, String password, String eamil,
			LocalDate dob) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = eamil;
		this.dob = dob;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	
	
		
	
	
}
