<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Contractor</title>
</head>
<body>

	<form action="updateContractor" method="post">
		<pre>
		Id: <input type="text" name="id" value="${contractor.id}" readonly/>
		Name: <input type="text" name="name" value="${contractor.name}"/> 
		Location:<input type="text" name="location" value="${contractor.location}" />
		Specialties: <input type="text" name="specialties" value="${contractor.specialties}"/> 
		Size: <input type="text" name="size" value="${contractor.size}" /> 
		Rate: <input type="text" name="rate" value ="${contractor.rate}"/>
		Owner: <input type="text" name="owner" value="${contractor.owner}"/>
		<input type="submit" value="save" />
		
		</pre> 
	</form>
	
</body>
</html>