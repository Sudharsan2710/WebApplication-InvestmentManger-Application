package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.Gold;

public class GoldinvestmentDao {
	public static Connection connectDB() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/investmentmanagerApp?useSSL=false",
					"root", "Sudha@27102001");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static int addgoldrate(Gold gold) throws SQLException {

		int rowcount = 0;
		String query = "INSERT INTO gold_investments (user_id,gold_rate,investment_amount_Gold, grams_purchased ) VALUES (?, ?, ?, ?)";
		
		try (Connection con =GoldinvestmentDao .connectDB(); 
			PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, gold.getUserId());
			pst.setDouble(2, gold.getGoldRate());
			pst.setDouble(3, gold.getInvestmentAmountGold());
			pst.setDouble(4, gold.getGramsPurchased());
			rowcount = pst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return rowcount;
	}
}
