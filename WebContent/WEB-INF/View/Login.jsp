<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Login</h1>
	<%= request.getAttribute("Notification") != null? request.getAttribute("Notification") : "" %>
	<form action="ControllerLogin" method="post">
		<p>Username:</p>
		<input type="text" name="username">
		<p>Password:</p>
		<input type="password" name="password">
		<div>
			<input type="submit" value="Login">
		</div>
	</form>
	
	<a href="ForwardRegister">Register</a>
</body>
</html>