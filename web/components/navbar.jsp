<%-- 
    Document   : navbar
    Created on : Jan 30, 2023, 9:46:33 AM
    Author     : naol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.User" %>
<% User user = (User) request.getSession().getAttribute("current-user");%>
<nav class="navbar">
    
    <h1><a href=".">MyNotebook</a></h1>  
    
    <div class="profile">
	<div class="info">
	    <h2><%= user.firstName + " " + user.lastName%></h2>
	    <span><%= user.email%></span>
	</div>
	<a href="Logout" class="logout-btn">
	    <i class="bx bx-log-out bx-flip-horizontal"></i>
	</a>
    </div>
</nav>