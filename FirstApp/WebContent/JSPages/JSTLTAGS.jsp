<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL</title>
</head>
<body>
	<h1>JSTL (JSP Standard Tag Library)</h1>
	
	<c:out value="${ 'Hello Java' }"/>
	<c:set var="income" scope="session" value="${ 40000*4 }"/>
	<br>
	<c:if test="${ income > 80000 }">
		<c:out value="${ 'TRUE' }"/>
	</c:if>
	<br>
	<c:forTokens items="Ramesh_Suresh Mahesh,ABCD" delims=", " var="names">
		<c:out value="${ names }"/>
		<br>
	</c:forTokens>
</body>
</html>

<!-- 
Core Tags: catch, choose, if, import, forEach, forTokens, out, otherwise, param, redirect, remove, set, url, when
 -->