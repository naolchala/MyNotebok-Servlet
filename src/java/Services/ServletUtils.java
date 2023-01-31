/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author naol
 */
public class ServletUtils {
	public static User getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("current-user") == null) {
			return null;
		}
		
		return (User) session.getAttribute("current-user");
	}
	
	public static void showPage(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	
	
}
