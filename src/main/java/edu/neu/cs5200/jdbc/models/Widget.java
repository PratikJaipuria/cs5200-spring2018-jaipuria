package edu.neu.cs5200.jdbc.models;


public class Widget {
	private Integer widgetId;
	private String name;
	private Integer width;
	private Integer height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private Integer order;
	private Integer pageId;
	
	public Widget( String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.pageId = pageId;
	}
	
	public Widget(Integer widgetId, String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId) {
		super();
		this.widgetId = widgetId;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.pageId = pageId;
	}

	public Widget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getCssStyle() {
		return cssStyle;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	
}
