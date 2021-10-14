<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
</head>
<body>
<%@include file="menu.html" %>

<c:if test="${fn:length(donors) == 0}">
	<h2>No Donors are Eligible</h2>
</c:if>
<c:if test="${fn:length(donors) > 0}">
<h2>Eligible Donors </h2>
<table class="table">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Blood Group</th>
		<th>Location</th>
		<th>Email</th>
		<th>Date</th>
	</tr>
	<c:forEach items="${donors}" var="donor">
		<tr>
			<td>${donor.id}</td>
			<td>${donor.donorName}</td>
			<td>${donor.age}</td>
			<td>${donor.bloodGroup}</td>
			<td>${donor.location}</td>
			<td>${donor.email}</td>
			<td>${donor.lastDonationDate}</td>
		</tr>
	</c:forEach>
</table>
</c:if>
</body>
</html>