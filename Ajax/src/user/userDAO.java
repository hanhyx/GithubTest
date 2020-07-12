package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class userDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public userDAO() {
		try {
			 String dbURL = "jdbc:mysql://localhost:3306/AJAX?serverTimezone=UTC";
			 String dbID = "root";
			 String dbPassword = "1234";
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> search(String userName){
		String SQL = "SELECT * FROM USER WHERE userName LIKE ?";
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setNString(1, userName);
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setUserAge(rs.getInt(2));
				user.setUserGender(rs.getString(3));
				user.setUserEmail(rs.getString(4));
				userList.add(user);
			}  
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		
	}
	
	
	

}
