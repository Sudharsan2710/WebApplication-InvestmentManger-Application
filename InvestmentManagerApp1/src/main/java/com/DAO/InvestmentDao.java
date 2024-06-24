package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.BankAccountDetails;
import com.model.Investment;

public class InvestmentDao {
	  public static Connection connectDB() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/investmentmanagerApp?useSSL=false", "root", "Sudha@27102001");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	  public static int addinvestment(Investment iv) throws SQLException {
	        int rowcount = 0;
	        String query = "INSERT INTO investment (user_id,Investment_Types, amount, date_of_investment) VALUES (?, ?, ?, ?)";
	        try (Connection con = BankAccountDao.connectDB();
	        	PreparedStatement pst = con.prepareStatement(query)) {
	        	BankAccountDetails bd=new BankAccountDetails();
	        	pst.setInt(1, iv.getUserId());
	        	pst.setInt(2, iv.getInvestmenttype());
	        	pst.setInt(3, iv.getAmount());
	        	pst.setDate(4, iv.getDate());
	        	
	            		  
	              rowcount = pst.executeUpdate();
	         
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw ex; 
	        }
	        return rowcount;
	    }
}
