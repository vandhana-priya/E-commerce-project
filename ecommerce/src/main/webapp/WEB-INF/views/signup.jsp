<%@ include file="navigation.jsp" %>
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
function check(){
	var password=document.getElementById("password").value;
	var confirmpassword = document.getElementById("confirmpassword").value;
	if(password.value!=confirmpassword.value){
		confirmpassword.setCustomValidity("passwords donot match");
	}
}
</script>
</head>
<style>
body {
    height:100%;
   width:100%;
    background: url(resources/images/bkgrnd7.jpg);
    background-repeat: no-repeat;
    background-size: cover;
}</style>
<body>

</body>
    
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid rgba(255,255,255,0.4);
    box-sizing: border-box;
    
    background-color: rgba(255,255,255,0.0);
}

/* Set a style for all buttons */
button {
    background-color: rgba(255,255,255,0.3);
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

/* Extra styles for the cancel button */
/* .cancelbtn {
    padding: 14px 20px;
    background-color: rgba(255,255,255,0.3);
} */

/* Float cancel and signup buttons and add an equal width */
.signupbtn {
    float: center;
    width: 100%;
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

<h2  style="color:white">SignUp Form</h2>
<c:set value="${pageContext.request.contextPath }" var="context"></c:set>
<spring-form:form class="control-label" action="${context}/add" method="POST" modelAttribute="User" >

  <div class="container">
	<spring-form:label path="name" style="color:white" ><b>Name</b></spring-form:label>
    <spring-form:input type="text"  path="name" placeholder="Enter name" style="color:white" name="name" ></spring-form:input>  
	<spring-form:errors path="name" id="message"/><br/>
	
	<spring-form:label path="username"  style="color:white"><b>Username</b></spring-form:label>
    <spring-form:input type="text"  path="username" placeholder="Enter Username" style="color:white" name="username" ></spring-form:input>  
	<spring-form:errors path="username" id="message"/><br/>
  
    <spring-form:label path="email" style="color:white"><b>Email</b></spring-form:label>
    <spring-form:input type="text"  path="email" placeholder="Enter Email" style="color:white" name="email" ></spring-form:input>
	<spring-form:errors path="email" id="message"/><br/>

    <spring-form:label path="password"  style="color:white"><b>Password</b></spring-form:label>
    <spring-form:input type="password" path="password" placeholder="Enter Password" style="color:white" name="psw" ></spring-form:input>
	<spring-form:errors path="password" id="message"/><br/>
	
    <spring-form:label path="confirmpassword"  style="color:white"><b>Confirm Password</b></spring-form:label>
    <spring-form:input path="confirmpassword" type="password"  placeholder="confirm password" style="color:white" onclick="check()" name="psw-repeat" ></spring-form:input>
    <spring-form:errors path="confirmpassword" id="message"/><br/>
    

    <div class="clearfix">
      <br/> 
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</spring-form:form>
</body>
</html>