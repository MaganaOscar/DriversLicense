<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>New License</h1>
		<div>
			<form action="/licenses/create" method="post">
				<p>
					<label for="person">Person: </label>
					<select name="person">
						<c:forEach var="person" items="${people}">
							<option value="${person.id}"><c:out value="${person.firstName} ${person.lastName}"/></option>>
						</c:forEach>
					</select>
				</p>
				<p>
					<label for="state">State: </label>
					<input type="text" name="state">
				</p>
				<p>
					<label for="date">Expiration Date: </label>
					<input type="date" name="date">
				</p>
				<input type="submit" value="Create">
			</form>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>