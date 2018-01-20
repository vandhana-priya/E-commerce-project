<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ include file="navigation.jsp" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    <%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<style>
/* Full-width input fields */
input[type=text],input[type=number], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
.container {
    padding: 16px;
}

body {
    
    background-color: #C0C0C0;
    background-repeat: no-repeat;
    background-size: cover;
}

</style>

<body>
<c:set value="${pageContext.request.contextPath }" var="context"></c:set>
<security:authorize access="hasRole('ROLE_ADMIN')">

<spring-form:form class="form-horizontal" action="${context}/addproduct" method="POST" modelAttribute="product" enctype="multipart/form-data">


<div class="container">
<spring-form:label path="productName"><b>Product Name:</b></spring-form:label>
<spring-form:input type="text"  path="productName" placeholder="Enter product name" name="productName" ></spring-form:input>

<spring-form:label path="category"><b>Category:</b></spring-form:label><br/>
<spring-form:select path="category">
      <spring-form:option value="0" label="--Please Select"/>
      <spring-form:options items="${categories}" itemValue="name" itemLabel="name"/>
 </spring-form:select> <br/>

  <spring-form:label path="productDesc"><b>Description:</b></spring-form:label>
<spring-form:input type="text"  path="productDesc" placeholder="Enter productDesc" name="productDesc" ></spring-form:input>


<spring-form:label path="stock"><b>Stock:</b></spring-form:label>
<spring-form:input type="number"  path="stock" placeholder="Enter stock" name="stock" ></spring-form:input>


<spring-form:label path="price"><b>Price:</b></spring-form:label>
<spring-form:input type="number"  path="price" placeholder="Enter price" name="price" ></spring-form:input>


<div class="clearfix">

<input type= "submit" value="Register"/>
</div>
</div>

</spring-form:form>
</security:authorize>
<security:authorize access="isAuthenticated()">
 <table class="table table-hover">
          <tr>
         <th>productId</th>
          <th>productName</th>
          <th>file</th>
          <th>productDesc</th>
          <th>category</th>
          <th>stock</th>
          <th>price</th>
          
          
          </tr>
          
          <c:forEach items="${products}" var="product">
          <tr>
            <c:url value="/resources/images/${product.productId}.jpg" var="url" />
             <td>${product.productId}</td>
             <td>${product.productName}</td>
             <td><img src="${url}" value="${pageContext.request.contextPath }" width="150" align="middle" height="150" ></td>
             <td>${product.productDesc}</td>
             <td>${product.category}</td>
             <td>${product.stock}</td>
             <td>${product.price}</td>
             
            <security:authorize access="hasRole('ROLE_ADMIN')"> 
           <td> <a href="<c:url value='/editproduct/${product.productId}'/>">
                   <button type="submit" class="btn btn-basic">edit</button></a></td>
             <td><a href="deleteproduct/${product.productId}">
             <button type="submit" class="btn btn-basic">Delete</button></a>
             </td>
             </security:authorize>
             <td><a href="<c:url value='/addtocart/${product.productId}'/>">
                   <button type="submit" class="btn btn-basic">Add To Cart</button></a></td>
             </tr>
             </c:forEach>
             
          </table>
          </security:authorize>
</body>
</html>  