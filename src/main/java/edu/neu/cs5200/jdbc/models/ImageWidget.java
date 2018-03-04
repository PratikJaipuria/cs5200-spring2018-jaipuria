package edu.neu.cs5200.jdbc.models;

public class ImageWidget extends Widget{
	private int imageWidgetId;
	private String src;
	
	public ImageWidget(String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId, String src) {
		super(name, width, height, cssClass, cssStyle, text, order, pageId);
		this.src = src;
	}

	public ImageWidget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(int widgetId, String name, Integer width, Integer height, String cssClass, String cssStyle, String text,
			Integer order, Integer pageId) {
		super(widgetId, name, width, height, cssClass, cssStyle, text, order, pageId);
		// TODO Auto-generated constructor stub
	}

	public int getImageWidgetId() {
		return imageWidgetId;
	}

	public void setImageWidgetId(int imageWidgetId) {
		this.imageWidgetId = imageWidgetId;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

		
}
