<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>New Person</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h1>New Person</h1>
		<div>
			<form:form action="/persons/create" method="post" modelAttribute="person">
				<p>
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName"/>
				</p>
				<p>
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName"/>
				</p>
				<form:button>Create</form:button>
			</form:form>
		</div>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>