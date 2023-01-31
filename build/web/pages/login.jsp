<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Note App - Login</title>
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/BoxIcons/boxicons.css" />
    </head>
    <body class="vh-center">
	<div class="container">
	    <h1 class="title">Login</h1>
	    <form action="Login" method="post">
		<div class="input-field">
		    <label for="email">Email</label>
		    <input type="text" id="email" name="email" />
		    <% if (request.getAttribute("email-error") != null)  { %>
		    <span class="error"><%= request.getAttribute("email-error")%></span>
		    <% } %>
		</div>
		<div class="input-field">
		    <label for="password">Password</label>
		    <input type="password" id="password" name="password" />
		    <% if (request.getAttribute("password-error") != null) {
				    String err = (String) request.getAttribute("password-error");
		    %>
		    <span class="error"> <%= err%> </span>
		    <% }%>
		</div>
		<button type="submit" class="login-btn">Login</button>
		<a href="register" class="create-link">Create Account</a>
	    </form>
	</div>
    </body>
</html>
