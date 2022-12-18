<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Contractor</title>
</head>

<h1>Adding Contractor Form</h1>

<body>

	<form action="saveCon" method="post">
		<pre>
		
		 <table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" size="50" /></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><input type="text" name="location" size="50"  /></td>
				</tr>
				<tr>
					<td>Specialties</td>
					<td><input type="text" name="specialties"  size="50"  /></td>
				</tr>
					<tr>
					<td>Size</td>
					<td><input type="text" name="size" /></td>
				</tr>
				<tr>
					<td>Rate</td>
					<td><input type="text" name="rate" /></td>
				</tr>
				<tr>
					<td>Owner</td>
					<td><input type="text" name="owner" size="50"  /></td>
				</tr>
		</table>
		<input type="submit" value="Save" />
		
		
		
		<!-- 		
		Name: <input type="text" name="name" /> 
		Location:<input type="text" name="location" />
		Specialties: <input type="text" name="specialties" /> 
		Size: <input type="text" name="size" /> 
		Rate: <input type="text" name="rate" />
		Owner: <input type="text" name="owner" />
		<input type="submit" value="save" />
		 -->
		
		</pre>


	</form>

	<a href="displayContractors">View All</a>

</body>
</html>