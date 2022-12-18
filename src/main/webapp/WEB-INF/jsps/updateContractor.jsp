<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Contractor</title>
</head>

<h1>Update Contractor Form</h1>
<body>

	<form action="updateContractor" method="post">
		<pre>
		
		<table>
		
				<tr>
					<td>ID</td>
					<td><input type="text" name="id" value="${contractor.id}" readonly/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td> <input type="text" name="name" value="${contractor.name}"  size="50" /> </td>
				</tr>
				<tr>
					<td>Location</td>
					<td><input type="text" name="location" value="${contractor.location}"  size="50"  /></td>
				</tr>
				<tr>
					<td>Specialties</td>
					<td><input type="text" name="specialties" value="${contractor.specialties}"  size="50" /> </td>
				</tr>
					<tr>
					<td>Size</td>
					<td><input type="text" name="size" value="${contractor.size}" /> </td>
				</tr>
				<tr>
					<td>Rate</td>
					<td><input type="text" name="rate" value ="${contractor.rate}"/></td>
				</tr>
				<tr>
					<td>Owner</td>
					<td> <input type="text" name="owner" value="${contractor.owner}"  size="50"/></td>
				</tr>
		</table>
		<input type="submit" value="Save" />
		
		<!--
		 
		Id: <input type="text" name="id" value="${contractor.id}" readonly/>
		Name: <input type="text" name="name" value="${contractor.name}"/> 
		Location:<input type="text" name="location" value="${contractor.location}" />
		Specialties: <input type="text" name="specialties" value="${contractor.specialties}"/> 
		Size: <input type="text" name="size" value="${contractor.size}" /> 
		Rate: <input type="text" name="rate" value ="${contractor.rate}"/>
		Owner: <input type="text" name="owner" value="${contractor.owner}"/>
		<input type="submit" value="save" />
		
		 -->
		
		</pre>
	</form>

</body>
</html>