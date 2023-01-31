<!DOCTYPE html>
<html lang="en">
    <head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Home - NoteApp</title>
	<link rel="stylesheet" href="css/fonts.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/BoxIcons/boxicons.css" />
	<link rel="stylesheet" href="editor/simplemde.min.css"/>
    </head>
    <body>
	<%@include file="../components/navbar.jsp" %>
	<main class="add-container">
	    <form action="" method="post">
		<div class="input-field">
		    <label for="title">Title</label>
		    <input type="text" name="title" id="title" />
		</div>
		<div class="input-field" id="content" style="flex: 1">
		    <label for="content">Content</label>
		    <textarea name="content" id="content" rows="15"></textarea>
		</div>

		<button class="save-btn">Save</button>
		<a href="." class="cancel-btn">Cancel</a>
	    </form>
	</main>
    </body>
    <script src="editor/simplemde.min.js" ></script>
</html>
