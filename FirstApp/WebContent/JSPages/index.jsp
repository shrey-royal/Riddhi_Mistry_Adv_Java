<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Index Page</title>
<style type="text/css">
	* {
		margin: 20px;
	}
	body {
		font-size: 40px;
	}
</style>
</head>
<body>
	<h1>Welcome to JSP</h1>
	<p><%= Calendar.getInstance().getTime() %></p>
	<br><br><br>
	<ol type="i">
		<li><a href="/FirstApp/basic_forms/inputData.html">scripting_elements</a></li>
		<li><a href="/FirstApp/JSPages/page_directive.jsp">JSP Page Directive</a></li>
		<li><a href="/FirstApp/JSPages/include_directive.jsp">JSP Include Directive</a></li>
		<li><a href="/FirstApp/JSPages/ActionTag1.jsp">ActionTag1</a></li>
		<li><a href="/FirstApp/JSPages/ActionTag2.jsp">ActionTag2</a></li>
		<li><a href="/FirstApp/JSPages/JSTLTAGS.jsp">JSTL Tags</a></li>
		<li><a href="/FirstApp/JSPages/CustomTag.jsp">Custom Tags</a></li>
		
		
	</ol>
</body>
</html>