package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Util.DbConnection;

import com.model.BankAccountDetails;

public class BankAccountDao {

	public static Connection connectDB() {

		Connection connection = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/investmentmanagerApp?useSSL=false",
					"root", "Sudha@27102001");
		}

		catch (Exception message) {
			System.out.println(message);
		}
		return connection;
	}
	
	
	
	public static int addbankac(BankAccountDetails bd) throws SQLException {
		
		
		int rowcount = 0;
		try {
			Connection con = BankAccountDao.connectDB();
			String query = "insert into Bank_Accounts (bank_name, user_pan, account_number, account_type,amountinvesting)values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			pst.setString(1, bd.getBankname());
			pst.setString(2, bd.getPan());
			pst.setString(3, bd.getAcNum());
			pst.setString(4, bd.getAccountType());
			pst.setDouble(5, bd.getAmountInvesting());
			rowcount = pst.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rowcount;
	}
	
	

	public static ArrayList<BankAccountDetails> viewBankAccount() throws SQLException, ClassNotFoundException {
		ArrayList<BankAccountDetails> list = new ArrayList<>();
		BankAccountDetails details = null;

		try(Connection con = BankAccountDao.connectDB();) {
			
			String query = "SELECT bank_name, user_pan, account_number, account_type, amountinvesting FROM Bank_Accounts ";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				details = new BankAccountDetails();
				details.setBankname(rs.getString("bank_name"));
				details.setPan(rs.getString("user_pan"));
				details.setAcNum(rs.getString("account_number"));
				details.setAccountType(rs.getString("account_type"));
				details.setAmountInvesting(rs.getDouble("amountinvesting"));
				list.add(details);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return list;
	}
}
