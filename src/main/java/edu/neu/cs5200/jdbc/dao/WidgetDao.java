package edu.neu.cs5200.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import edu.neu.cs5200.jdbc.models.HeadingWidget;
import edu.neu.cs5200.jdbc.models.HtmlWidget;
import edu.neu.cs5200.jdbc.models.ImageWidget;
import edu.neu.cs5200.jdbc.models.Website;
import edu.neu.cs5200.jdbc.models.Widget;
import edu.neu.cs5200.jdbc.models.YouTubeWidget;

public class WidgetDao {
	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static WidgetDao instance = null;
	public static WidgetDao getInstance() {
		if (instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	private WidgetDao() {}
	
	public int deleteWidget(int widgetId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from widget WHERE id = ?";			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			result = statement.executeUpdate();
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	
	}
	public int updateWidget(int widgetId, Widget widget) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "UPDATE widget SET name=?, width = ? , height = ?, cssClass = ? , cssStyle = ? , `text` = ? , `order`= ? , page_widget_composition = ?  where id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			if (widget.getWidth() == null ) {
				statement.setNull(2, java.sql.Types.INTEGER);
			} else {
				statement.setInt(2, widget.getWidth());
			}
			
			if (widget.getHeight() == null ) {
				statement.setNull(3, java.sql.Types.INTEGER);
			} else {
				statement.setInt(3, widget.getHeight());
			}
			
			if (widget.getCssClass() == null ) {
				statement.setNull(4, java.sql.Types.VARCHAR);
			} else {
				statement.setString(4, widget.getCssClass());
			}
			
			if (widget.getCssStyle() == null ) {
				statement.setNull(5, java.sql.Types.VARCHAR);
			} else {
				statement.setString(5, widget.getCssStyle());
			}
			
			if (widget.getText() == null ) {
				statement.setNull(6, java.sql.Types.VARCHAR);
			} else {
				statement.setString(6, widget.getText());
			}
			
			if (widget.getOrder() == null ) {
				statement.setNull(7, java.sql.Types.INTEGER);
			} else {
				statement.setInt(7, widget.getOrder());
			}
			
			statement.setInt(8, widget.getPageId());
			statement.setInt(9, widgetId);
			result = statement.executeUpdate();
			
					
			if(widget instanceof HeadingWidget) {
				sql = "UPDATE heading SET size = ? WHERE id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(2, widgetId);
				if (((HeadingWidget) widget).getSize() == null ) {
					statement.setNull(1, java.sql.Types.INTEGER);
				} else {
					statement.setInt(1, ((HeadingWidget) widget).getSize());
				}
			
				result = statement.executeUpdate();
				
			}else if(widget instanceof HtmlWidget) {
				sql = "UPDATE heading SET html= ? WHERE id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(2, widgetId);
				if (((HtmlWidget) widget).getHtml() == null ) {
					statement.setNull(1, java.sql.Types.VARCHAR);
				} else {
					statement.setString(1, ((HtmlWidget) widget).getHtml());
				}
			
				result = statement.executeUpdate();
				
			}else if(widget instanceof ImageWidget) {
				sql = "UPDATE image SET src= ? WHERE id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(2, widgetId);
				if (((ImageWidget) widget).getSrc() == null ) {
					statement.setNull(1, java.sql.Types.VARCHAR);
				} else {
					statement.setString(1, ((ImageWidget) widget).getSrc());
				}
			
				result = statement.executeUpdate();
				
			}else if(widget instanceof YouTubeWidget){
				sql = "UPDATE youtube SET url=?,shareable=?,expandable=? WHERE id = ?;";
				statement = connection.prepareStatement(sql);
				statement.setInt(4, widgetId);
				if (((YouTubeWidget) widget).getUrl() == null ) {
					statement.setNull(1, java.sql.Types.VARCHAR);
				} else {
					statement.setString(1, ((YouTubeWidget) widget).getUrl());
				}
				
				if (((YouTubeWidget) widget).isShareable() == null ) {
					statement.setNull(2, java.sql.Types.TINYINT);
				} else {
					statement.setBoolean(2, ((YouTubeWidget) widget).isShareable());
				}
				
				if (((YouTubeWidget) widget).isExpandable() == null ) {
					statement.setNull(3, java.sql.Types.TINYINT);
				} else {
					statement.setBoolean(3, ((YouTubeWidget) widget).isExpandable());
				}
				
				result = statement.executeUpdate();				
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Collection<Widget> findWidgetsForPage(int pageId){
		ArrayList<Widget> widgets = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM widget where page_widget_composition = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer widgetId = res.getInt("id");	
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				widgets.add(new Widget(widgetId, name, width,height,cssClass,cssStyle,text,order,pageId));
			}		
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return widgets;
	
	}
	public Widget findWidgetById(int widgetId) {
		Widget  widget = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM widget where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, widgetId);
			res = statement.executeQuery();
			
			while(res.next()) {
					
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				int pageId = res.getInt("page_widget_composition");
				widget = new Widget(widgetId, name, width,height,cssClass,cssStyle,text,order,pageId);
			}		
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	
		return widget;
	}
	public Collection<Widget> findAllWidgets(){
		ArrayList<Widget> widgets = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM widget";
			statement = connection.prepareStatement(sql);
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer widgetId = res.getInt("id");	
				String name = res.getString("name");
				Integer width = res.getInt("width");
				Integer height = res.getInt("height");
				String cssClass = res.getString("cssClass");
				String cssStyle = res.getString("cssStyle");
				String text = res.getString("text");
				Integer order = res.getInt("order");
				int pageId = res.getInt("page_widget_composition");
				widgets.add(new Widget(widgetId, name, width,height,cssClass,cssStyle,text,order,pageId));
			}		
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return widgets;
	}
	public int createWidgetForPage(int pageId, Widget widget) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "INSERT INTO widget (`name`, width, height, cssClass, cssStyle, `text`, `order`, page_widget_composition) VALUES (?,?,?,?,?,?,?,?)";
			
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			if (widget.getWidth() == null ) {
				statement.setNull(2, java.sql.Types.INTEGER);
			} else {
				statement.setInt(2, widget.getWidth());
			}
			
			if (widget.getHeight() == null ) {
				statement.setNull(3, java.sql.Types.INTEGER);
			} else {
				statement.setInt(3, widget.getHeight());
			}
			
			if (widget.getCssClass() == null ) {
				statement.setNull(4, java.sql.Types.VARCHAR);
			} else {
				statement.setString(4, widget.getCssClass());
			}
			
			if (widget.getCssStyle() == null ) {
				statement.setNull(5, java.sql.Types.VARCHAR);
			} else {
				statement.setString(5, widget.getCssStyle());
			}
			
			if (widget.getText() == null ) {
				statement.setNull(6, java.sql.Types.VARCHAR);
			} else {
				statement.setString(6, widget.getText());
			}
			
			if (widget.getOrder() == null ) {
				statement.setNull(7, java.sql.Types.INTEGER);
			} else {
				statement.setInt(7, widget.getOrder());
			}
			
			statement.setInt(8, pageId);
			result = statement.executeUpdate();
			
			sql = "SELECT * FROM widget WHERE name = ? and page_widget_composition = " + pageId;
			statement = connection.prepareStatement(sql);
			statement.setString(1, widget.getName());
			res = statement.executeQuery();
			Integer widgetId=null;
			
			if(res.next()) {
				widgetId = res.getInt("id");				
			}		
			
			if(widget instanceof HeadingWidget) {
				sql = "INSERT INTO heading (id,size) VALUES (?,?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
				if (((HeadingWidget) widget).getSize() == null ) {
					statement.setNull(2, java.sql.Types.INTEGER);
				} else {
					statement.setInt(2, ((HeadingWidget) widget).getSize());
				}
			
				result = statement.executeUpdate();
				
			}else if(widget instanceof HtmlWidget) {
				sql = "INSERT INTO html (id,html) VALUES (?,?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
				if (((HtmlWidget) widget).getHtml() == null ) {
					statement.setNull(2, java.sql.Types.VARCHAR);
				} else {
					statement.setString(2, ((HtmlWidget) widget).getHtml());
				}
			
				result = statement.executeUpdate();
				
			}else if(widget instanceof ImageWidget) {
				sql = "INSERT INTO image (id,src) VALUES (?,?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
				if (((ImageWidget) widget).getSrc() == null ) {
					statement.setNull(2, java.sql.Types.VARCHAR);
				} else {
					statement.setString(2, ((ImageWidget) widget).getSrc());
				}
			
				result = statement.executeUpdate();
				
			}else {
				sql = "INSERT INTO youtube (id,url,shareable,expandable) VALUES (?,?,?,?)";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, widgetId);
				if (((YouTubeWidget) widget).getUrl() == null ) {
					statement.setNull(2, java.sql.Types.VARCHAR);
				} else {
					statement.setString(2, ((YouTubeWidget) widget).getUrl());
				}
				
				if (((YouTubeWidget) widget).isShareable() == null ) {
					statement.setNull(3, java.sql.Types.TINYINT);
				} else {
					statement.setBoolean(3, ((YouTubeWidget) widget).isShareable());
				}
				
				if (((YouTubeWidget) widget).isExpandable() == null ) {
					statement.setNull(4, java.sql.Types.TINYINT);
				} else {
					statement.setBoolean(4, ((YouTubeWidget) widget).isExpandable());
				}
				
				result = statement.executeUpdate();				
			}
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}
	

}
