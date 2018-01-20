<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="spring-form"
	uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navigation.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootsrap.min.css">
<!-- jquery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.boootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<c:set value="${pageContext.request.contextPath}" var="context"></c:set>
<body>
	<center>
		<h2>User Database</h2>
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h1 style="" : white; font-style: oblique;" class="entry-title">
					</h1>
				</div>
			</div>
		</div>
	</center>
	<table class="table table-hover">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>username</th>
			<th>email</th>
			<th>password</th>
			<th>confirmpassword</th>


		</tr>

		<c:forEach items="${Users}" var="User">
			<tr>
				<td>${User.id}</td>
				<td>${User.name}</td>
				<td>${User.username}</td>
				<td>${User.email}</td>
				<td>${User.password}</td>
				<td>${User.confirmpassword}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>