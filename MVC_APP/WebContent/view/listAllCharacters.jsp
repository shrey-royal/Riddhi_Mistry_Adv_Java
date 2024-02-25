<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.bean.CharacterBean" %>
<%@ page import="com.dao.CharacterDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cartoon Characters</title>
<style>
	table {
		width: 100%;
		border-collapse: collapse;
	}
	
	th, td {
		border: 1px solid #ddd;
		padding: 8px;
		text-align: left;
	}
	
	th {
		background-color: #f2f2f2;
	}
	
	.btn {
		background-color: #4CAF50;
		border: none;
		color: white;
		padding: 10px 20px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
		border-radius: 5px;
	}
</style>
</head>
<body>
	<h2>Character Data</h2>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Character Name</th>
				<th>Creator</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<% 
				CharacterDao dao = new CharacterDao();
				ArrayList<CharacterBean> characters = dao.getAllCharacters();
				for(CharacterBean character : characters) {
			%>
			
			<tr>
				<td><%= character.getId() %></td>
				<td><%= character.getCharacterName() %></td>
				<td><%= character.getCreator() %></td>
				<td><a href="/MVC_APP/edit?id=<%= character.getId() %>" class="btn">Edit</a> | <a href="/MVC_APP/delete?id=<%= character.getId() %>" class="btn">Delete</a></td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>