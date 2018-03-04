package edu.neu.cs5200.jdbc.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Developer extends Person {
	private int developerId;
	private String developerKey;
	private List<Website> websites;
	
	public Developer(String firstName, String lastName, String username, String password, String email,
			LocalDate dob, String developerKey) {
		super(firstName, lastName, username, password, email, dob);
		this.developerKey = developerKey;
	}
	
	public Developer(int personId, String firstName, String lastName, String username, String password, String eamil,
			LocalDate dob, int developerId, String developerKey) {
		super(personId, firstName, lastName, username, password, eamil, dob);
		this.developerId = developerId;
		this.developerKey = developerKey;
	}

	
	public Developer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Developer(int personId, String firstName, String lastName, String username, String password, String eamil,
			LocalDate dob) {
		super(personId, firstName, lastName, username, password, eamil, dob);
		// TODO Auto-generated constructor stub
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public List<Website> getWebsites() {
		return websites;
	}

	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}
	
		
}
