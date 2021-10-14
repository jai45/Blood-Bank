<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
</head>
<body>
<%@ include file="menu.html" %>
<div class="container">
	<h3>Enter the id to de-register</h3>
	<form:form action="/delete" modelAttribute="donorObj" method="get">
		<div>
			<label for="id">User Id</label>
			<form:input path="id"/>
		</div>
		<div>
			<input class="btn btn-primary" type = "submit" value = "Delete">
		</div>
	</form:form>
</div>
</body>
</html>