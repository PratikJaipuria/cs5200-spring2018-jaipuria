package edu.neu.cs5200.jdbc.models;

import java.time.LocalDate;
import java.util.List;

public class Page {
	private int pageId;
	private String title;
	private String description;
	private LocalDate created;
	private LocalDate updated;
	private int views;
	private int websiteId;
	private List<Widget> widget;
	
	
	public Page(int pageId, String title, String description, LocalDate created, LocalDate updated, int views,
			int websiteId) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		this.websiteId = websiteId;
	}

	public Page(String title, String description, LocalDate created, LocalDate updated, int views) {
		super();
		
		this.title = title;
		this.description = description;
		this.created = created;
		this.updated = updated;
		this.views = views;
		
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public List<Widget> getWidget() {
		return widget;
	}

	public void setWidget(List<Widget> widget) {
		this.widget = widget;
	}
	
	
		
}
