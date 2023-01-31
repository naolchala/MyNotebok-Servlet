/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Exceptions.EmailTakenException;
import Models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author naol
 */
public class Register extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		request.getRequestDispatcher("pages/register.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		boolean error = false;
		
		if (firstName == null || firstName.isEmpty()) {
			request.setAttribute("firstName-error", "Please provide your first name");
			error = true;
		}
		
		if (email.isEmpty()) {
			request.setAttribute("email-error", "Please provide your email");
			error = true;
		}
		
		if (password.isEmpty()) {
			request.setAttribute("password-error", "Please provide your password");
			error = true;
		}
		
		if (!password.equals(confirmPassword)) {
			request.setAttribute("password-error", "Passwords don't match");
			error = true;
		}
		
		if (error) {
			request.getRequestDispatcher("pages/register.jsp").forward(request, response);
			return;
		}
		
		
		try {
			HttpSession session = request.getSession();
			
			User newUser = new User(firstName, lastName, email, password);
			newUser.create();
			
			session.setAttribute("current-user", newUser);
			response.sendRedirect(".");
			
		} catch (EmailTakenException ex) {
			request.setAttribute("email-error", ex.getMessage());
		}
	}

	
}
