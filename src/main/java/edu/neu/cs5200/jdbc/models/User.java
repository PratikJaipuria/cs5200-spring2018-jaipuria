package edu.neu.cs5200.jdbc.models;

import java.time.LocalDate;
import java.util.Date;

public class User extends Person{
	private int userId;
	private boolean userAgreement;
	
	public User(String firstName, String lastName, String username, String password, String eamil,
			LocalDate dob, boolean userAgreement) {
		super( firstName, lastName, username, password, eamil, dob);
		this.userAgreement = userAgreement;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int personId, String firstName, String lastName, String username, String password, String eamil,
			LocalDate dob) {
		super(personId, firstName, lastName, username, password, eamil, dob);
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	
	
	
}
