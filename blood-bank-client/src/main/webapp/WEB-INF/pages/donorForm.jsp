<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width"/>
<title>Blood Bank</title>
<style type="text/css">

</style>
</head>
<body>
<%@ include file="menu.html" %>
<ul>
<li> <a class="btn btn-danger" href="donorderegistration">Donor De-registration</a></li>
<li> <a class="btn btn-success" href="update">Update Donor details</a></li>
</ul>
<div class="container">
<div>
	<c:if test="${errorMsg.length()!=0}">
		<div class="alert alert-danger">
		This can be caused by
			<ol >
				<li >All fields are required</li>
				<li > Age between 18 and 70 </li>
				<li >email must be unique</li>
			</ol>
		</div>
	</c:if>
</div>
<div>
	<h3>Enter the details to register as donor</h3>
	<form:form action="/donor" modelAttribute="donorObj" method="post">
		<div>
			<label for="donorName">Name</label>
			<form:input path="donorName"/>
			<form:errors path="donorName" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="age">Age</label>
			<form:input path="age"/>
			<form:errors path="age" cssStyle="color:#ff0000;"></form:errors>
		</div>
		<div>
			<label for="location">location</label>
			<form:input path="location"/>
		</div>
		<div>
			<label for="email">email</label>
			<form:input path="email"/>
		</div>
		<div>
			<label for="bloodGroup">Blood Group</label>
			<form:select path="bloodGroup">
				<form:option value="O+">O+</form:option>
				<form:option value="O-">O-</form:option>
				<form:option value="A+">A+</form:option>
				<form:option value="A-">A-</form:option>
				<form:option value="B+">B+</form:option>
				<form:option value="B-">B-</form:option>
				<form:option value="AB+">AB+</form:option>
				<form:option value="AB-">AB-</form:option>
			</form:select>
		</div>
		<div>
			<label for="lastDonationDate">Last Donation Date</label>
			<form:input type="date" path="lastDonationDate"/>
		</div>
		<div>
			<input class="btn btn-primary" type = "submit" value = "Register">
		</div>
	</form:form>
</div>
</div>
</body>
</html>