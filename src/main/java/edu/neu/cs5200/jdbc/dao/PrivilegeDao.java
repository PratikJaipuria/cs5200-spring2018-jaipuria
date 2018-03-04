package edu.neu.cs5200.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.neu.cs5200.jdbc.models.Privilege;

public class PrivilegeDao {
	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static PrivilegeDao instance = null;
	public static PrivilegeDao getInstance() {
		if (instance == null) {
			instance = new PrivilegeDao();
		}
		return instance;
	}
	private PrivilegeDao() {}
	
	public void deletePagePrivilege(int developerId, int pageId, Privilege privilege) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from page_privilege where privilege = ? and pageprivilege_developer_association= ? and pageprivilege_page_association = ?";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,privilege.toString());
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
	
	public void deleteWebsitePrivilege(int developerId, int websiteId, Privilege privilege) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from website_privilege where privilege = ? and websiteprivilege_developer_association=? and websiteprivilege_website_association = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1,privilege.toString());
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
	public void assignPagePrivilege(int developerId, int pageId, Privilege privilege) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO page_privilege (privilege,pageprivilege_developer_association, pageprivilege_page_association) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,privilege.toString());
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
	public void assignWebsitePrivilege(int developerId, int websiteId, Privilege privilege) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO website_privilege (privilege,websiteprivilege_developer_association, websiteprivilege_website_association) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,privilege.toString());
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

}
