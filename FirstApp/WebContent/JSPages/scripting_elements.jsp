<%@ page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scripting Elements</title>
</head>
<body>
	<h1>JSP Scripting Elements</h1>
	<% out.print(2*5); %>	<!-- Scriptlet Tag -->
	<%
		String n = request.getParameter("name");
		out.print("<br>Name: " + n);
	%>
	<br>Mail: <%= request.getParameter("mail") %>	<!-- Expression Tag -->
	<br>Contact: <%= request.getParameter("contact") %>
	
	<!-- Declaration Tag -->
	<%! 
		int data = 89; 
		
		int cube(int n) {
			return n*n*n;
		}
		
		void fun(JspWriter out) throws Exception {
			out.write("This is fun");
		}
		
		void fun1() {
			%><br><% out.write("This is fun1"); %> <%!
		}
	%>	
	<br>
	<% fun(out); %>
	<br>
	<%= "Cube of 3 is " + cube(3) %>
	<br>
	<%= "Divide by zero " + 5/0 %>
	
</body>
</html>