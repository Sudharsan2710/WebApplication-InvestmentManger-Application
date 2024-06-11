package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserLoginRegister;
import com.model.User;

/**
 * Servlet implementation class RegisterPageServlet
 */
@WebServlet("/RegisterPageServlet")
public class RegisterPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterPageServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
				User user  = new User();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			
		
			    user.setUsername(username);
			    user.setPassword(password);
			    user.setEmail(email);
			    user.setContact(contact);
			
			
			UserLoginRegister dao = new UserLoginRegister();
			int affectedRow=dao.insertUser(user);
			if (affectedRow>0) {
				response.sendRedirect("index.jsp?status=success&message=Account created successfully");
					
			}else {
				response.sendRedirect("register.jsp?status=error&message=Account creation failed. Please try again.");

			}
				
	}

}
