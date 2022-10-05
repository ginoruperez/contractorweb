<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to Contractor Web</title>
</head>
<h2>User Login Page</h2>
<body>
<form action="loginResult" method ="post">
<pre>
 User Name : <input type="text" name="email"/>
 Password : <input type="text" name ="password"/>
 <input type="submit" value="login"/>
 ${msg}
 
 </pre>
 <a href="createUser">Register New User</a>

</form>

</body>
</html>