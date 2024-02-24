<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.CharacterBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Character</title>
</head>
<body>
	<h1>Edit Character</h1>
	<form action="updateCharacter" method="post">
		<% CharacterBean character = (CharacterBean) request.getAttribute("character"); %>
		<% if(character != null) { %>
			<input type="hidden" name="id" value="<%= character.getId() %>">
			<label for="characterName">Character Name:</label>
            <input type="text" id="characterName" name="characterName" value="<%= character.getCharacterName() %>"><br>
            <label for="creator">Creator:</label>
            <input type="text" id="creator" name="creator" value="<%= character.getCreator() %>"><br>
            <input type="submit" value="Update">
		<% } else { %>
				<p style="color:'red';">Error: Character not Found</p>
		<% } %>
	</form>
</body>
</html>