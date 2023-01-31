/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Models.Note;
import Models.User;
import Services.ServletUtils;
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
public class Delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = ServletUtils.getUser(req);
		
		if (user == null) {
			resp.sendRedirect(".");
			return;
		}
		
		if (id != null ) {
			try {
				Note.delete(id);
			} catch (SQLException ex) {
				Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
		resp.sendRedirect(".");
	}

	
}
