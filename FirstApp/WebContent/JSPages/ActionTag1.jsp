<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isEL%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ActionTag1</title>
</head>
<body>
	<h2>ActionTag1</h2>
	
	Include Tag
	<h2><jsp:include page="/JSPages/ActionTag2.jsp"></jsp:include></h2>
	end of include tag
	
	<jsp:forward page="/JSPages/ActionTag2.jsp">
		<jsp:param value="riddhiben" name="name"/>
	</jsp:forward>
</body>
</html>