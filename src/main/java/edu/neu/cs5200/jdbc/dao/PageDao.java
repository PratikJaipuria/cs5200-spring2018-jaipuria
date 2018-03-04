package edu.neu.cs5200.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.neu.cs5200.jdbc.models.Page;
import edu.neu.cs5200.jdbc.models.Website;

public class PageDao {

	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static PageDao instance = null;
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}
	private PageDao() {}
	
	public int deletePage(int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from page WHERE id = ?";			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
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
	public int updatePage(int pageId, Page page) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "UPDATE page SET title=?, description=?,created=?, updated=?,views=?,page_website_composition=?"
					+ " WHERE id = ?";
			statement = connection.prepareStatement(sql);
							
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setDate(3, Date.valueOf(page.getCreated()));
			statement.setDate(4, Date.valueOf(page.getUpdated()));
			statement.setInt(5, page.getViews());
			statement.setInt(6, page.getWebsiteId());
			statement.setInt(7, pageId);
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
	public Collection<Page> findPagesForWebsite(int websiteId){
		ArrayList<Page> pages = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * from page where page_website_composition = ?";
			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer pageId = res.getInt("id");	
				String title = res.getString("title");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer views = res.getInt("views");
				pages.add(new Page(pageId, title, description, created, updated, views,websiteId));	
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
		return pages;

	}
	public Page findPageById(int pageId) {
		Page page = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * from page where id = ?";
			

			statement = connection.prepareStatement(sql);
			statement.setInt(1, pageId);
			res = statement.executeQuery();
			
			if(res.next()) {
					
				String title = res.getString("title");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer views = res.getInt("views");
				Integer websiteId = res.getInt("page_website_composition");
				page = new Page(pageId, title, description, created, updated, views,websiteId);	
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

		return page;

	}
	public Collection<Page> findAllPages(){
		ArrayList<Page> pages = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM page";
			statement = connection.prepareStatement(sql);
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer pageId = res.getInt("id");	
				String title = res.getString("title");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer views = res.getInt("views");
				Integer websiteId = res.getInt("page_website_composition");
				pages.add(new Page(pageId, title, description, created, updated, views, websiteId));
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


		return pages;
	}
	public int createPageForWebsite(int websiteId, Page page) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "INSERT INTO page (title,description, created, updated, views, page_website_composition) VALUES (?,?,?,?,?,?)";
			
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, page.getTitle());
			statement.setString(2, page.getDescription());
			statement.setDate(3, Date.valueOf(page.getCreated()));
			statement.setDate(4, Date.valueOf(page.getUpdated()));
			statement.setInt(5, page.getViews());
			statement.setInt(6, websiteId);
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
}
