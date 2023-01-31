/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Models.Note;
import Models.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author naol
 */
public class AddNote extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		if (request.getSession().getAttribute("current-user") == null) {
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("pages/add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		if (request.getSession().getAttribute("current-user") == null) {
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
			return;
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User currentUser = (User) request.getSession().getAttribute("current-user");
		
		try {
			Note newNote = new Note(title, content, currentUser.id);
			newNote.save();
			
			response.sendRedirect(".");
		} catch (SQLException ex) {
			Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	

}
