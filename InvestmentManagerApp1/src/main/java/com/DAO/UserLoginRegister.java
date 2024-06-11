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
		
		int rowcount = 0;
		try {

			con = DbConnection.createConnection();
			String query = "insert into Users(username,password,email,contact) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getContact());
			rowcount = pst.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return rowcount;

	}

	public boolean userLogin(String username, String password) {
		User user = new User();
		boolean isValidUser = false;
		try {

			Connection con = DbConnection.createConnection();
			String query = "SELECT email, password FROM Users WHERE username=?";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String dbPassword = rs.getString("password");
				if (dbPassword.equals(password)) {
					isValidUser = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValidUser;

	}

}
