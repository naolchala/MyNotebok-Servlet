/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Exceptions.IncorrectPasswordException;
import Exceptions.UserNotFoundException;
import Models.User;
import Services.ServletUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author naol
 */
public class Login extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		User user = ServletUtils.getUser(request);
		if (user == null) {
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("pages/home.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String email = request.getParameter("email");
		String password=  request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			User current = User.login(email, password);
			session.setAttribute("current-user", current);
			response.sendRedirect(".");
			
		} catch (SQLException ex) {
			Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UserNotFoundException ex) {
			request.setAttribute("email-error", ex.getMessage());
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		} catch (IncorrectPasswordException ex) {
			request.setAttribute("password-error", ex.getMessage());
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

}
