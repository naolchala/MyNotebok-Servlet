
package Models;

import Services.DBConnector;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Note {

	public String id;
	public String title;
	public String content;
	public Date createdAt;
	public String userId;

	public Note(String title, String content, String userId) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.content = content;
		this.createdAt = Date.valueOf(LocalDate.now());
		this.userId = userId;
	}

	public Note(String id, String title, String content,  String userId) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.content = content;
		this.createdAt = Date.valueOf(LocalDate.now());
		this.userId = userId;
	}

	public Note(ResultSet rs) throws SQLException {
		this.id = rs.getString("id");
		this.title = rs.getString("title");
		this.content = rs.getString("content");
		this.createdAt = rs.getDate("createdAt");
		this.userId = rs.getString("userId");
	}

	public void save() throws SQLException {
		String sql = "INSERT INTO Note"
			+ "(id, title, content, createdAt, userId)"
			+ "VALUES"
			+ "(?, ?, ?, ?, ?)";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, id);
		stmt.setString(2, title);
		stmt.setString(3, content);
		stmt.setDate(4, createdAt);
		stmt.setString(5, userId);
		
		stmt.executeUpdate();
	}

	public static ArrayList<Note> findMany(User user, int page) throws SQLException {
		ArrayList<Note> notes = new ArrayList<>();
		int take = 10;
		int offset = (page - 1) * take;

		String sql = "SELECT * FROM Note WHERE userId=? ORDER BY createdAt ASC LIMIT ?, ?";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, user.id);
		stmt.setInt(2, offset);
		stmt.setInt(3, take);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Note note = new Note(rs);
			notes.add(note);
		}

		return notes;
	}

	public static Note findFirst(String id) throws SQLException {
		Note note = null;
		String sql = "SELECT * FROM Note WHERE id=?";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			note = new Note(rs);
		}
		return note;
	}
	public void delete() throws SQLException {
		delete(this.id);
	}
	
	public static void delete(String id) throws SQLException {
		String sql = "DELETE FROM Note WHERE id=?";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, id);
		stmt.executeUpdate();
	}
	
	public static int count(User user) throws SQLException {
		String sql = "SELECT COUNT(*) from Note WHERE userId=?";
		PreparedStatement stmt = DBConnector.getStmt(sql);
		stmt.setString(1, user.id);
		ResultSet rs = stmt.executeQuery();
		
		int count = 0;
		if (rs.next()) {
			count = rs.getRow();
		}
		
		return count;
	}

}
