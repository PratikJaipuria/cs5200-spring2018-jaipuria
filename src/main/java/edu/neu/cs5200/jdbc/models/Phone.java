package edu.neu.cs5200.jdbc.models;

public class Phone {
	protected Integer phoneId;
	protected String phone;
	protected boolean primary;
	protected int phone_person_composition;
	
	
	public Phone(String phone, boolean primary, int phone_person_composition) {
		super();
		this.phone = phone;
		this.primary = primary;
		this.phone_person_composition = phone_person_composition;
	}
	public Integer getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(Integer phoneId) {
		this.phoneId = phoneId;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isPrimary() {
		return primary;
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	
	public int getPhone_person_composition() {
		return phone_person_composition;
	}
	public void setPhone_person_composition(int phone_person_composition) {
		this.phone_person_composition = phone_person_composition;
	}
		
}
