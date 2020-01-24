<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<div>
		<p>Cart of <%= request.getAttribute("accountCart") %></p>
	</div>
	<table>
	  <tr>
	    <th>ID Car</th>
	    <th>Name Car</th>
	  </tr>
		<c:forEach items="${listCar}" var="value">
			<tr>
				<td>${value.getID()}</td>
				<td>${value.getNameCar()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>