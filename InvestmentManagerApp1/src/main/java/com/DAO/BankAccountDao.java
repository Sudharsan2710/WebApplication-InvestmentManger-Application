package com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.model.BankAccountDetails;

public class BankAccountDao {

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

    public static int addbankac(BankAccountDetails bd) throws SQLException {
        int rowcount = 0;
        String query = "INSERT INTO Bank_Accounts (user_id,bank_name, user_pan, account_number, account_type, amountinvesting) VALUES (?,?, ?, ?, ?,?)";
        try (Connection con = BankAccountDao.connectDB(); PreparedStatement pst = con.prepareStatement(query)) {
        		pst.setInt(1, bd.getUserId());
              pst.setString(2, bd.getBankname());
              pst.setString(3, bd.getPan());
              pst.setString(4, bd.getAcNum());
              pst.setString(5, bd.getAccountType());
              pst.setDouble(6, bd.getAmountInvesting());
            		  
              rowcount = pst.executeUpdate();
         
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; 
        }
        return rowcount;
    }

    public static ArrayList<BankAccountDetails> viewBankAccount() throws SQLException {
        ArrayList<BankAccountDetails> list = new ArrayList<>();
        String query = "SELECT bank_name, user_pan, account_number, account_type, amountinvesting FROM Bank_Accounts WHERE user_id = ?";
        try (Connection con = BankAccountDao.connectDB(); PreparedStatement pst = con.prepareStatement(query)) {
        	  BankAccountDetails details = new BankAccountDetails();
        	pst.setInt(1, details.getUserId());
        
        		ResultSet rs = pst.executeQuery();
            while (rs.next()) {
              
                details.setBankname(rs.getString("bank_name"));
                details.setPan(rs.getString("user_pan"));
                details.setAcNum(rs.getString("account_number"));
                details.setAccountType(rs.getString("account_type"));
                details.setAmountInvesting(rs.getDouble("amountinvesting"));
                list.add(details);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex; // Rethrow exception to handle it properly
        }
        return list;
    }
        
        
}