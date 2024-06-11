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
			
			HttpSession session = request.getSession();
			
			UserLoginRegister dao = new UserLoginRegister();
		        boolean isValidUser = dao.userLogin(username, password);
			
		       
		        session.setAttribute("username", username);
			
		        if (isValidUser) {
		           
		            response.sendRedirect("index1.jsp");
		        } else {
		           
		            response.sendRedirect("register.jsp?error=Invalid credentials");
		        }
		    }
	}


