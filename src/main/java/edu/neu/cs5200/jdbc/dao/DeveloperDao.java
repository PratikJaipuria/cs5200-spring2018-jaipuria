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

import edu.neu.cs5200.jdbc.models.Address;
import edu.neu.cs5200.jdbc.models.Developer;
import edu.neu.cs5200.jdbc.models.Phone;
import edu.neu.cs5200.jdbc.models.User;

public class DeveloperDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/hw2_jaipuria_pratik_spring_2018?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	public static DeveloperDao instance = null;
	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}
	private DeveloperDao() {}
	
	public int deleteDeveloper(int developerId) {
		Connection connection = null;
		PreparedStatement statementDev = null;
		PreparedStatement statementPer = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlPerson = "DELETE from person WHERE id = ?";
			statementPer = connection.prepareStatement(sqlPerson);
			
			String sql = "SELECT * FROM developer WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			res = statement.executeQuery();
			Integer personId=null;
			
			if(res.next()) {
				personId = res.getInt("developer_person_generalization");				
			}		
					
			statementPer.setInt(1, personId);
			result = statementPer.executeUpdate();
					
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
	public int updateDeveloper(int developerId, Developer developer) {
		Connection connection = null;
		PreparedStatement statementDev = null;
		PreparedStatement statementPer = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlDeveloper = "UPDATE developer SET developerKey=? WHERE id = ?";
			String sqlPerson = "UPDATE person SET firstName=?, lastName=?,username=?, password=?,email=?, dob=? WHERE id = ?";
			statementDev = connection.prepareStatement(sqlDeveloper);
			statementPer = connection.prepareStatement(sqlPerson);
			
			String sql = "SELECT * FROM developer WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			res = statement.executeQuery();
			Integer personId=null;
			
			if(res.next()) {
				personId = res.getInt("developer_person_generalization");				
			}		
			statementDev.setString(1, developer.getDeveloperKey());
			statementDev.setInt(2, developerId);
			result = statementDev.executeUpdate();
					
			statementPer.setString(1, developer.getFirstName());
			statementPer.setString(2, developer.getLastName());
			statementPer.setString(3, developer.getUsername());
			statementPer.setString(4, developer.getPassword());
			statementPer.setString(5, developer.getEmail());
			statementPer.setDate(6, Date.valueOf(developer.getDob()));
			statementPer.setInt(7, personId);
			result = statementPer.executeUpdate();
					
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

	public Developer findDeveloperByCredentials(String username, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statementDev = null;
		ResultSet results = null;
		ResultSet res = null;
		Developer dev = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "SELECT * FROM person where username = ? and password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			results = statement.executeQuery();
			if(results.next()) {
				
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String userName = results.getString("username");
				String passWord = results.getString("password");
				String email = results.getString("email");
				LocalDate dob = LocalDate.parse( results.getString("dob") );
				int id = results.getInt("id");
				
				String sqlPerson = "SELECT * FROM developer WHERE developer_person_generalization = ?";
				statementDev = connection.prepareStatement(sqlPerson);
				statementDev.setInt(1, id);
				res = statementDev.executeQuery();
				
				if(res.next()) {
					String developerKey = res.getString("developerKey");
					int devId = res.getInt("id");
					
					dev = new Developer(id, firstName, lastName, userName, password,
											email,dob,devId,developerKey);
				}				 
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

		return dev;
	}

	public Developer findDeveloperByUsername(String username) {
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statementDev = null;
		ResultSet results = null;
		ResultSet res = null;
		Developer dev = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "SELECT * FROM person where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			results = statement.executeQuery();
			LocalDate dob=null;
			if(results.next()) {
				
				String firstName = results.getString("firstName");
				String lastName = results.getString("lastName");
				String userName = results.getString("username");
				String password = results.getString("password");
				String email = results.getString("email");
				if(results.getString("dob") !=null)
					dob = LocalDate.parse( results.getString("dob") );
				
				int id = results.getInt("id");
				
				String sqlPerson = "SELECT * FROM developer WHERE developer_person_generalization = ?";
				statementDev = connection.prepareStatement(sqlPerson);
				statementDev.setInt(1, id);
				res = statementDev.executeQuery();
				
				if(res.next()) {
					String developerKey = res.getString("developerKey");
					int devId = res.getInt("id");
					
					dev = new Developer(id, firstName, lastName, userName, password,
											email,dob,devId,developerKey);
				}				 
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

		return dev;
	}

	
	public Developer findDeveloperById(int developerId) {
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statementPer = null;
		ResultSet results = null;
		ResultSet res = null;
		Developer dev = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "SELECT * FROM developer where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, developerId);
			results = statement.executeQuery();
			while(results.next()) {
				int id = results.getInt("id");
				String developerKey = results.getString("developerKey");
				int personId = results.getInt("developer_person_generalization");
				
				String sqlPerson = "SELECT * FROM person WHERE id = ?";
				statementPer = connection.prepareStatement(sqlPerson);
				statementPer.setInt(1, personId);
				res = statementPer.executeQuery();
				
				if(res.next()) {
					String firstName = res.getString("firstName");
					String lastName = res.getString("lastName");
					String userName = res.getString("username");
					String password = res.getString("password");
					String email = res.getString("email");
					LocalDate dob = LocalDate.parse( results.getString("dob") );
					
					dev =new Developer(personId, firstName, lastName, userName, password,
											email,dob,id,developerKey);
				}				 
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

		return dev;
	}
	
	
	
	public Collection<Developer> findAllDevelopers(){
		Collection<Developer> devList = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		PreparedStatement statementPer = null;
		ResultSet results = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM developer";
			results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("id");
				String developerKey = results.getString("developerKey");
				int personId = results.getInt("developer_person_generalization");
				
				String sqlPerson = "SELECT * FROM person WHERE id = ?";
				statementPer = connection.prepareStatement(sqlPerson);
				statementPer.setInt(1, personId);
				res = statementPer.executeQuery();
				
				if(res.next()) {
					String firstName = res.getString("firstName");
					String lastName = res.getString("lastName");
					String userName = res.getString("username");
					String password = res.getString("password");
					String email = res.getString("email");
					LocalDate dob = LocalDate.parse( results.getString("dob") );
					
					devList.add(new Developer(personId, firstName, lastName, userName, password,
											email,dob,id,developerKey));
				}				 
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
		return devList;
	}


	public int createDeveloper(Developer developer) {
		
		Connection connection = null;
		PreparedStatement statementDev = null;
		PreparedStatement statementPer = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlDeveloper = "INSERT INTO developer (developerKey,developer_person_generalization) VALUES (?,?)";
			String sqlPerson = "INSERT INTO person (firstName, lastName,username, password,email, dob) VALUES (?,?,?,?,?,?)";
			statementDev = connection.prepareStatement(sqlDeveloper);
			statementPer = connection.prepareStatement(sqlPerson);
			
			statementPer.setString(1, developer.getFirstName());
			statementPer.setString(2, developer.getLastName());
			statementPer.setString(3, developer.getUsername());
			statementPer.setString(4, developer.getPassword());
			statementPer.setString(5, developer.getEmail());
			statementPer.setDate(6, Date.valueOf(developer.getDob()));
			result = statementPer.executeUpdate();
			
			String sql = "SELECT id FROM person WHERE username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, developer.getUsername());
			res = statement.executeQuery();
			Integer personId=null;
			if(res.next()) {
				personId = res.getInt("id");			
			}		
			
			statementDev.setString(1, developer.getDeveloperKey());
			statementDev.setInt(2, personId);
			
			result = statementDev.executeUpdate();
			
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
	
public int createUser(User user) {
		
		Connection connection = null;
		PreparedStatement statementUsr = null;
		PreparedStatement statementPer = null;
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sqlUser = "INSERT INTO user (userAgreement,user_person_generalization) VALUES (?,?)";
			String sqlPerson = "INSERT INTO person (firstName, lastName,username, password,email, dob) VALUES (?,?,?,?,?,?)";
			statementUsr = connection.prepareStatement(sqlUser);
			statementPer = connection.prepareStatement(sqlPerson);
			
			statementPer.setString(1, user.getFirstName());
			statementPer.setString(2, user.getLastName());
			statementPer.setString(3, user.getUsername());
			statementPer.setString(4, user.getPassword());
			statementPer.setString(5, user.getEmail());
			statementPer.setDate(6, Date.valueOf(user.getDob()));
			result = statementPer.executeUpdate();
			
			String sql = "SELECT id FROM person WHERE username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			res = statement.executeQuery();
			Integer personId=null;
			if(res.next()) {
				personId = res.getInt("id");			
			}		
			
			statementUsr.setBoolean(1, user.isUserAgreement());
			statementUsr.setInt(2, personId);
			
			result = statementUsr.executeUpdate();
			
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
	
	public int updatePhonebyUsername(String username, Phone phone) {
		Connection connection = null;
		
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE phone set phone = ? where `primary` = ? and (phone_person_composition = (select id from person where username = ?));";
			statement = connection.prepareStatement(sql);
								
			statement.setString(1, phone.getPhone());
			statement.setBoolean(2, phone.isPrimary());
			statement.setString(3, username);
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
	
	public int updateAddressbyUsername(String username, Address address) {
		Connection connection = null;
		
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE address set street1 = ? and street2 = ? and city = ? and state = ? and zip = ? where `primary` = ? and (address_person_composition = (select id from person where username = ?));";
			statement = connection.prepareStatement(sql);
								
			statement.setString(1, address.getStreet1());
			statement.setString(2, address.getStreet2());
			statement.setString(3, address.getCity());
			statement.setString(4, address.getState());
			statement.setString(5, address.getZip());
			statement.setBoolean(6, address.isPrimary());
			statement.setString(7, username);
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
	
	public Collection<Address> findAllAddressByPersonId(Integer personId){
		Collection<Address> addresses = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement statementPer = null;
		ResultSet results = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM address where address_person_composition =" + personId;
			results = statement.executeQuery(sql);
			while(results.next()) {
				int id = results.getInt("id");
				String street1 = results.getString("street1");
				String street2 = results.getString("street2");
				String city = results.getString("city");
				String state = results.getString("state");
				String zip = results.getString("zip");
				Boolean primary = results.getBoolean("primary");
								
				addresses.add(new Address(id, street1, street2, city, state,zip, primary,personId));
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
		return addresses;
	}

	public int deleteAddress(Address address) {
		Connection connection = null;		
		PreparedStatement statement = null;
		int result = 0;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE from address where id = ?;";
			statement = connection.prepareStatement(sql);								
			statement.setInt(1, address.getAddressId());
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
