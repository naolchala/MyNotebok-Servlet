<%@page import="java.time.LocalDate"%>
<%@page import="Models.Note"%>
<%@page import="java.text.DateFormatSymbols"%>
<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>View - NoteApp</title>
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/BoxIcons/boxicons.css" />
    </head>
    <body>
	<%@include file="../components/navbar.jsp" %>
	<% 
		Note note = (Note) request.getAttribute("note");
		LocalDate date = note.createdAt.toLocalDate();
		String month = date.getMonth().name().substring(0, 3);	
	%>
	
	<main class="view-container">
	    <header>
		<div class="title">
		    <h1><%= note.title %></h1>
		    <span>Created on <%= month + "  " + date.getDayOfMonth() + ", " + date.getYear() %></span>
		</div>
		<div class="actions">
		    <a href="Edit?id=<%= note.id%>" class="edit-btn">Edit</a>
		    <a href="Delete?id=<%= note.id%>" class="delete-btn">Delete</a>
		</div>
	    </header>
	    <article>
		<p>
		    <%= note.content %>
		</p>
	    </article>
	</main>
    </body>
</html>
