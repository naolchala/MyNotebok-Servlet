package Servlets;

import Models.Note;
import Models.User;
import Services.ServletUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			if (ServletUtils.getUser(request) == null) {
				request.getRequestDispatcher("pages/login.jsp").forward(request, response);
				return;
			}
			User user = ServletUtils.getUser(request);
			int count = Note.count(user);
			int page = request.getParameter("page") != null 
				? Integer.parseInt(request.getParameter("page")) : 1;
			
			if ( (page - 1) * 10 > count) {
				page = Math.floorDiv(count, 10) + 1;
			}
			
			ArrayList<Note> notes = Note.findMany(user, page);
			

			request.setAttribute("page", page);
			request.setAttribute("count", count);
			request.setAttribute("notes", notes);
			request.getRequestDispatcher("pages/home.jsp").forward(request, response);

		} catch (SQLException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

	}

}
