package edu.neu.cs5200.jdbc.models;

public class YouTubeWidget extends Widget{
	private Integer youtubeWidgetId;
	private String url;
	private Boolean shareable;
	private Boolean expandable;
	
	public YouTubeWidget(String name, Integer width, Integer height, String cssClass, String cssStyle,
			String text, Integer order, Integer pageId, String url, Boolean shareable,
			Boolean expandable) {
		super(name, width, height, cssClass, cssStyle, text, order, pageId);
		
		this.url = url;
		this.shareable = shareable;
		this.expandable = expandable;
	}

	public YouTubeWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YouTubeWidget(int widgetId, String name, int width, int height, String cssClass, String cssStyle,
			String text, int order, int pageId) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId);
		// TODO Auto-generated constructor stub
	}

	public int getYoutubeWidgetId() {
		return youtubeWidgetId;
	}

	public void setYoutubeWidgetId(int youtubeWidgetId) {
		this.youtubeWidgetId = youtubeWidgetId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean isShareable() {
		return shareable;
	}

	public void setShareable(Boolean shareable) {
		this.shareable = shareable;
	}

	public Boolean isExpandable() {
		return expandable;
	}

	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	
		
}
