package edu.neu.cs5200.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.neu.cs5200.jdbc.models.Role;

public class RoleDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static RoleDao instance = null;
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	private RoleDao() {}
	
	public void deletePageRole(int developerId, int pageId, Role role) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from page_role where role = ? and pagerole_developer_association= ? and pagerole_page_association = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,role.toString());
			statement.setInt(2, developerId);
			statement.setInt(3, pageId);
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
		return;
	}
	
	public void deleteWebsiteRole(int developerId, int websiteId, Role role) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from website_role where role = ? and websiterole_developer_association=? and websiterole_website_association = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1,role.toString());
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
		return;
	}
	public void assignPageRole(int developerId, int pageId, Role role) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO page_role (role,pagerole_developer_association, pagerole_page_association) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,role.toString());
			statement.setInt(2, developerId);
			statement.setInt(3, pageId);
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
		return;
	}
	public void assignWebsiteRole(int developerId, int websiteId, Role role) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO website_role (role,websiterole_developer_association, websiterole_website_association) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,role.toString());
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
		return;
	}
	
	public Role findPageRole( int developerId, int pageId) {
		Connection connection = null;
		PreparedStatement statement = null;
		Role role=null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT role from page_role where pagerole_developer_association = ? and pagerole_page_association = ?";
			statement = connection.prepareStatement(sql);
					
			statement.setInt(1, developerId);
			statement.setInt(2, pageId);
			
			results = statement.executeQuery();
			if(results.next()) {
				String r = results.getString("role");
				role = Role.valueOf(r);
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
		return role;
	}
}
