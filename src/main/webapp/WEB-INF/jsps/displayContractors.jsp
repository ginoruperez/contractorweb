<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of Contractors</title>
</head>
<body>
	<h2>Contractors:</h2>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>location</th>
			<th>specialties</th>
			<th>size</th>
			<th>rate</th>
			<th>owner</th>

		</tr>
		<c:forEach items="${contractors}" var="contractor">
			<tr>
				<td>${contractor.id}</td>
				<td>${contractor.name}</td>
				<td>${contractor.location}</td>
				<td>${contractor.specialties}</td>
				<td>${contractor.size}</td>
				<td>${contractor.rate}</td>
				<td>${contractor.owner}</td>
				<td><a href="deleteContractor?id=${contractor.id}">Delete</a></td>
				<td><a href="showUpdate?id=${contractor.id}">Update</a></td>
				<td><a href="generatePdf?id=${contractor.id}">Report</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="showCreate" >Add Contractor</a>
	<a href="index.html" >Back to Home Page</a>

</body>
</html>