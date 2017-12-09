<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <%@taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>VICTORIA WATCHES-Home page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
var check = function(){
	var password=document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	if(password==confirmpassword){
		document.getElementById('message').style.color='green';
		document.getElementById('message').innerHTML='Matching';
	}
	else{
		document.getElementById('message').style.color='red';
		document.getElementById('message').innerHTML='Not Matching';
		return "signup";
	}
}
</script>
</head>
<body>
<div class="jumbotron">
   <header>
    <img src="resources/images/watch1.jpg">
    <h1   style=" float:middle; display:inline"  style="font-size:800%;" style="generic-family:Lucida Grande;">   VICTORIA WATCHES</h1>
   </header>
  </div>

  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="homepage.html">Victoria Watches</a>
    </div>
    <ul class="nav navbar-nav">
      
      <li><a href="signup">Sign Up</a></li>
      <li><a href="login">Login</a></li>
      
    </ul>
  </div>
</nav>
</body>
    
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn,.signupbtn {
    float: left;
    width: 50%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
<body>

<h2>SignUp Form</h2>
<c:set value="${pageContext.request.contextPath }" var="context"></c:set>
<spring-form:form class="control-label" action="${context}/add" method="POST" modelAttribute="User" >

  <div class="container">
	<spring-form:label path="name"><b>Name</b></spring-form:label>
    <spring-form:input type="text"  path="name" placeholder="Enter name" name="name" ></spring-form:input>  
	<spring-form:errors path="name" id="message"/><br/>
	
	<spring-form:label path="username"><b>Username</b></spring-form:label>
    <spring-form:input type="text"  path="username" placeholder="Enter Username" name="username" ></spring-form:input>  
	<spring-form:errors path="username" id="message"/><br/>
  
    <spring-form:label path="email"><b>Email</b></spring-form:label>
    <spring-form:input type="text"  path="email" placeholder="Enter Email" name="email" ></spring-form:input>
	<spring-form:errors path="email" id="message"/><br/>

    <spring-form:label path="password"><b>Password</b></spring-form:label>
    <spring-form:input type="password" path="password" placeholder="Enter Password" name="psw" ></spring-form:input>
	<spring-form:errors path="password" id="message"/><br/>
	
    <spring-form:label path="confirmpassword"><b>Confirm Password</b></spring-form:label>
    <spring-form:input path="confirmpassword" type="password"  placeholder="confirm password" name="psw-repeat" onkeyup='check();'></spring-form:input>
    <spring-form:errors path="confirmpassword" id="message"/><br/>
    

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn" onclick="check();">Sign Up</button>
    </div>
  </div>
</spring-form:form>
</body>
</html>