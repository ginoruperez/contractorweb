<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Contractor</title>
</head>
<body>

	<form action="searchContractor" method="post">
		<pre>
		Name: <input type="text" name="name" value="${contractor.name}"/> 
		Location:<input type="text" name="location" value="${contractor.location}" />
		Specialties: <input type="text" name="specialties" value="${contractor.specialties}"/> 
		Rate: <input type="text" name="rate" value ="${contractor.rate}"/>
		<input type="submit" value="Search" />
		
		</pre> 
	</form>
	
</body>
</html>