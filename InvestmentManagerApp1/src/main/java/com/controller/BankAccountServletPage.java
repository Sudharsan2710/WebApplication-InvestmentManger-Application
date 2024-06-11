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


@WebServlet("/BankAccountServletPage")
public class BankAccountServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BankAccountServletPage() {
		super();
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		BankAccountDetails details = new BankAccountDetails();
		String bankname = request.getParameter("bankname");
		String pan = request.getParameter("pan");
		String acNum = request.getParameter("acNum");
		String accountType = request.getParameter("accountType");
		  String amountInvestingStr = request.getParameter("amountinvesting");
		 double amountinvesting = 0;
		

		details.setBankname(bankname);
		details.setPan(pan);
		details.setAcNum(acNum);
		details.setAccountType(accountType);
		details.setAmountInvesting(amountinvesting);

		session.setAttribute("bankAccountDetails", details);

		BankAccountDao bank = new BankAccountDao();
		try {
			int affectedrow = BankAccountDao.addbankac(details);
			if (affectedrow > 0) {
				response.sendRedirect("index1.jsp");
			} else {
				response.sendRedirect("account.jsp");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			 response.sendRedirect("account.jsp");
		}

		 // Check if amountinvesting is not null or empty
       if (amountInvestingStr != null && !amountInvestingStr.trim().isEmpty()) {
           try {
               amountinvesting = Double.parseDouble(amountInvestingStr);
           } catch (NumberFormatException e) {
               e.printStackTrace();
               // Handle invalid number format
               response.sendRedirect("index1.jsp");
               return;
           }
       } else {
           // Handle missing amountinvesting parameter
           response.sendRedirect("account.jsp");
           return;
       }

	}

}
