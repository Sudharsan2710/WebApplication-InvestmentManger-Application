package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserLoginRegister;
import com.model.User;

/**
 * Servlet implementation class LoginPageServlet
 */
@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
			String username=request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String contact=request.getParameter("contact");
			
			
			
			
			UserLoginRegister ulr = new UserLoginRegister();
		        User user = ulr.userLogin(email, password);
			
		       
		       
			
		        if (user != null) {
		        	 HttpSession session = request.getSession();
		        	 session.setAttribute("currentUser", user);
		        	 session.setAttribute("username", user.getUsername());
		        	 session.setAttribute("contact", user.getContact() );
		            response.sendRedirect("index1.jsp");
		        } else {
		           
		            response.sendRedirect("login.jsp?error=Invalid credentials");
		        }
		    }
	}


