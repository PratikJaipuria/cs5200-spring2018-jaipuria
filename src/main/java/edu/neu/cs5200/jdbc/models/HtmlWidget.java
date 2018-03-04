package edu.neu.cs5200.jdbc.models;


public class HtmlWidget extends Widget {
	private Integer htmlWidgetId;
	private String html;
	
	public HtmlWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId, String html) {
		super(name, width, height, cssClass, cssStyle, text, order, pageId);
		
		this.html = html;
	}

	public HtmlWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HtmlWidget(int widgetId, String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId);
		// TODO Auto-generated constructor stub
	}

	public int getHtmlWidgetId() {
		return htmlWidgetId;
	}

	public void setHtmlWidgetId(int htmlWidgetId) {
		this.htmlWidgetId = htmlWidgetId;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
	
		
}
