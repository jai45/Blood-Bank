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
<h3>Update the details</h3>
<div>
	<c:if test="${errorMsg.length()!=0}">
		<div class="alert alert-danger">
			<ul>
				<li >All fields are required</li>
			</ul>
		</div>
	</c:if>
</div>
<div>
	<form:form action="/updatecampform" modelAttribute="campObj" method="post">
		
		<div>
			<label for="id">Id</label>
			<form:input readonly="true" path="id"/>
		</div>
		
		<div>
			<label for="campName">Name</label>
			<form:input path="campName"/>
			<form:errors path="campName" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="location">location</label>
			<form:input path="location"/>
		</div>
		<div>
			<label for="dateOfHeld">Date of Held</label>
			<form:input type="date" path="dateOfHeld"/>
		</div>
		<div>
			<input class="btn btn-primary" type = "submit" value = "Update">
		</div>
	</form:form>
</div>
</div>
</body>
</html>