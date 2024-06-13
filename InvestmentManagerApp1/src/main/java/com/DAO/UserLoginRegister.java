package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Util.DbConnection;
import com.model.User;

public class UserLoginRegister implements UserInterface {
	static Connection con;

	public int insertUser(User u) {
		User user = new User();
		int generatedUserId = -1;
		
		try {

			con = DbConnection.createConnection();
			String query = "insert into Users(username,password,email,contact) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getContact());
			int rowcount = pst.executeUpdate();

			if (rowcount > 0) {
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next()) {
					generatedUserId = rs.getInt(1);
					u.setUserid(generatedUserId);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return generatedUserId;
	}

	public User userLogin(String email, String password) {
		User user = null;
		
		try {

			Connection con = DbConnection.createConnection();
			 String query = "SELECT * FROM Users WHERE email=?";
	            PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String dbPassword = rs.getString("password");
				if (dbPassword.equals(password)) {
					  int userid = rs.getInt("user_id");
		               
		                String username=rs.getString("username");
		                
		                user = new User();
		                user.setUserid(userid);
		                user.setUsername(username);
		             
		                user.setPassword(dbPassword);
		                user.setEmail(email);
				
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}
	
	

}
