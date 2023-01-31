
package Models;

import Exceptions.EmailTakenException;
import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import Services.DBConnector;
import java.util.UUID;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
	public String id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	
	public User(String firstName, String lastName, String email, String password) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public User(String id, String firstName, String lastName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public User(ResultSet rs) throws SQLException {
		this.id = rs.getString("id");
		this.firstName = rs.getString("firstName");
		this.lastName = rs.getString("lastName");
		this.email = rs.getString("email");
		this.password = rs.getString("password");
	}
	
	public void create() throws EmailTakenException {
		try {
			String sql;
			sql = "SELECT * FROM User WHERE email=?";
			PreparedStatement stmt =  DBConnector.getStmt(sql);
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next())	{
				throw new EmailTakenException();
			}
			
			
			sql = "INSERT INTO User"
				+ "(id, firstName, lastName, email, password)"
				+ "VALUES "
				+ "(?,?,?,?,?)";
			
			stmt = DBConnector.getStmt(sql);
			stmt.setString(1, id);
			stmt.setString(2, firstName);
			stmt.setString(3, lastName);
			stmt.setString(4, email);
			stmt.setString(5, password);
			stmt.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static User login(String email, String password) throws SQLException, UserNotFoundException, IncorrectPasswordException {
		String sql = "SELECT * FROM User WHERE email=?";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		
		if (!rs.next()) {
			throw new UserNotFoundException();
		}
		
		User user = new User(rs);
		
		if (!password.equals(user.password)) {
			throw new IncorrectPasswordException();
		}
		
		return user;
	}
	
}
