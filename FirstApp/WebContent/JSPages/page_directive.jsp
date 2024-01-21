<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>page_directive.jsp</title>
</head>
<body>
	<!-- import -->
	<!--	
		<%@ /*page import="java.util.Date" */%>
		Today is <%=/* new Date()*/ %>
	-->
	
	<!--	
	<%@ /*page contentType=application/msword*/ %>
	Today is <%= /*new java.util.Date() */%>
	-->
	
</body>
</html>