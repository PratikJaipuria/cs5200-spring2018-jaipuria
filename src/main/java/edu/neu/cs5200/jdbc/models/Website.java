package edu.neu.cs5200.jdbc.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Website {
	private int websiteId;
	private String name;
	private String description;
	private LocalDate created;
	private LocalDate updated;
	private int visits;

	private List<Page> pages;
	private int developerId;
	
	
	
	public Website(int websiteId, String name, String description, LocalDate created, LocalDate updated, int visits) {
		super();
		this.websiteId = websiteId;
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
	}
	public Website(String name, String description, LocalDate created, LocalDate updated, int visits) {
		super();
		
		this.name = name;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.visits = visits;
		
	}
	public Website() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public int getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public LocalDate getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDate updated) {
		this.updated = updated;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
	}
	
		

}
