package edu.neu.cs5200.jdbc.models;

public class HeadingWidget extends Widget{
	private Integer headingWidgetId;
	private Integer size;
	
	public HeadingWidget(String name, Integer width, Integer height, String cssClass, String cssStyle,
			String text, Integer order, Integer pageId, Integer size) {
		super(name, width, height, cssClass, cssStyle, text, order, pageId);
		this.size = size;
	}

	public HeadingWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HeadingWidget(Integer widgetId, String name, Integer width, Integer height, String cssClass, String cssStyle,
			String text, Integer order, Integer pageId) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId);
		// TODO Auto-generated constructor stub
	}

	public Integer getHeadingWidgetId() {
		return headingWidgetId;
	}

	public void setHeadingWidgetId(int headingWidgetId) {
		this.headingWidgetId = headingWidgetId;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
		
}
