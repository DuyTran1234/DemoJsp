<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Car</title>
</head>
<body>
	<h1>Welcome <%= session.getAttribute("account") %></h1>
	<form action="ControllerLogout" method="get">
		<input type="submit" value="Logout">
	</form>
	<br>
	<br>
	
	<div>
				
		<form action="ControllerAddCart" method="post">
			<select name="dropdownlist">
				<c:forEach items="${listCar}" var="value">
					<option value="${value.getID()}">${value.getNameCar()}</option>
				</c:forEach>
			</select>
			<br>
			<br>
			<input type="submit" value="Add Cart">
		</form>
		<br>
		<br>
		<%= request.getAttribute("NotificationCart")!=null ? request.getAttribute("NotificationCart") : "" %>
	</div>
	<br>
	<br>
	
	<div>
		<a href="ControllerCart">Show Cart</a>
	</div>
</body>
</html>

