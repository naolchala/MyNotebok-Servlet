/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

	static Connection conn;

	static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NoteApp", "root", "");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Connection getConn() {
		if (conn == null) {
			connect();
		}
		return conn;
	}
	
	public static PreparedStatement getStmt(String sql) throws SQLException{
		return getConn().prepareStatement(sql);
	}
	
	
}
