<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>include_directive.jsp</title>
</head>
<body>
	<%@ include file="/JSPages/page_directive.jsp" %>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:out value="${'Welcome to TAGLIB/EL'}"></c:out>
</body>
</html>