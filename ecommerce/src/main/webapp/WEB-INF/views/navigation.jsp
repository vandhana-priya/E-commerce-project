<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ include file="my-navbar.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>VICTORIA WATCHES-Home page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
 <nav class="navbar my-navbar">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="homepage">
      <img id="logo" src="resources/images/logo.png" width="15%">
    </a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <security:authorize access="isAnonymous()">
      <li><a href="signup">Sign Up</a></li>
      <li><a href="login">Login</a></li>
      <li><a href="logout">logout</a></li>
      </security:authorize>
      <security:authorize access="isAuthenticated()">
      <li><a href="productform">Product</a></li>
      <li><a href="category">Category</a></li>
      <li><a href="User">User</a></li>
      </security:authorize>
      <security:authorize access="isAuthenticated()">
      <security:authentication property="principal"/>
      <li><a href="logout">Logout</a></li>
      </security:authorize>
    </ul>
  </div>
</nav>
</body>
</html>