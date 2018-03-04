package edu.neu.cs5200.jdbc.models;

public class Address {
	protected int addressId;
	protected String street1;
	protected String street2;
	protected String city;
	protected String state;
	protected String zip;
	protected boolean primary;
	protected int address_person_composition;
	
	public Address(String street1, String street2, String city, String state, String zip, boolean primary,int address_person_composition) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary = primary;
		this.address_person_composition = address_person_composition;
	}

	public Address(int id, String street1, String street2, String city, String state, String zip, boolean primary,int address_person_composition) {
		super();
		this.addressId = id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.primary = primary;
		this.address_person_composition = address_person_composition;
	}
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public int getAddress_person_composition() {
		return address_person_composition;
	}

	public void setAddress_person_composition(int address_person_composition) {
		this.address_person_composition = address_person_composition;
	}
	
	
	
}
