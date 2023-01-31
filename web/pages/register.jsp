<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Note App - Register</title>
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/BoxIcons/boxicons.css" />
    </head>
    <body class="vh-center">
	<div class="container">
	    <h1 class="title">Register</h1>
	    <form action="register" method="post">
		<div class="form-row">
		    <div class="input-field">
			<label for="lastName">First Name</label>
			<input type="text"
			       <% if (request.getParameter("firstName") != null) {%>
			       value="<%= request.getParameter("firstName")%>"
			       <% }%>
			       id="firstName"
			       name="firstName" />

			<% if (request.getAttribute("firstName-error") != null) {%>
			<span class="error"><%= request.getAttribute("firstName-error")%></span>
			<% }%>
		    </div>
		    <div class="input-field">
			<label for="lastName">Last Name</label>
			<input type="text" 
			       <% if (request.getParameter("lastName") != null) {%>
			       value="<%= request.getParameter("lastName")%>"
			       <% }%>
			       id="lastName" name="lastName" />
		    </div>
		</div>
		<div class="input-field">
		    <label for="email">Email</label>
		    <input type="text" 
			   <% if (request.getParameter("email") != null) {%>
			   value="<%= request.getParameter("email")%>"
			   <% }%>
			   id="email" 
			   name="email" />
		    <% if (request.getAttribute("email-error") != null) {%>
		    <span class="error"><%= request.getAttribute("email-error")%></span>
		    <% }%>
		</div>

		<div class="form-row">
		    <div class="input-field">
			<label for="password">Password</label>
			<input type="password"  id="password" name="password" />
			<% if (request.getAttribute("password-error") != null) {%>
			<span class="error"><%= request.getAttribute("password-error")%></span>
			<% }%>
		    </div>
		    <div class="input-field">
			<label for="confirmPassword">Confirm Password</label>
			<input
				type="password"
				id="confirmPassword"
				name="confirmPassword"
				/>
		    </div>
		</div>

		<button type="submit" class="login-btn">Create Account</button>
		<a href="." class="create-link">
		    Already have an Account?
		</a>
	    </form>
	</div>
    </body>
</html>
