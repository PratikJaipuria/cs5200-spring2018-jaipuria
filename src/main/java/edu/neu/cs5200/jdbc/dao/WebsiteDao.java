package edu.neu.cs5200.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.neu.cs5200.jdbc.models.Developer;
import edu.neu.cs5200.jdbc.models.Website;

public class WebsiteDao {
	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static WebsiteDao instance = null;
	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}
	private WebsiteDao() {}
	
	
	public int deleteWebsite(int websiteId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from website WHERE id = ?";			
			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
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

	public int updateWebsite(int websiteId, Website website) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "UPDATE website SET name=?, description=?,created=?, updated=?,visits=?"
					+ " WHERE id = ?";
			statement = connection.prepareStatement(sql);
							
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setDate(3, Date.valueOf(website.getCreated()));
			statement.setDate(4, Date.valueOf(website.getUpdated()));
			statement.setInt(5, website.getVisits());
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
	public Website findWebsiteById(int websiteId) {
		Website website = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT * from website where id = ?";
			

			statement = connection.prepareStatement(sql);
			statement.setInt(1, websiteId);
			res = statement.executeQuery();
			
			if(res.next()) {
					
				String name = res.getString("name");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer visits = res.getInt("visits");
				website = new Website(websiteId, name, description, created, updated, visits);	
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

		return website;
	}
	public Collection<Website> findWebsitesForDeveloper(int developerId){
		ArrayList<Website> websites = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String sql = "SELECT w.id, w.name, w.description, w.created, w.updated, w.visits "
					+ "FROM website w JOIN website_role r "
					+ "ON w.id = r.websiterole_website_association"
					+ " where r.websiterole_developer_association = " + Integer.toString(developerId);

			statement = connection.prepareStatement(sql);
			
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer websiteId = res.getInt("id");	
				String name = res.getString("name");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer visits = res.getInt("visits");
				websites.add(new Website(websiteId, name, description, created, updated, visits));	
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
		return websites;
	}
	public Collection<Website> findAllWebsites(){
		ArrayList<Website> websites = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM website";
			statement = connection.prepareStatement(sql);
			res = statement.executeQuery();
			
			while(res.next()) {
				Integer websiteId = res.getInt("id");	
				String name = res.getString("name");
				String description = res.getString("description");
				LocalDate created = LocalDate.parse( res.getString("created") );
				LocalDate updated = LocalDate.parse( res.getString("updated") );
				Integer visits = res.getInt("visits");
				websites.add(new Website(websiteId, name, description, created, updated, visits));
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

		
		return websites;
	}
	
	public int createWebsiteForDeveloper(int developerId, Website website) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			website.setDeveloperId(developerId);
			String sql = "INSERT INTO website (name,description, created, updated, visits) VALUES (?,?,?,?,?)";
			
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, website.getName());
			statement.setString(2, website.getDescription());
			statement.setDate(3, Date.valueOf(website.getCreated()));
			statement.setDate(4, Date.valueOf(website.getUpdated()));
			statement.setInt(5, website.getVisits());
			result = statement.executeUpdate();
			
			sql = "SELECT id FROM website WHERE name = ? and visits = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, website.getName());
			statement.setInt(2, website.getVisits());
			res = statement.executeQuery();
			Integer websiteId=null;
			if(res.next()) {
				websiteId = res.getInt("id");			
			}		
			
			sql = "INSERT INTO website_role (role,websiterole_developer_association, websiterole_website_association) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "owner");
			statement.setInt(2, developerId);
			statement.setInt(3, websiteId);
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
