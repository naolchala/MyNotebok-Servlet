/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Models.Note;
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

/**
 *
 * @author naol
 */
public class ViewNote extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = ServletUtils.getUser(req);
			
			if (user == null) {
				resp.sendRedirect(".");
				return;
			}
			
			String id = req.getParameter("id");
			Note note = Note.findFirst(id);
			req.setAttribute("note", note);
			ServletUtils.showPage("pages/view.jsp", req, resp);
			
		} catch (SQLException ex) {
			Logger.getLogger(ViewNote.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}
