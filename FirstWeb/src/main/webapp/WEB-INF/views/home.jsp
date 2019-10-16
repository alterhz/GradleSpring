<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Spittr</title>
</head>
<body>
	<a href="<s:url value="/spittles" />">Spittles</a> | 
	
	<s:url value="/spitter/register" var="registerUrl" />
	<a href="${registerUrl}">Register</a> | 

</body>
</html>