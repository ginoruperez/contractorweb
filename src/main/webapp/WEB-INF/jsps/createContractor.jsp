<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Contractor</title>
</head>
<body>

	<form action="saveCon" method="post">
		<pre>
		Id: <input type="text" name="id"  />
		Name: <input type="text" name="name" /> 
		Location:<input type="text" name="location" />
		Specialties: <input type="text" name="specialties" /> 
		Size: <input type="text" name="size" /> 
		Rate: <input type="text" name="rate" />
		Owner: <input type="text" name="owner" />
		<input type="submit" value="save" />
		</pre> 
	</form>
	${msg}
 
 <a href="displayContractors">View All</a>
 
</body>
</html>