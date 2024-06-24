package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.MutualFund;

public class MutualFundDao {
			
	public static Connection connectDB() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/investmentmanagerApp?useSSL=false", "root", "Sudha@27102001");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
		
	}
	
	public static int addMutualfund(MutualFund mf ) {
		int rowcount=0;
		String query="insert into mutual_fund(userId,investment_type, principal_amount, sip_contribution, rate_of_return, holding_period) VALUES (? ,?, ?, ?, ?, ?)";
		try(Connection con = MutualFundDao.connectDB();
		PreparedStatement statement = con.prepareStatement(query))
		{
			statement.setInt(1, mf.getId());
			statement.setString(2,mf.getInvestmentType());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		return rowcount;
		
	}
}
