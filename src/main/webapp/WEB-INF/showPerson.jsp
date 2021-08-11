<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show Person</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1><c:out value="${person.firstName} ${person.lastName}"/></h1>
		<div>
			<table>
				<tr>
					<td>License Number: </td>
					<td><c:out value="${license.number}"/></td>
				</tr>
				<tr>
					<td>State:</td>
					<td><c:out value="${license.state}"/>
				</tr>
				<tr>
					<td>Expiration Date:</td>
					<td><fmt:formatDate pattern="MM/dd/yyyy" value="${license.expirationDate}"/></td>
				</tr>
			</table>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>