<%@page import="java.util.ListIterator"%>
<%@page import="Models.Note"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.User"%>
<% User currentUser = (User) request.getSession().getAttribute("current-user"); %>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Add Note - NoteApp</title>
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/BoxIcons/boxicons.css" />
    </head>
    <body>
	<%@include file="../components/navbar.jsp" %>
	<main class="cards-container">
	    <a href="AddNote" class="card add-card">
		<span class="icon">
		    <i class="bx bx-plus"></i>
		</span>
		<h1>Add new note</h1>
	    </a>
	    <% 
		    ArrayList<Note> notes = (ArrayList<Note>) request.getAttribute("notes"); 
	    ListIterator<Note> noteIterator = notes.listIterator();
	    
	%>
	    
	    <% for(Note note: notes) { %>
	    <a href="ViewNote?id=<%= note.id %>" class="card">
		<h2><%= note.title %></h2>
		<p>
		    <%= note.content.length() > 200 ? note.content.substring(0, 200) : note.content %>
		</p>
		<span class="date"><%= note.createdAt.toString() %></span>
	    </a>
	    <% }%>
	</main>
	<footer>
	    <%
		    int pages = (int) request.getAttribute("page");
		    int count = (int) request.getAttribute("count");
	    %>
	    <% if (pages > 1) { %>
	    <button>
		<i class="bx bx-chevron-left"></i>
	    </button>
	    <% } %>
	    <button class="num">${requestScope["page"]}</button>
	    <% if ((pages - 1) * 10  > count) { %>
	    <button>
		<i class="bx bx-chevron-right"></i>
	    </button>
	    <% } %>
	    
	</footer>
    </body>
</html>
