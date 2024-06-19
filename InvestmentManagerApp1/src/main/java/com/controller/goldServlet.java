package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.GoldinvestmentDao;
import com.model.Gold;
import com.model.User;

@WebServlet("/goldServlet")
public class goldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private GoldinvestmentDao goldinvestment = new GoldinvestmentDao();
    public goldServlet() {
        super();

    }

    	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		double goldrate = Double.parseDouble(request.getParameter("gold_rate"));
		int user=Integer.parseInt(request.getParameter("user_id"));
		double investmentamountgold=Double.parseDouble(request.getParameter("investment_amount_gold"));
		
		
		HttpSession session = request.getSession();
		  User currentUser = (User) session.getAttribute("currentUser");

	        if (currentUser != null) {
	            int userId = currentUser.getUserid();
	   
		
		
		  if (investmentamountgold < goldrate) {
	            response.getWriter().write("Error: Investment amount must be greater than or equal to today's gold rate.");
	            return;
	        }
		  	
		  
		  double gramsPurchased = investmentamountgold / goldrate;
		
		  if (gramsPurchased < 1 || gramsPurchased > 4000) {
	            response.getWriter().write("Error: Investment amount should purchase between 1 gram to 4 kilograms of gold.");
	            return;
	        }
		
		  Gold gold = new Gold();
		   gold.setUserId(user);
	       gold.setGoldRate(goldrate);
	       gold.setInvestmentAmountGold(investmentamountgold);
	       gold.setGramsPurchased(gramsPurchased);
	       
	       
	       try {
			int row = GoldinvestmentDao.addgoldrate(gold);
			if(row > 0 ) {
				  response.sendRedirect("index1.jsp");
				  response.getWriter().write("Investment successful. Grams of gold purchased: " + gramsPurchased);
            } else {
                response.sendRedirect("account.jsp?error=Failed to add");
            }
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			 response.sendRedirect("goldcalculation.jsp?error=Database error");
		
		}
	        }else {
	        	 response.sendRedirect("login.jsp");
			
		}
	       

	}

}
