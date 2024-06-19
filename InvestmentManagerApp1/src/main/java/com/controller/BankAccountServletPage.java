package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BankAccountDao;
import com.model.BankAccountDetails;
import com.model.User;


@WebServlet("/BankAccountServletPage")
public class BankAccountServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BankAccountServletPage() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	
		String bankname = request.getParameter("bankName");
		String pan = request.getParameter("userPan");
		String acNum = request.getParameter("accountNumber");
		String accountType = request.getParameter("accountType");
		double amountInvesting = Double.parseDouble(request.getParameter("amountInvesting"));
		 
		  HttpSession session = request.getSession();
	        User currentUser = (User) session.getAttribute("currentUser");

	        if (currentUser != null) {
	            int userId = currentUser.getUserid();

	            BankAccountDetails bankAccountDetails = new BankAccountDetails();
	            bankAccountDetails.setUserId(userId);
	            bankAccountDetails.setBankname(bankname);
	            bankAccountDetails.setPan(pan);
	            bankAccountDetails.setAcNum(acNum);
	            bankAccountDetails.setAccountType(accountType);
	            bankAccountDetails.setAmountInvesting(amountInvesting);

	            try {
	                int rowCount = BankAccountDao.addbankac(bankAccountDetails);
	                if (rowCount > 0) {
	                    response.sendRedirect("index1.jsp");
	                } else {
	                    response.sendRedirect("account.jsp?error=Failed to link bank account");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                response.sendRedirect("account.jsp?error=Database error");
	            }
	        } else {
	            response.sendRedirect("login.jsp");
	        }
	    }
	}