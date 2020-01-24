<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register</h1>
	<form action="ControllerRegister" method="post">
		<p>Username:</p>
		<input type="text" name="username">
		<p>Password:</p>
		<input type="password" name="password">
		<p>Confirm password:</p>
		<input type="password" name="confirm">
		<div>
			<input type="submit" value="Register">
		</div>
	</form>
	<%= request.getAttribute("NotificationRegister")!= null? request.getAttribute("NotificationRegister") : "" %>
	<div>
		<a href="Forward">Back to login</a>
	</div>
</body>
</html>